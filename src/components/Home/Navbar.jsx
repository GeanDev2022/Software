import React from 'react'
import { useDispatch } from 'react-redux'
import { logout } from '../../actions/auth'

export const Navbar = () => {
  const dispatch = useDispatch()
  
  const handleLogout = () => {
    dispatch(logout())
  }
  return (
    <div className="navbar navbar-expand-lg navbar-dark bg-dark justify-content-end">
      <button className="btn px-5 btn-logout" onClick={handleLogout}>
        Logout
      </button>
    </div>
  )
}
