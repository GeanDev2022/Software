import React from 'react'
import { useDispatch } from 'react-redux';
import { getItemAppointment } from '../../actions/appointmentAction';
import {  isvalidate } from '../../actions/servicesAction';

export const AppointmentItem = ({i, citaId, fechaCita, direccionCita, servicio, usuario, doctor }) => {

    const dispatch = useDispatch()
    const handleItem = () => {
        dispatch(getItemAppointment(i, citaId, fechaCita,  direccionCita, servicio, usuario, doctor))
        dispatch(isvalidate(true));
      }
  return (
    <tr>
      <th scope="row">{i}</th>
      <td>
        <button className="btn btn-primary" onClick={handleItem}>
          Seleccionar
        </button>
      </td>
      <td>{fechaCita}</td>
      <td>{direccionCita}</td>
      <td>{servicio.nombreServicio}</td>
      <td>{usuario.emailUsuario}</td>
      <td>{doctor}</td>
    </tr>
  )
}
