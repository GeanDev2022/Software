import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { startService } from '../../actions/servicesAction'
import { useForm } from '../../hooks/useForm'
import { ServicesList } from './ServicesList'

export const Services = () => {
  const dispatch = useDispatch()
  const { itemService } = useSelector((state) => state.Service)
  const [services, handleOnChange, setService] = useForm({
    Nombre: 'consulta de pediatria',
    Precio: 12000,
    TipoServicio: 2,
  })

  const { Nombre, Precio, TipoServicio } = services

  //data momentanea
  const data = [
    {
      nombre: 'consulta general de pediatria',
      Precio: 2200,
      TipoServicio: 'presencial',
    },
    {
      nombre: 'cirugia',
      Precio: 1600,
      TipoServicio: 'presencial',
    },
    {
      nombre: 'consulta general de pediatria',
      Precio: 25000,
      TipoServicio: 'presencial',
    },
    {
      nombre: 'cirugia',
      Precio: 5300,
      TipoServicio: 'presencial',
    },
  ]

  const handleService = (e) => {
    e.preventDefault()
    dispatch(startService(services))
  }

  useEffect(() => {
    if (!!itemService) {
      const { nombre, Precio: precio, TipoServicio: tipo } = itemService

      setService({
        Nombre: nombre,
        Precio: precio,
        TipoServicio: tipo,
      })
    }
  }, [itemService])

  return (
    <div className="container">
      <h1 className="h1-register my-3">Servicios</h1>
      <div className="border div-form">
        <form onSubmit={handleService}>
          <input
            className="form-control"
            type="text"
            name="Nombre"
            placeholder="Nombre"
            onChange={handleOnChange}
            value={Nombre}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="number"
            name="Precio"
            placeholder="Precio"
            onChange={handleOnChange}
            value={Precio}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="text"
            name="TipoServicio"
            placeholder="TipoServicio"
            onChange={handleOnChange}
            value={TipoServicio}
            autoComplete="off"
          />
          <br />
          <button
            type="submit"
            className="btn btn-outline-primary button-login"
          >
            Crear Servicio
          </button>
        </form>
      </div>

      <div className="container">
        <ServicesList data={data} />
      </div>
    </div>
  )
}
