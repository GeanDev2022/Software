import { useState } from "react"

export const useForm = (initialState = {}) => {

    const [state, setstate] = useState(initialState)


    const handleOnChange =({target})=>{
        setstate({
            ...state,
            [target.name] : target.value
        });
    }

    const handleReset = (newInitial)=>{

        setstate(newInitial)
    }

    return [state, handleOnChange,setstate,handleReset];
    
}
