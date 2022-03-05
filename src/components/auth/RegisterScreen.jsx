import React from 'react'
import { useDispatch } from 'react-redux'
import { startRegister } from '../../actions/auth'
import { useForm } from '../../hooks/useForm'

export const RegisterScreen = () => {


    const dispatch = useDispatch()

  const [user, handleOnChange] = useForm({
    Cedula: 1010111,
    Nombre: 'Samantha',
    FechaNacimiento: '10/10/2000',
    Direccion: 'norte',
    Correo: 'Sam@email.com',
    Celular: 3102569875,
    TipoUsuario: 1,
    Username: 'saman12',
    Password: '123456',
  })

  const {
    Cedula,
    Nombre,
    FechaNacimiento,
    Direccion,
    Correo,
    Celular,
    TipoUsuario,
    Username,
    Password,
  } = user


  const handleRegister = (e) => {
    e.preventDefault()
    dispatch(startRegister(user));
  }


  return (
    <div className="container">
      <h1 className='h1-register my-3'>Registro</h1>
      <div className="border div-form">
        <form onSubmit={handleRegister}>
          <input
            className="form-control"
            type="number"
            name="Cedula"
            placeholder="Cedula"
            onChange={handleOnChange}
            value={Cedula}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="text"
            name="Nombre"
            placeholder="Nombre"
            onChange={handleOnChange}
            value={Nombre}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="date"
            name="FechaNacimiento"
            placeholder="FechaNacimiento"
            onChange={handleOnChange}
            value={FechaNacimiento}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="text"
            name="Direccion"
            placeholder="Direccion"
            onChange={handleOnChange}
            value={Direccion}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="email"
            name="Correo"
            placeholder="Correo"
            onChange={handleOnChange}
            value={Correo}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="number"
            name="Celular"
            placeholder="Celular"
            onChange={handleOnChange}
            value={Celular}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="number"
            name="TipoUsuario"
            placeholder="TipoUsuario"
            onChange={handleOnChange}
            value={TipoUsuario}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="text"
            name="Username"
            placeholder="Username"
            onChange={handleOnChange}
            value={Username}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="password"
            name="Password"
            placeholder="Password"
            onChange={handleOnChange}
            value={Password}
            autoComplete="off"
          />
          <br />
          <button type="submit"  className='btn btn-outline-success button-login'>
                Registrarse
          </button>
        </form>
      </div>
    </div>
  )
}
