import Swal from "sweetalert2";
import { handlelist } from "../helpers/data";
import { fetchBackend } from "../helpers/fetch";
import { types } from "../types/types";

export const startAppointment = (appointment) => {
    return async (dispatch) => {
        //guardamos la cita en la bd
      
        const resp = await fetchBackend("registroCita", appointment, 'POST')
        const data = await resp.text();
        if(data === 'OK')
        {
            Swal.fire('Success', 'Registro exitoso!', 'success')
        }else{
            Swal.fire('Error', 'Error, intente mas tarde', 'error')
        }
       
        dispatch(isappointment(appointment));
    }
}

export const listAppointment = () => {
    return async(dispatch) => {
         try {
            const resp = await handlelist('listarCita')
            dispatch(appointmentLoad(resp))
        } catch (error) {
            console.error(error)
        }
    }
}


export const isappointment = ({fechaCita, Direccion})=>
({ 
    type : types.appointment,
    payload: {
        fechaCita,
        Direccion
    }
} )


export const getItemAppointment = (id, citaId, fechaCita,  direccionCita, servicio, usuario, doctor)=>
({
    type: types.itemAppointment,
    payload: {
        id, citaId, fechaCita,  direccionCita, servicio, usuario, doctor
    }
})


export const appointmentLoad = (appointmentload) => ({
    type: types.appointmentload,
    payload: appointmentload
})
