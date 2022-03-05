import React from 'react'
import { useDispatch } from 'react-redux'
import { getItemService } from '../../actions/servicesAction';

export const ServicesItem = ({ i, nombre, Precio, TipoServicio }) => {

  const dispatch = useDispatch();
  const handleItem = () => {
    dispatch(getItemService(i, nombre, Precio, TipoServicio));
    
  }
  return (
    <tr>
      <th scope="row">{i}</th>
      <td>
        <button className="btn btn-primary" onClick={handleItem}>Seleccionar</button>
      </td>
      <td>{nombre}</td>
      <td>{Precio}</td>
      <td>{TipoServicio}</td>
    </tr>
  )
}
