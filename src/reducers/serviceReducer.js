import React from 'react'
import { types } from '../types/types';

export const serviceReducer = (state = {}, action) => {


    switch (action.type) {
        case types.service:

            return {
                Service: {
                    ...action.payload.service
                }
            };

        case types.itemService:

            return {
                itemService:{
                    ...action.payload
                }
            };


        default:
            return state;
    }
}
