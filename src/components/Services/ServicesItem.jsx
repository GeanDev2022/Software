import React from 'react'
import { useDispatch } from 'react-redux'
import { getItemService, isvalidate } from '../../actions/servicesAction';

export const ServicesItem = ({ i, nombreServicio, precio, tipoServicio,servicioId }) => {

  const dispatch = useDispatch();
  const handleItem = () => {
 
    dispatch(getItemService(i, nombreServicio, precio, tipoServicio, servicioId));
    dispatch(isvalidate(true));
  }

  return (
    <tr>
      <th scope="row">{i}</th>
      <td>
        <button className="btn btn-primary" onClick={handleItem}>Seleccionar</button>
      </td>
      <td>{nombreServicio}</td>
      <td>{precio}</td>
      {(tipoServicio===1)?<td>{'Virtual'}</td>:<td>{'Presencial'}</td>}
    </tr>
  )
}
