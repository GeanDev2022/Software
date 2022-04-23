import { types } from "../types/types";


export const appointmentReducer = (state = {}, action) => {



    switch (action.type) {
        case types.appointment:

            return {
                appointment: {
                    ...action.payload
                }
            }

        case types.itemAppointment:

            return {
                ...state,
                itemAppointment: {
                    ...action.payload
                }
            };
        case types.appointmentload:

            return {
                ...state,
                appointmentload: [...action.payload]
                
            };



        default:
            return state;
    }
}
