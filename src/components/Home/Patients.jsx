import React from 'react'
import { PatientsList } from './PatientsList'

export const Patients = () => {

    //data momentanea
    const data= [{
        nombre: 'Jeisson',
        edad: 22,
        altura: 1.84
    },
    {
        nombre: 'Carlos',
        edad: 16,
        altura: 1.78
    },
    {
        nombre: 'Samantha',
        edad: 25,
        altura: 1.63
    },
    {
        nombre: 'Claudia',
        edad: 53,
        altura: 1.55
    }]



    return (
        <div className='container'>
            <PatientsList data={data}/>
        </div>
    )
}
