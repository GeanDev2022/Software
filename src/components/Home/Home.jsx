import React from 'react'
import { Route, Routes } from 'react-router-dom'
import { Appointment } from '../Appointment/Appointment'
import { Comment } from '../comments/Comment'
import { Services } from '../Services/Services'
import { UserCalification } from '../UserCalification/UserCalification'
import { GoUpHistory } from './GoUpHistory'
import { Navbar } from './Navbar'
import { Patients } from './Patients'
import { Profile } from './Profile'
import { Sidebar } from './Sidebar'

export const Home = () => {
  return (
    <div className="home">
      <Sidebar />

      <div className='navbar-home'>
        <main>
          <Navbar />
          <Routes>
            <Route path="/patients" element={<Patients />} />
            <Route path="/history" element={<GoUpHistory />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/services" element={<Services />} />
            <Route path="/appointment" element={<Appointment />} />
            <Route path="/comments" element={<Comment />} />
            <Route path="/userCalifications" element={<UserCalification />} />
          </Routes>
        </main>
      </div>
    </div>
  )
}
