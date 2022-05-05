import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Swal from 'sweetalert2'
import { startUpdate } from '../../actions/auth'
import { fetchBackend } from '../../helpers/fetch'
import { useForm } from '../../hooks/useForm'

export const Profile = () => {


  const {cedula} = useSelector((state) => state.auth)
  const dispatch = useDispatch()

  const [user, handleOnChange, setUser] = useForm({
    cedulaPersona: 0,
    celularPersona: 0,
    nombrePersona: '',
    direccionPersona: '',
    emailUsuario: '',
    tipoUsuario: 0,
    contrasenaUsuario: '',
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

  useEffect(async () => {
    const resp = await fetchBackend(`leerUsuario/${cedula}`, {});
    const data = await resp.text();
    const user = data.split("|")

    setUser({
      cedulaPersona : user[0],
      celularPersona : user[1],
      direccionPersona : user[2],
      nombrePersona : user[3],
      contrasenaUsuario : user[4],
      emailUsuario : user[5],
      tipoUsuario : user[6],

    })
  }, [cedula])
  
  const handleRegister = (e) => {
    e.preventDefault()
    user.cedulaPersona = cedula;
   dispatch(startUpdate(user));
  }

  const handledeleteuser  = async()=>
  {
    const resp = await fetchBackend(`borrarUsuario/${cedula}`, {}, 'DELETE');
    if(resp.status === 200)
    {
      Swal.fire('Success', 'Registro eliminado con exito', 'success');
    }
    else{
      Swal.fire('Error', 'Error, intente nuevamente', 'error');
    }
    window.location.reload(true)
  }

  return (
    <div className="container">
      <h1 className='h1-register my-3 h2-color'>Actualizar</h1>
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
          Actualizar
          </button>
        </form>
        <button  className='btn btn-danger button-login' onClick={handledeleteuser}>
          Eliminar
          </button>
      </div>
    </div>
  )
}
