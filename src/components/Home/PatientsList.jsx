import React from 'react'
import { PatientsItem } from './PatientsItem'

export const PatientsList = ({ data = []}) => {
  return (
    <table className="table table-dark table-hover mt-5 ">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Nombre</th>
          <th scope="col">Edad</th>
          <th scope="col">Altura</th>
        </tr>
      </thead>
      <tbody>
        {data.map((values, i) => (
          <PatientsItem key={i} i={i} {...values} />
        ))}
      </tbody>
    </table>
  )
}
