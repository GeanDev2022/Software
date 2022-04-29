import React, { useEffect } from 'react'
import { fetchBackend } from '../../helpers/fetch';
import { useForm } from '../../hooks/useForm';

export const UserCalification = () => {


    const [{doctor}, , setdoctor] = useForm({
        doctor : ""
    })

    useEffect(async () => {
        const resp = await fetchBackend(`listarDocTop`, {})
        const data = await resp.text();
        const doct  = data.split("|");
        console.log(doct[1])
        setdoctor({
            doctor : doct[1]
        })

        console.log(doctor)
    }, [])
    

  return (
    <div className='container'>

<table className="table table-dark table-hover mt-5  ">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Doctor</th>
        </tr>
    </thead>
    <tbody>
        <tr>
    <td>1</td>
    <td>{doctor}</td>
        </tr>
    </tbody>
  </table>
    </div>
  )
}
