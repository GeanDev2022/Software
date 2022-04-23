import React from 'react'
import { useDispatch } from 'react-redux'
import { startRegister } from '../../actions/auth'
import { useForm } from '../../hooks/useForm'

export const RegisterScreen = () => {


    const dispatch = useDispatch()

  const [user, handleOnChange] = useForm({
    cedulaPersona: 1010111,
    celularPersona: 15225,
    nombrePersona: 'Samantha',
    direccionPersona: 'norte',
    emailUsuario: 'Sam@email.com',
    tipoUsuario: 1,
    contrasenaUsuario: '123456',
  })

  const {
    cedulaPersona,
    celularPersona,
    nombrePersona,
    direccionPersona,
    emailUsuario,
    tipoUsuario,
    contrasenaUsuario,
  } = user


  const handleRegister = (e) => {
    e.preventDefault()
    dispatch(startRegister(user));
  }


  return (
    <div className="container">
      <h1 className='h1-register my-3 h2-color'>Registro</h1>
      <div className="border div-form">
        <form onSubmit={handleRegister}>
          <input
            className="form-control"
            type="number"
            name="cedulaPersona"
            placeholder="Cedula"
            onChange={handleOnChange}
            value={cedulaPersona}
            autoComplete="off"
          />
          <br />

          <input
            className="form-control"
            type="text"
            name="nombrePersona"
            placeholder="Nombre"
            onChange={handleOnChange}
            value={nombrePersona}
            autoComplete="off"
          />
          <br />
          {/* <input
            className="form-control"
            type="date"
            name="FechaNacimiento"
            placeholder="FechaNacimiento"
            onChange={handleOnChange}
            value={FechaNacimiento}
            autoComplete="off"
          />
          <br /> */}
          <input
            className="form-control"
            type="text"
            name="direccionPersona"
            placeholder="Direccion"
            onChange={handleOnChange}
            value={direccionPersona}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="email"
            name="emailUsuario"
            placeholder="Correo"
            onChange={handleOnChange}
            value={emailUsuario}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="number"
            name="celularPersona"
            placeholder="Celular"
            onChange={handleOnChange}
            value={celularPersona}
            autoComplete="off"
          />
          <br />
          <input
            className="form-control"
            type="number"
            name="tipoUsuario"
            placeholder="TipoUsuario"
            onChange={handleOnChange}
            value={tipoUsuario}
            autoComplete="off"
          />
          <br />
          {/* <input
            className="form-control"
            type="text"
            name="Username"
            placeholder="Username"
            onChange={handleOnChange}
            value={Username}
            autoComplete="off"
          />
          <br /> */}
          <input
            className="form-control"
            type="password"
            name="contrasenaUsuario"
            placeholder="Password"
            onChange={handleOnChange}
            value={contrasenaUsuario}
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
