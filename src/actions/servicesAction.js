import Swal from "sweetalert2"
import { handlelist } from "../helpers/data"
import { fetchBackend } from "../helpers/fetch"
import { types } from "../types/types"

export const startService = (service) => {
    return async (dispatch) => {
        //guardamos el servicio en la bd 
        try{
            const resp = await fetchBackend('registroServicio',service,'POST')
            const data = await resp.text();
           if(data ==='OK')
           {
            dispatch(isService(service))
             Swal.fire('Success','Registro Creado con exito!', 'success'); 
           }
           else{
            Swal.fire('Error','Error, intente nuevamente mas tarde!', 'error'); 
           }
        }catch(error)
        {
            console.error(error)
        }
       
    }
}

export const updateService = (service) => {
    return async (dispatch) => {
        //guardamos el servicio en la bd 
        try{ 
            const resp = await fetchBackend(`actualizarServicio/${service.servicioId}`,service,'PUT')
            const data = await resp.text();
           if(data ==='OK')
           {
            dispatch(isService(service))
             Swal.fire('Success','Registro actualizado con exito!', 'success'); 
           }
           else{
            Swal.fire('Error','Error, intente nuevamente mas tarde!', 'error'); 
           }
        }catch(error)
        {
            console.error(error)
        }
       
    }
}

export const listService = () => {
    return async (dispatch) => {
        //listamos los servicios 
        try {
            const resp = await handlelist('listarServicios')
            dispatch(servicesLoad(resp))
        } catch (error) {
            console.error(error)
        }
    }
}

export const isvalidate = (validate) =>
({
    type: types.visibleValidate,
    payload: {
        validate
    }
})


export const getItemService = (id, nombre, Precio, TipoServicio, servicioId) =>
({
    type: types.itemService,
    payload: {
        id,
        nombre,
        Precio,
        TipoServicio,
        servicioId
    }
})


export const isService = (service) => ({
    type: types.service,
    payload: {
        service
    }
})

export const servicesLoad = (servicesload) => ({
    type: types.serviceload,
    payload: servicesload
})