import { types } from "../types/types";

export const authReducer = (state = {}, action) => {

    switch (action.type) {
        case types.login:

            return {
                username: action.payload.username,
                password: action.payload.password
            }
        case types.logout:
            return {}

        case types.register:

            return {
                username: action.payload.username,
                password: action.payload.password
            }
        default:
            return state;
    }
}
