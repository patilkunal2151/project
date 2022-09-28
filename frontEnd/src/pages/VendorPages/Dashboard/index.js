import './index.css'
import Vendor from '../../../components/vendor'
import { useEffect, useState } from 'react'
import { useLocation, useNavigate } from 'react-router'
import axios from 'axios'
import { URL } from '../../../utils'
import { toast } from 'react-toastify'
import Feedback from '../../../components/feedback'


const VendorDashboard= (props)=> {
    const [reviews, setReviews]= useState([])

    const { state }= useLocation()

    const currentUserId= sessionStorage['id']

    const navigate= useNavigate()

    const [vendor, setVendor]= useState('')

    const [specificVendor, setSpecificVendor]= useState('')

    const allVendors= ()=> {
        axios.get(`${URL}/admin/vendorlist`).then((response)=> {
            const result= response.data

            if (result['status']=== 'success')
            {
                console.log(result['data'])
                setVendor(result['data'])
            }

            toast.error(result['error'])
        })
    }

    const getSpecificVendor= ()=> {
        axios.get(`${URL}/admin/vendor/${currentUserId}`).then((response)=> {
            const result= response.data

            if(result['status']=== 'success')
            {
                console.log(result['data'])
                setSpecificVendor(result['data'])
            }

            toast.error(result['error'])
        })
    }

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
        allVendors()
        getSpecificVendor()
        allReviews()
    }, [])

    return (
      <div className="container">
          <div className="dbButtons">
              <button className="dbButton1">View Jobs</button>
              <button className="dbButton2">Customer Reviews</button>
              <button className="dbButton3">My Rating</button>
              
              <button onClick={()=> navigate('/admin/editVendor/', { state: {vendor: specificVendor}})} className="dbButton4">Edit Profile</button>
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

export default VendorDashboard