import React from 'react'
import { Route, Routes } from 'react-router-dom'
import { LoginScreen } from '../components/auth/LoginScreen'
import { GoUpHistory } from '../components/Home/GoUpHistory'
import { Home } from '../components/Home/Home'
import { Patients } from '../components/Home/Patients'

export const DashBoardRouters = () => {
    return (
        <Routes>
            <Route path='/home/*' element={ <Home/>  }/>
             <Route path='/' element={ <Home/>  }/>
           
        </Routes>
    )
}
