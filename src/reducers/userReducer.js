import React from 'react'
import { types } from '../types/types';

export const userReducer = (state = {}, action) => {
  
    switch (action.type) {
        case types.userTop:
            
            return {
                ...state,
                userTop: [ action.payload]
            }
    
        default:
            return state;
    }
}
