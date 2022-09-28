import React, { useState } from "react"
import { Link } from "react-router-dom"
import { toast } from 'react-toastify'
import { URL } from '../../../utils'
import axios from 'axios'
import { useNavigate } from "react-router"
import { useEffect } from "react"

const styles= {
    boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '15px',
        width: '65vw',
        height: 'auto',
        marginTop: '50px',
        marginBottom: '50px',
        backgroundColor: 'rgb(231, 230, 230)',
        opacity: '0.75'
    },
    h2: {
     textAlign: 'center',
     fontWeight: 'bolder',
     fontSize: '25px'
    },
    fields: {
        border: '1px solid black',
        backgroundColor: 'rgb(170, 211, 238)',
        marginBottom: '35px'
    }
}

const AddService= ()=> {

const [delivery_type, setDeliveryType]= useState('')
const [status, setStatus]= useState('')
const [vehicle_brand, setVehicleBrand]= useState('')
const [vehicle_model, setVehicleModel]= useState('')
const [vehicle_reg_no, setVehRegNo]= useState('')
const [vehicle_type, setVehicleType]= useState('')

const navigate= useNavigate()

const newService= ()=> {
    if(delivery_type.length=== 0)
    {
        toast.warning('Please enter delivery type',
        {
            position: "top-center"
        })
    }else if(status.length=== 0)
    {
        toast.warning('Please enter status',
        {
            position: "top-center"
        })
    }else if(vehicle_brand.length=== 0)
    {
        toast.warning('Please enter vehicle brand',
        {
            position: "top-center"
        })
    }else if(vehicle_model.length=== 0)
    {
        toast.warning('Please enter model name',
        {
            position: "top-center"
        })
    }else if(vehicle_reg_no.length=== 0)
    {
        toast.warning('Please enter your vehicle registration number',
        {
            position: "top-center"
        })
    }else if(vehicle_type.length=== 0)
    {
        toast.warning('Please enter your vehicle category',
        {
            position: "top-center"
        })
    }else
    {
        const body= {
            delivery_type,
            status,
            vehicle_brand, 
            vehicle_model,
            vehicle_reg_no,
            vehicle_type
        }
        console.log(body)

        

        const url= `${URL}/customer/addService/${sessionStorage ['id']}`

        axios.post(url, body).then((response)=> {
            const result= response.data
            console.log(result)

            if(result['status'] === 'success')
            {
                toast.success("Service added sucessfully.",
                { 
                position: "top-center"
            })
            //Now we use session storage(temporary) to use the user info on console(the data sent by the server)
         const { id, name, address }= result['data'] //sent by server
         sessionStorage['id']= id
         sessionStorage['name'] = name
         sessionStorage['address'] = address
         sessionStorage['loginStatus'] = 1
            navigate('/dashboard')
            }else{
                toast.error('Add service failed',
                {
                    position: 'top-center'
                })
            }
        })
    }
}
  

    return(
        <div className="container" style= {styles.boundary}>
        <div>
               <h2 style= {styles.h2}>Add Service</h2>
               <br /><br/> 
            
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Delivery type:</label>
                 <input 
                 onChange={(e)=> {
                     setDeliveryType(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Status:</label>
                 <input 
                 onChange={(e)=> {
                     setStatus(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Vehicle Brand:</label>
                 <input 
                 onChange={(e)=> {
                     setVehicleBrand(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Vehicle Model:</label>
                 <input 
                 onChange={(e)=> {
                     setVehicleModel(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Vehicle Registration number:</label>
                 <input 
                 onChange={(e)=> {
                     setVehRegNo(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Vehicle Category:</label>
                 <input 
                 onChange={(e)=> {
                     setVehicleType(e.target.value)
                 }}
                 type="text" className="form-control" style= {styles.fields} />
               </div>
           </div>
           <br />
           
           <button onClick={newService} className= "btn btn-primary">Add Service</button>
        </div>
        
    )
}

export default AddService