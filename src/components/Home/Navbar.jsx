import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { logout } from '../../actions/auth'

export const Navbar = () => {
  const dispatch = useDispatch()

  const {nombre} = useSelector(state => state.auth)
  
  const handleLogout = () => {
    dispatch(logout())
  }
  return (
    <div className="navbar navbar-expand-lg navbar-dark bg-dark justify-content-end">
      <span className='span-color '>{nombre}</span>
      <button className="btn px-5 btn-logout" onClick={handleLogout}>
        Logout
      </button>
    </div>
  )
}
