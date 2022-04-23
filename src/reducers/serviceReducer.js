import React from 'react'
import { types } from '../types/types';

export const serviceReducer = (state = {}, action) => {


    switch (action.type) {
        case types.service:

            return {
                ...state,
                Service: {
                    ...action.payload.service
                }
            };

        case types.itemService:

            return {
                ...state,
                itemService: {
                    ...action.payload
                }
            };

        case types.serviceload:

            return {
                servicesload: [...action.payload]
            };
   
        default:
            return state;
    }
}
