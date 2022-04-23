import { types } from "../types/types";

export const authReducer = (state = {}, action) => {

    switch (action.type) {
        case types.login:

            return {
                cedula: action.payload.cedula,
                nombre: action.payload.nombre,
                tipousuario: action.payload.tipousuario,
                Item: false
            }
        case types.logout:
            return {}

        case types.register:

            return {
                username: action.payload.username,
                password: action.payload.password
            }

        case types.update:

            return {
                ...state,
                username: action.payload.username,
                password: action.payload.password
            }

        case types.visibleValidate:

            return {
                ...state,
                Item: action.payload.validate
            };
        default:
            return state;
    }
}
