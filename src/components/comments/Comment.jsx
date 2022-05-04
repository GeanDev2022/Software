import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Swal from 'sweetalert2'
import { listAppointment, listAppointmentUser } from '../../actions/appointmentAction'
import { CommentsLoad, listComments, startComments } from '../../actions/commentsAction'
import { isvalidate } from '../../actions/servicesAction'
import { fetchBackend } from '../../helpers/fetch'
import { useForm } from '../../hooks/useForm'
import { CommentList } from './CommentList'

export const Comment = () => {



    const dispatch = useDispatch()
    const { itemComment, commentload } = useSelector((state) => state.Comment)
    const { itemAppointment, appointmentUserload  } = useSelector((state) => state.Appointment)
    const { Item: validate, cedula } = useSelector((state) => state.auth)
    const [comment, handleOnChange, setComment] = useForm({
      comentarioId:0,
      calificacion: 2,
      resenaComentario: "buen servicio",
      usuario:{
        personaId: cedula
      },
      cita:{
        citaId: 0
      }
    })
    const { comentarioId, calificacion, resenaComentario, usuario, cita } = comment
    const [{direccionCita, codigoCita}, handleOnChangeASelect ] = useForm({
      direccionCita : "",
      codigoCita : 0
    })
    const {citaId} = cita;
    const [listnew, , setlistnew] = useForm({
      value: true,
    })
  
    useEffect(() => {
      setTimeout(() => {
        dispatch(listComments())
        //dispatch(listAppointment())
        dispatch(listAppointmentUser(cedula))
      }, 1000)
    }, [validate, listnew])
  
    useEffect(() => {
      if (!!itemComment) {
        const { comentarioId, calificacion, resenaComentario, usuario, cita} = itemComment
        const {personaId} = usuario
        const {citaId} = cita
        setComment({
          comentarioId,
          calificacion,
          resenaComentario,
          usuario:{
            personaId
          },
          cita:{
            citaId
          }
        })
      }
    }, [itemComment])

   

     
  
    const handleComment = (e) => {
      e.preventDefault()

      comment.cita.citaId = codigoCita
      dispatch(startComments(comment))
      setlistnew({
        listnew: true,
      })
      // setComment({
      //   comentarioId:0,
      //   calificacion: 0,
      //   resenaComentario: "",
      //   usuario:{
      //     personaId: 0
      //   },
      //   cita:{
      //     citaId: 1
      //   }
      // })
    }

    const handlecancel = () => {
        dispatch(isvalidate(false))
        // setComment({
        //   comentarioId:0,
        //   calificacion: 0,
        //   resenaComentario: "",
        //   usuario:{
        //     personaid: cedula
        //   },
        //   cita:{
        //     citaId: 2
        //   }
        // })
      }
    
      const handleDelete = async()=>
      {
        const resp = await fetchBackend(`borrarComentario/${comment.comentarioId}`, {}, 'DELETE')
        const data = await resp.text();
        if(resp.status === 200)
        {
          Swal.fire('Success', 'Registro eliminado con exito', 'success');
        }
        else{
          Swal.fire('Error', 'Error, intente nuevamente', 'error');
        }
        dispatch(isvalidate(false))
      }

      const handleUpdate = async() => {
        const resp = await fetchBackend(`actualizarComentario/${comentarioId}`, comment, 'PUT')
        const data = await resp.text();
        if(data === 'OK')
        {
          Swal.fire('Success','Registro actualizado con exito!', 'success')
        }
        else{
          Swal.fire('Error','error, intente nuevamente', 'error')
        }
        dispatch(isvalidate(false))
      }


  return (
    <div className="container">
    <h1 className="h1-register my-3">Comentarios</h1>
    <div className="border div-form">
      <form onSubmit={handleComment}>
        {comentarioId !== 0 && (
          <input
            className="form-control"
            type="text"
            disabled={true}
            name="comentarioId"
            placeholder="Nombre"
            onChange={handleOnChange}
            value={comentarioId}
            autoComplete="off"
          />
        )}
        <input
          className="form-control"
          type="number"
          name="calificacion"
          placeholder="calificacion"
          onChange={handleOnChange}
          value={calificacion}
          autoComplete="off"
        />
        <br />


        <input
          className="form-control"
          type="text"
          name="resenaComentario"
          placeholder="reseña Comentario"
          onChange={handleOnChange}
          value={resenaComentario}
          autoComplete="off"
        />
        <br />
        <select
            className="form-select"
            value={codigoCita}
            name = "codigoCita"
            onChange={handleOnChangeASelect}
          >
           
          {!!appointmentUserload&&appointmentUserload.map((values, i) => {
          
              return <option key={i} value={values[0]}> {values[1]}</option> 
             })} 
           </select>

        <br />
        {validate === false && (
          <button
            type="submit"
            className="btn btn-outline-primary button-login d-inline mx-2"
          >
            Crear Servicio
          </button>
        )}
      </form>
      {validate && (
        <button
          className="btn btn-outline-success button-login d-inline mx-2"
          onClick={handleUpdate}
        >
          Actualizar Servicio
        </button>
      )}

      {validate && (
        <button className="btn btn-outline-danger button-login d-inline mx-2"
        onClick={handleDelete}>
          Eliminar Servicio
        </button>
      )}

      {validate && (
        <button
          className="btn btn-outline-danger button-login d-inline mx-2"
          onClick={handlecancel}
        >
          Cancelar Servicio
        </button>
      )}
    </div>
    {!!commentload && (
      <div className="container">
        <CommentList data={commentload} />
      </div>
    )}
  </div>
  )
}
