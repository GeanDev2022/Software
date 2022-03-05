import React, { useEffect, useState } from 'react'
import { useDispatch } from 'react-redux'
import { useSelector } from 'react-redux'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { LoginScreen } from '../components/auth/LoginScreen'
import { RegisterScreen } from '../components/auth/RegisterScreen'
import { DashBoardRouters } from './DashBoardRouters'
import { PrivateRouter } from './PrivateRouter'
import { PublicRouter } from './PublicRouter'

export const AppRouter = () => {

    const {username} = useSelector(state => state.auth)
    const [state, setstate] = useState(false);

    useEffect(() => {
        if(username)
        {
            setstate(true);
        }
        else{
            setstate(false);
        }
      
    }, [username])


    return (
        <BrowserRouter>
            <Routes>
                <Route
                    path='/auth/login'
                    element={
                        <PublicRouter auth={state}>
                            <LoginScreen />
                        </PublicRouter>
                    }
                />
                  <Route
                    path='/auth/register'
                    element={
                        <PublicRouter auth={state}>
                            <RegisterScreen />
                        </PublicRouter>
                    }
                />

                <Route
                    path='/*'
                    element={
                        <PrivateRouter auth={state}>
                            <DashBoardRouters />
                        </PrivateRouter>
                    }
                />
            </Routes>
        </BrowserRouter>
    )
}
