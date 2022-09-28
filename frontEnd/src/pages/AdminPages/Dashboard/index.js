import { Link } from 'react-router-dom'
import '../../../components/Navbar'
import './index.css'
import Feedback from '../../../components/feedback'
import { useEffect, useState } from 'react'
import axios from 'axios'
import { toast } from 'react-toastify'
import { useLocation } from 'react-router'
import { URL } from '../../../utils'


const AdminDashboard= (props)=> {
  const [reviews, setReviews]= useState([])

  const { state }= useLocation()

  const allReviews= ()=> {
    axios.get(`${URL}/employee/Feedbacklist`).then(response=> {
        const result= response.data

        if(result['status']=== 'success')
        {
            setReviews(result['data'])
        }
        toast.error(result['error'])
    })
}

useEffect(()=> {
  allReviews()
}, [])


    return (
      <div className="container">
          <div className="dbButtons">
              <Link to= "/admin/vendor/signup">
                <button className="dbButton1">Add Vendor</button></Link>
              <Link to="">
                <button className="dbButton2">View Employees</button></Link>
              <Link to="">
                <button className="dbButton3">View Customers</button></Link>
              <Link to="">
                <button className="dbButton4">Add Employee</button></Link>
          </div>

          <div className="myReviews">
              <div className="heading">Reviews from other customers</div>
              {reviews.map((feedback)=> {
                  return <Feedback feedback= {feedback}/>
              })}
          </div>
          
      </div>
    )
}

export default AdminDashboard