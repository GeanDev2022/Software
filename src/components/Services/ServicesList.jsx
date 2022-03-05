import React from 'react'
import { ServicesItem } from './ServicesItem'

export const ServicesList = ({ data }) => {
  return (
    <table className="table table-dark table-hover mt-5 ">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Seleccionar</th>
          <th scope="col">Nombre</th>
          <th scope="col">Precio</th>
          <th scope="col">TipoServicio</th>
        </tr>
      </thead>
      <tbody>
        {data.map((values, i) => (
          <ServicesItem key={i} i={i} {...values} />
        ))}
      </tbody>
    </table>
  )
}
