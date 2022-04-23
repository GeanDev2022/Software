import Swal from "sweetalert2";
import { handlelist } from "../helpers/data";
import { fetchBackend } from "../helpers/fetch";
import { types } from "../types/types";

export const startComments = (comment) => {
    return async (dispatch) => {
        //guardamos la cita en la bd
      
        const resp = await fetchBackend("registroComentario", comment, 'POST')
        const data = await resp.text();
        if(data === 'OK')
        {
            Swal.fire('Success', 'Registro exitoso!', 'success')
        }else{
            Swal.fire('Error', 'Error, intente mas tarde', 'error')
        }
       
        dispatch(isComments(comment));
    }
}

export const listComments = () => {
    return async(dispatch) => {
         try {
            const resp = await handlelist('listarComentarios')
            dispatch(CommentsLoad(resp))
        } catch (error) {
            console.error(error)
        }
    }
}


export const isComments = ({calificacion, resenaComentario,usuario, cita})=>
({ 
    type : types.comment,
    payload: {
        calificacion, resenaComentario,usuario, cita
    }
} )


export const getItemComments = (comentarioId, calificacion, resenaComentario,usuario, cita)=>
({
    type: types.itemComment,
    payload: {
        comentarioId, calificacion, resenaComentario,usuario, cita
    }
})


export const CommentsLoad = (commentLoad) => ({
    type: types.commentload,
    payload: commentLoad
})