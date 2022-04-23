import React from 'react'
import { useDispatch } from 'react-redux'
import { NavLink } from 'react-router-dom'
import { startLoginusernameAndPassword } from '../../actions/auth'
import { useForm } from '../../hooks/useForm'

export const LoginScreen = () => {
  const dispatch = useDispatch()
  const [state, handleOnChange] = useForm({
    username: 'gean@uq.com',
    password: '123',
  })
  const { username, password } = state

  const handleLogin = (e) => {
    e.preventDefault()
    dispatch(startLoginusernameAndPassword(username, password))
  }

  return (
    <div className="container col-4 mt-5 border rounded  login">
      <h1 className="h2 h2-color" id="tittle">
        Inicio de sesión
      </h1>
      <hr />
      <br />
      <form onSubmit={handleLogin}>
        <div className="mb-3">
          <input
            className="form-control"
            type="text"
            name="username"
            placeholder="username"
            onChange={handleOnChange}
            value={username}
            autoComplete="off"
          />
        </div>

        <div className="mb-3">
          <input
            className="form-control"
            type="password"
            name="password"
            placeholder="password"
            onChange={handleOnChange}
            value={password}
          />
        </div>

        <div className="container">
          <button type="submit" className="btn btn-primary button-login">
            Iniciar Sesión
          </button>
        </div>
      </form>
      <div className='div-register'>
        <NavLink className="button-register" to="/auth/register">
          Registrarse
        </NavLink>
      </div>
    </div>
  )
}
