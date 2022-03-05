import React from 'react'
import { Navigate } from 'react-router-dom'

export const PrivateRouter = ({auth, children}) => {
    
    return auth?children:<Navigate to='/auth/login'/>
}
