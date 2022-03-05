import { types } from "../types/types";

export const startAppointment = (appointment) => {
    return (dispatch) => {
        //guardamos la cita en la bd
        
        dispatch(isappointment(appointment));
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


export const getItemAppointment = (id, fechaCita, Direccion)=>
({
    type: types.itemAppointment,
    payload: {
        id, fechaCita, Direccion
    }
})

