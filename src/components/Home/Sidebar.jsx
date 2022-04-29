import React from 'react'
import { useSelector } from 'react-redux'
import { NavLink } from 'react-router-dom'

export const Sidebar = () => {


    const { tipousuario} = useSelector((state) => state.auth)

    return (
        <aside className='sidebar bg-dark'>

            <div className='pt-3 px-3'>
                <span className='h3 title'>HistMeApp</span>
            </div>

            <hr id='hr1' />
            <nav className='navbar'>
                <ul className='navbar-nav'>
                    {/* <li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/history'>
                            Subir historia clinica
                        </NavLink>
                    </li>

                    <li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/patients'>
                            Pacientes
                        </NavLink>
                    </li> */}
                   {tipousuario==='3'&& <li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/profile'>
                            Editar perfil
                        </NavLink>
                    </li>
                    
                    }

                 { tipousuario==='2'&&<li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/services'>
                            Administrador de servicios
                        </NavLink>
                    </li>}

                    {tipousuario==='3'&&<li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/appointment'>
                            Administrador de citas
                        </NavLink>
                    </li>}
                    {tipousuario==='3'&&<li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/comments'>
                            Administrador de comentarios
                        </NavLink>
                    </li>}
                            <li className='nav-item px-3'>
                        <NavLink className='nav-link navs' to='/home/userCalifications'>
                            Doctor mejor calificado
                        </NavLink>
                    </li>
                </ul>
            </nav>
        </aside >
    )
}
