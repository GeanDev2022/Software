import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Swal from 'sweetalert2'
import {
  isvalidate,
  listService,
  startService,
  updateService,
} from '../../actions/servicesAction'
import { fetchBackend } from '../../helpers/fetch'
import { useForm } from '../../hooks/useForm'
import { ServicesList } from './ServicesList'

export const Services = () => {
  const dispatch = useDispatch()
  const { itemService, servicesload } = useSelector((state) => state.Service)
  const { Item: validate } = useSelector((state) => state.auth)
  const [services, handleOnChange, setService] = useForm({
    nombreServicio: 'consulta de pediatria',
    precio: 12000,
    tipoServicio: 1,
    servicioId: 0,
  })
  const { nombreServicio, precio, tipoServicio, servicioId } = services

  const [listnew, , setlistnew] = useForm({
    value: true,
  })

  useEffect(() => {
    setTimeout(() => {
      dispatch(listService())
    }, 1000)
  }, [validate, listnew])

  useEffect(() => {
    if (!!itemService) {
      const { nombre, Precio, TipoServicio: tipo, servicioId } = itemService
      setService({
        nombreServicio: nombre,
        precio: Precio,
        tipoServicio: tipo,
        servicioId,
      })
    }
  }, [itemService])

  const handleService = (e) => {
    e.preventDefault()
    dispatch(startService(services))
    setService({
      nombreServicio: '',
      precio: 0,
      tipoServicio: 0,
      servicioId: 0,
    })
    setlistnew({
      listnew: true,
    })
  }

  const handlecancel = () => {
    dispatch(isvalidate(false))
    setService({
      nombreServicio: '',
      precio: 0,
      tipoServicio: 0,
      servicioId: 0,
    })
  }

  const handleDelete = async()=>
  {
    const resp = await fetchBackend(`borrarServicio/${services.servicioId}`, {}, 'DELETE')
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

  const handleUpdate = () => {
    dispatch(updateService(services))
    dispatch(isvalidate(false))
  }

  return (
    <div className="container">
      <h1 className="h1-register my-3">Servicios</h1>
      <div className="border div-form">
        <form onSubmit={handleService}>
          {servicioId !== 0 && (
            <input
              className="form-control"
              type="text"
              disabled={true}
              name="servicioId"
              placeholder="Nombre"
              onChange={handleOnChange}
              value={servicioId}
              autoComplete="off"
            />
          )}
          <input
            className="form-control"
            type="text"
            name="nombreServicio"
            placeholder="Nombre"
            onChange={handleOnChange}
            value={nombreServicio}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="number"
            name="precio"
            placeholder="Precio"
            onChange={handleOnChange}
            value={precio}
            autoComplete="off"
          />
          <br />
          <select
            className="form-select"
            onChange={handleOnChange}
            value={tipoServicio}
            name="tipoServicio"
          >
            <option value="1">Virtual</option>
            <option value="2">Presencial</option>
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
      {!!servicesload && (
        <div className="container">
          <ServicesList data={servicesload} />
        </div>
      )}
    </div>
  )
}
