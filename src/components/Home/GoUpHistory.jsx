import React from 'react'
import Swal from 'sweetalert2';
import { useForm } from '../../hooks/useForm'

export const GoUpHistory = () => {

    const [state, handleOnChange] = useForm({
        image:''
    });

    const {image }= state;

    const handleUpload =()=>{
        const validate = image.split('.')
        console.log( validate , validate[validate.length-1])
        if(validate[validate.length-1]==='pdf')
        {
            console.log('SOLO SE ACEPTAN ARCHIVOS PDF')
            Swal.fire('Exito', 'Cargado exitosamente', 'success');
        }
        else{
           
            Swal.fire('Error', 'SOLO SE ACEPTAN ARCHIVOS PDF', 'error');
        }

    }

    return (
        <div className='container upload border rounded'>
            <div className="input-group">
                <input type="file" className="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name='image' value={image} onChange={handleOnChange}/>
                <button className="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" onClick={handleUpload}>Upload</button>
            </div>
        </div>
    )
}
