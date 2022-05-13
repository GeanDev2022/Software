import React from 'react'
import { useDispatch } from 'react-redux';
import { getItemComments } from '../../actions/commentsAction';
import { isvalidate } from '../../actions/servicesAction';

export const CommentItem = (value) => {
    console.log(value)
    const dispatch = useDispatch();
    const handleItem = () => {
   
       dispatch(getItemComments( value[0], value[1], value[3], value[4] , value[2]));
      dispatch(isvalidate(true));
    }

  return (
   
      <tr>
      <th scope="row">{value.i}</th>
      <td>
        <button className="btn btn-primary  btn btn--dark" onClick={handleItem}>Seleccionar</button>
      </td>
      <td>{value[3]}</td>
      <td>{value[4]}</td>
      <td>{value[2]}</td>
     
    </tr>
  )
}
