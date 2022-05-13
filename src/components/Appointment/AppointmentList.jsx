import React from 'react'
import { AppointmentItem } from './AppointmentItem'

export const AppointmentList = ({data}) => {


  return (
    <table className="table table-dark table-hover mt-5 ">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Seleccionar</th>
          <th scope="col">Fecha de la cita</th>
          <th scope="col">Dirección</th>
          <th scope="col">Servicio </th>
          <th scope="col">Usuario </th>
          <th scope="col">Doctor </th>
     

        </tr>
      </thead>
      <tbody>
        {data.map((values, i) => (

           <AppointmentItem key={i} i={i} {...values} />
        ))}
      </tbody>
    </table>
  )
}
