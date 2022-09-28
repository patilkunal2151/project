import './index.css'
import { Link } from 'react-router-dom'
import { useEffect, useState } from 'react'
import Feedback from '../../../components/feedback'
import axios from 'axios'
import { URL } from '../../../utils'
import { toast } from 'react-toastify'
import { useNavigate } from 'react-router'
import { useLocation } from 'react-router'
import Customer from '../../../components/customer'

const Dashboard= (props)=> {

    const [reviews, setReviews]= useState([])

    const navigate= useNavigate()

    const { state }= useLocation()

    const [ customer, setCustomer]= useState('')

    const currentUserId= sessionStorage['id']

    const [ specificCustomer, setSpecificCustomer]= useState('')


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

    const allCustomers= ()=> {
        axios.get(`${URL}/vendor/Customerlist`).then((response)=> {
            
            const result= response.data

            if(result['status']=== 'success')
            {
                console.log(result['data'])
                setCustomer(result['data'])
                
            }
            
            toast.error(result['error'])
        })
    }
    
    const getSpecificCustomers= ()=> {
        axios.get(`${URL}/customer/${currentUserId}`).then((response)=> {
            const result= response.data

            if(result['status']=== 'success')
            {
                console.log(result['data'])
                setSpecificCustomer(result['data'])
                
            }
            
            toast.error(result['error'])

        })
    }

    useEffect(()=> {
        getSpecificCustomers()
        allCustomers()
        allReviews()
    }, [])

    return (
      <div className="container">
          <div className="dbButtons">
              <Link to= "/customer/addService">
              <button className="dbButton1">Add Service</button></Link>
              <button className="dbButton2">Service History</button>
              <Link to= "/customer/myVehicle">
              <button className="dbButton3">My Vehicles</button></Link>
              
              <button onClick={()=> navigate('/customer/editCustomer/', { state: { customer: specificCustomer}})}
               className="dbButton4">Edit Profile</button>
          
          </div>
          {/* <div className="content">
          <div className="writeReview">
              <Link to= "/addReview" className= "btn btn-danger float-end">Add a review +</Link>
          </div> */}
          <div className="myReviews">
              <div className="heading">Reviews from other customers</div>
              {reviews.map((feedback)=> {
                  return <Feedback feedback= {feedback}/>
              })}
          </div>
          <div className="content">
          <div className="writeReview">
              <Link to= "/addReview" className= "btn btn-danger float-end">Add a review +</Link>
          </div>
          
          </div>
      </div>
    )
}

export default Dashboard