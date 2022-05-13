import React from 'react'
import { useDispatch } from 'react-redux';
import { getItemAppointment } from '../../actions/appointmentAction';
import {  isvalidate } from '../../actions/servicesAction';

export const AppointmentItem = (valor) => {
    const dispatch = useDispatch()
    const handleItem = () => {
           dispatch(getItemAppointment(valor.i, valor[0],new Date(valor[2]),valor[3],valor[1],valor[4],valor[5]))
        dispatch(isvalidate(true));

      }
  return (
    <tr>
      <th scope="row">{valor.i}</th>
      <td>
        <button className="btn btn-primary btn btn--dark" onClick={handleItem}>
          Seleccionar
        </button>
      </td>
      <td>{valor[2]}</td>
      <td>{valor[3]}</td>
      <td>{valor[1]}</td>
      <td>{valor[4]}</td>
      <td>{valor[5]}</td>
    </tr>
  )
}
