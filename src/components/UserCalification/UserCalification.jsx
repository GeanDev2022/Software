import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { isUserCalification } from '../../actions/userCalificationAction'
import { fetchBackend } from '../../helpers/fetch'
import { useForm } from '../../hooks/useForm'

export const UserCalification = () => {
  let doctores = []
  const [{ doctor }, , setdoctor] = useForm({
    doctor: '',
  })

  const dispatch = useDispatch()
  useEffect(async () => {
    const resp = await fetchBackend(`listarTopFiveDoc`, {})
    const data = await resp.json()

    dispatch(isUserCalification(data))
  }, [])

  const { userTop } = useSelector((state) => state.userTop)
  // const {doc} = userTop

  // console.log(userTop)
  return (
    <div className="container">
      <table className="table table-dark table-hover mt-5  ">
        <thead>
          <tr>
          
            <th scope="col">Doctor</th>
          </tr>
        </thead>
        <tbody>
          {!!userTop &&
            userTop[0].doc.map((value,i) => {
             

              return ( <tr key={i}>
                  <td key={i}>{value[0]}</td>
                </tr>)
            })}
        </tbody>
      </table>
    </div>
  )
}
