import React from 'react'
import { CommentItem } from './CommentItem'

export const CommentList = ({ data }) => {
  return (
    <div>  
      <table className="table table-dark table-hover mt-5 ">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Seleccionar</th>
        <th scope="col">IdComentario</th>
        <th scope="col">Calificacion</th>
        <th scope="col">Servicio</th>
        <th scope="col">Comentario</th>
        <th scope="col">Usuario</th>
        <th scope="col">Cita</th>
      </tr>
    </thead>
    <tbody>
      {data.map((values, i) => (
        <CommentItem key={i} i={i} {...values} />
      ))}
    </tbody>
  </table>
  </div>
  )
}
