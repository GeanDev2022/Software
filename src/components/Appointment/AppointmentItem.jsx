import React from 'react'
import { useDispatch } from 'react-redux';
import { getItemAppointment } from '../../actions/appointmentAction';

export const AppointmentItem = ({i, fechaCita, Direccion}) => {

    const dispatch = useDispatch()
    const handleItem = () => {
        dispatch(getItemAppointment(i, fechaCita, Direccion))
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
      <td>{Direccion}</td>
    </tr>
  )
}
