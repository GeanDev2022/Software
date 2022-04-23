import { types } from "../types/types";

export const commentReducer = (state = {}, action) => {

    switch (action.type) {
        case types.comment:

            return {
                comment: {
                    ...action.payload
                }
            }

        case types.itemComment:

            return {
                ...state,
                itemComment: {
                    ...action.payload
                }
            };
        case types.commentload:

            return {
                ...state,
                commentload: [...action.payload]
                
            };
        default:
            return state;
    }
}