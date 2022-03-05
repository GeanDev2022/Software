import React from 'react'

export const PatientsItem = ({i, nombre, edad, altura }) => {
    return (
      
            <tr>
                <th scope="row">{i}</th>
                <td>{nombre}</td>
                <td>{edad}</td>
                <td>{altura}</td>
            </tr>
   
    )
}
