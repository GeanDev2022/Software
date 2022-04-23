import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Swal from 'sweetalert2'
import { listAppointment, startAppointment } from '../../actions/appointmentAction'
import { isvalidate, listService } from '../../actions/servicesAction'
import { fetchBackend } from '../../helpers/fetch'
import { useForm } from '../../hooks/useForm'
import { AppointmentList } from './AppointmentList'

export const Appointment = () => {
  const dispatch = useDispatch()
  const { Item: validate, cedula } = useSelector((state) => state.auth)
  const [stateApointment, handleOnChange, setAppointment] = useForm({
    citaId : 0,
    fechaCita: '2022-10-10',
    direccionCita: 'carrera 15',
    servicio: {
      ServicioId : 1
    },
    usuario: {
      personaId: cedula
    },
    doctor: 1
  })
  const { citaId,fechaCita, direccionCita,servicioid , doctor} = stateApointment
  const { itemAppointment, appointmentload  } = useSelector((state) => state.Appointment)
  const {  servicesload } = useSelector((state) => state.Service)
  const [listnew, , setlistnew] = useForm({
    value: true,
  })

  // const data = 
  //  [{
  //     servicioId: 1,
  //     nombreServicio: "15"
  //   },
  //   {
  //     servicioId: 3,
  //     nombreServicio: "16"
  //   }
  // ]

  useEffect(() => {
    setTimeout(() => {
      dispatch(listAppointment())
      dispatch(listService())
    }, 1000)
  }, [validate, listnew])

  const [servicesList, HandleOnChangeService] = useForm({
    nombreServicio : "",
    servicioId : 0
  })

  useEffect(() => {
    if (!!itemAppointment) {
      const {citaId,  fechaCita: fecha, direccionCita: ubicacion, servicio, doctor } = itemAppointment
      const {servicioId} = servicio 
      if(fecha !== undefined && ubicacion !== undefined)
     
      setAppointment({
        citaId,
        fechaCita: fecha,
        direccionCita: ubicacion,
        servicio: {
          ServicioId: servicioId
        } ,
        usuario:{
          personaId:cedula
        },
        doctor
      })
    }
  }, [itemAppointment])

  const handleAppointment = (e) => {
    e.preventDefault()

    setAppointment({
      ...startAppointment,
      servicio: {
        ServicioId: 2
      } 
    })
  
    
  dispatch(startAppointment(stateApointment))
    setlistnew({
      listnew: true,
    })

    setAppointment({
      citaId: 0,
      fechaCita: '',
      direccionCita: '',
      servicio: {
        ServicioId: 0
      } ,
      usuario:{
        personaId:0
      },
      doctor : 1
    })
  }

  const handlecancel = () => {
    dispatch(isvalidate(false))
    setAppointment({
      citaId: 0,
      fechaCita: '',
      direccionCita: '',
      servicio: {
        ServicioId: 0
      } ,
      usuario:{
        personaId:0
      }
    })
  
  }

  const handleDelete = async()=>
  {
    const resp = await fetchBackend(`borrarCita/${citaId}`, {}, 'DELETE')
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
    const resp = await fetchBackend(`actualizarCita/${citaId}`, stateApointment, 'PUT')
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
      <h1 className="h1-register my-3">Citas</h1>
      <div className="border div-form">
        <form onSubmit={handleAppointment}>
          {citaId !== 0 && (
            <input
              className="form-control"
              type="text"
              disabled={true}
              name="citaId"
              placeholder="citaId"
              onChange={handleOnChange}
              value={citaId}
              autoComplete="off"
            />
          )}
          <input
            className="form-control"
            type="date"
            name="fechaCita"
            placeholder="Fecha de la cita"
            onChange={handleOnChange}
            value={fechaCita}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="text"
            name="direccionCita"
            placeholder="Dirección"
            onChange={handleOnChange}
            value={direccionCita}
            autoComplete="off"
          />
          <br />
          <select
            className="form-select"
            value={servicesList}
            onChange={HandleOnChangeService}
          >
           
          {/* {!!servicesload&&servicesload.map(({nombreServicio, servicioId}) => {
             //console.log(nombreServicio, servicioId)
              <option key={servicioId} value={servicioId}> {nombreServicio}</option>  })
          } */}
           </select>
            <br />

          <input
            className="form-control"
            type="number"
            name="doctor"
            placeholder="doctor"
            onChange={handleOnChange}
            value={doctor}
            autoComplete="off"
          />
     
          <br />
          {validate === false && (
            <button
              type="submit"
              className="btn btn-outline-primary button-login d-inline mx-2"
            >
              Crear Cita
            </button>
          )}
        </form>
        {validate && (
          <button
            className="btn btn-outline-success button-login d-inline mx-2"
            onClick={handleUpdate}
          >
            Actualizar Cita
          </button>
        )}

        {validate && (
          <button className="btn btn-outline-danger button-login d-inline mx-2"
          onClick={handleDelete}>
            Eliminar Cita
          </button>
        )}

        {validate && (
          <button
            className="btn btn-outline-danger button-login d-inline mx-2"
            onClick={handlecancel}
          >
            Cancelar Cita
          </button>
        )}
      </div>
      {!!appointmentload && (
         <div className="container">
         <AppointmentList data={appointmentload} />
       </div>
      )}
    </div>
  )
}
