import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { startAppointment } from '../../actions/appointmentAction';
import { useForm } from '../../hooks/useForm';
import { AppointmentList } from './AppointmentList';

export const Appointment = () => {

  const dispatch = useDispatch();
    const [appointment, handleOnChange, setAppointment] =  useForm({
        fechaCita :'2022-10-10',
        Direccion: 'carrera 15 ',
    });
    const {fechaCita, Direccion} = appointment;
    const { itemAppointment } = useSelector((state) => state.Appointment)

     //data momentanea
  const data = [
    {
      fechaCita: '2022-02-10',
      Direccion: 'carrea 12 con 4',
    },
    {
      fechaCita: '2022-12-10',
      Direccion: 'carrea 33 con 4',
    },
    {
      fechaCita: '2022-09-10',
      Direccion: 'carrea 2 con 4',
    },
    {
      fechaCita: '2022-10-04',
      Direccion: 'carrea 12 con 2',
    },
  ]

  useEffect(() => {
    if (!!itemAppointment) {
      const { fechaCita: fecha, Direccion: ubicacion } = itemAppointment
      setAppointment({
        fechaCita :fecha,
        Direccion:ubicacion,
      })
    }
  }, [itemAppointment])


    const handleAppointment = (e)=>
    {
        e.preventDefault();
        dispatch(startAppointment(appointment));
    }

  return (
    <div className="container">
    <h1 className="h1-register my-3">Citas</h1>
    <div className="border div-form">
      <form onSubmit={handleAppointment}>
        <input
          className="form-control"
          type="date"
          name="fechaCita"
          placeholder="fechaCita"
          onChange={handleOnChange}
          value={fechaCita}
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
        <button
          type="submit"
          className="btn btn-outline-primary button-login"
        >
          Crear Cita
        </button>
      </form>
    </div>

    <div className="container">
      <AppointmentList data={data} />
    </div>
  </div>
  )
}
