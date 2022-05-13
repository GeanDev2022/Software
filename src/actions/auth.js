import { type } from "@testing-library/user-event/dist/type"
import Swal from "sweetalert2"
import { fetchBackend } from "../helpers/fetch"
import { types } from "../types/types"

export const startLoginusernameAndPassword = (username, password) => {
    return async (dispatch) => {

        const usuario = {
            emailUsuario: username,
            contrasenaUsuario: password
        }
        const resp = await fetchBackend('autenticarUsuario', usuario, 'POST')
        const data = await resp.text();
        if (data !== "no") {
            const credenciales = data.split("|");
            console.log(credenciales)
            dispatch(login(credenciales[0], credenciales[1], credenciales[2]));
        } else {

            Swal.fire('Warning', 'Credenciales incorrectas!', 'warning');
        }
    }

}


export const startRegister = (usuario) => {
    //guardado la info en la bd y despues mandamos la info al reducer
    return async (dispatch) => {
        const resp = await fetchBackend('registroUsuario', usuario, 'POST')
        //  const data = await resp.text();
 
        if (resp.status === 201) {

            Swal.fire('Success', 'Registro exitoso!', 'success');
            dispatch(register(usuario.emailUsuario, usuario.contrasenaUsuario));
        }
        else {
            Swal.fire('Error', 'Error, por favor intentar nuevamente!', 'error');
        }
    }
}

export const startUpdate = (usuario) => {
    //guardado la info en la bd y despues mandamos la info al reducer
    return async (dispatch) => {

        const resp = await fetchBackend(`actualizarUsuario/${usuario.cedulaPersona}`, usuario, 'PUT')
        const data = await resp.text();
        if (data === 'OK') {

            Swal.fire('Success', 'Actualizacion exitosa!', 'success');
            dispatch(update(usuario.emilUsuario, usuario.contrasenaUsuario));
        }
        else {
            Swal.fire('Error', 'Error, por favor intentar nuevamente!', 'error');
        }
    }
}


export const update = (username, password) =>
(
    {
        type: types.update,
        payload: {
            username,
            password
        }
    }
)


export const register = (username, password) =>
(
    {
        type: types.register,
        payload: {
            username,
            password
        }
    }
)



export const login = (cedula, nombre, tipousuario) => ({
    type: types.login,
    payload: {
        cedula,
        nombre,
        tipousuario
    }
})

export const startLogout = () => {
    return (dispatch) => {
        dispatch(logout());
    }
}


export const logout = () => ({

    type: types.logout
})