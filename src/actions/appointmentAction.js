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

export const listAppointment = (id) => {
    return async(dispatch) => {
         try {
            const resp = await fetchBackend(`listarCitasUsuariosComplete/${id}`,{})
            const data = await resp.json();
            dispatch(appointmentLoad(data))
        } catch (error) {
            console.error(error)
        }
    }
}

export const listAppointmentUser = (id) => {
    return async(dispatch) => {
         try {
        const resp = await fetchBackend(`listarCitasUsuarios/${id}`, {})
        const data = await resp.json();
        dispatch(appointmentuserLoad(data))
        } catch (error) {
            console.error(error)
        }
    }
}

export const listAppointmentUserDoctor = () => {
    return async(dispatch) => {
         try {
        const resp = await fetchBackend(`listarDoctores`, {})
        const data = await resp.json();
        dispatch(userDoctorLoad(data))
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

export const appointmentuserLoad = (appointmentuserload) => ({
    type: types.appointReload,
    payload: appointmentuserload
})

export const userDoctorLoad = (doctorload) => ({
    type: types.userDoctor,
    payload: doctorload
})
