import React from 'react'
import { useDispatch } from 'react-redux'
import Swal from 'sweetalert2'
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
  const [validate, handleOnChangeValidate] = useForm({

    contrasenaUsuario2: '1234567'
  })
  const {contrasenaUsuario2} = validate; 


  const {
    cedulaPersona,
    celularPersona,
    nombrePersona,
    direccionPersona,
    emailUsuario,
    tipoUsuario,
    contrasenaUsuario
  } = user


  const handleRegister = (e) => {
    e.preventDefault()
    if(contrasenaUsuario === contrasenaUsuario2)
    {
     dispatch(startRegister(user));
    }
    else{
      Swal.fire("Error", "error, la contraseñas no coinciden", "error");
    }

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
          {/* <input
            className="form-control"
            type="number"
            name="tipoUsuario"
            placeholder="TipoUsuario"
            onChange={handleOnChange}
            value={tipoUsuario}
            autoComplete="off"
          /> */}

          <select
            className="form-select"
            onChange={handleOnChange}
            value={tipoUsuario}
            name="tipoUsuario"
          >
            <option value="1">Administrador</option>
            <option value="2">Medico</option>
            <option value="3">Paciente</option>
          </select>
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

          <input
            className="form-control"
            type="password"
            name="contrasenaUsuario2"
            placeholder="Confirmar Password"
            onChange={handleOnChangeValidate}
            value={contrasenaUsuario2}
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
