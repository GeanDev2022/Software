import { types } from "../types/types";

export const isUserCalification = (doc)=>
({ 
    type : types.userTop,
    payload: {
        doc
    }
} )