import { type } from "@testing-library/user-event/dist/type"
import { types } from "../types/types"

export const startLoginusernameAndPassword = (username, password) => {
    return (dispatch) => {
        if (username === 'alfie solomons' && password === '12345') {
            dispatch(login(username, password));
        }
    }

}


export const startRegister = (user) => {
    //guardado la info en la bd y despues mandamos la info al reducer
    return(dispatch)=>
    {

        const {Username, Password } = user;

 
         dispatch(register(Username, Password));
    }
}

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



export const login = (username, password) => ({
    type: types.login,
    payload: {
        username,
        password
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