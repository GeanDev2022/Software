import React from 'react'
import { useDispatch } from 'react-redux';
import { getItemComments } from '../../actions/commentsAction';
import { isvalidate } from '../../actions/servicesAction';

export const CommentItem = ({i, comentarioId, calificacion, resenaComentario,usuario, cita }) => {

    const dispatch = useDispatch();
    const handleItem = () => {
   
      dispatch(getItemComments( comentarioId, calificacion, resenaComentario,usuario, cita));
      dispatch(isvalidate(true));
    }

  return (
   
          <tr>
      <th scope="row">{i}</th>
      <td>
        <button className="btn btn-primary" onClick={handleItem}>Seleccionar</button>
      </td>
      <td>{comentarioId}</td>
      <td>{calificacion}</td>
      <td>{resenaComentario}</td>
      <td>{usuario.nombre_persona}</td>
      <td>{cita.direccion_cita}</td>
     
    </tr>
  )
}
