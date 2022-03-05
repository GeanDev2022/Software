import React from 'react'
import { Navigate } from 'react-router-dom'

export const PublicRouter = ({auth,children}) => {
    
    return auth?<Navigate to='/home'/>:children
}
