import { type } from "@testing-library/user-event/dist/type"
import { types } from "../types/types"

export const startService = (service) => {
    return (dispatch) => {
       //guardamos el servicio en la bd 

       dispatch(isService(service))
    }
}

export const getItemService = (id, nombre, Precio, TipoServicio)=>
({
    type: types.itemService,
    payload: {
        id,
        nombre,
        Precio,
        TipoServicio
    }
})


export const isService = (service) =>( {
    type: types.service,
    payload: {
        service
    }
})