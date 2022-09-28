import axios from "axios"
import React, { useEffect, useState } from "react"
import { toast } from "react-toastify"
import { useLocation, useNavigate } from "react-router"
import { URL } from "../../../utils"
import Vendor from "../../../components/vendor"

const styles= {
    boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '25px',
        width: '50vw',
        marginTop: '50px',
        marginBottom: '50px',
        marginLeft: '350px',
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
        backgroundColor: 'rgb(170, 211, 238)'
    },
    mandatory: {
      color: 'red',
      textAlign: 'left',
      fontSize: 'small'
    }
}

const EditVendorProfile= ()=> {
  const [name, setName]= useState('')
  const [email, setEmail]= useState('')
  const [password, setPassword]= useState('')
  const [confirmPassword, setConfirmPassword]= useState('')
  const [address, setAddress]= useState('')
  const [contact, setContact]= useState('')
  const [garage, setGarage]= useState('')
  const [exact_address, setExactAddress]= useState('')
  const [answer, setAnswer]= useState('')
  const { state }= useLocation()

  const navigate= useNavigate() //to navigate from one component to another

  useEffect(()=> {
    console.log(state)
    const {vendor}= state
    setName(vendor.name)
    setEmail(vendor.email)
    setGarage(vendor.garage)
    setPassword(vendor.password)
    setAddress(vendor.address)
    setContact(vendor.contact)
    setAnswer(vendor.answer)
    setExactAddress(vendor.exact_address)
}, [state])

  const EditVendor= ()=> {
    if(name.length=== 0)
    {
      toast.warning('Please enter your name',
      {
        position: 'top-center'
      })
    } else if(email.length=== 0)
    {
      toast.warning('Please enter your email',
      {
        position: 'top-center'
      })
    } else if(password.length=== 0)
    {
      toast.warning('Please enter your password',
      {
        position: 'top-center'
      })
    } else if(confirmPassword.length=== 0)
    {
      toast.warning('Please confirm your password by entering it again',
      {
        position: 'top-center'
      })
    } else if(address.length=== 0)
    {
      toast.warning('Please enter your address',
      {
        position: 'top-center'
      })
    } else if(contact.length=== 0)
    {
      toast.warning('Please enter your contact',
      {
        position: 'top-center'
      })
    } else if(garage.length=== 0)
    {
      toast.warning('Please enter your contact',
      {
        position: 'top-center'
      })
    } else if(exact_address.length=== 0)
    {
      toast.warning('Please enter your contact',
      {
        position: 'top-center'
      })
    } else if(answer.length=== 0)
    {
      toast.warning('Please enter your contact',
      {
        position: 'top-center'
      })
    } else
    {
      const body= {
        name,
        email,
        password,
        address,
        contact,
        garage,
        exact_address,
        answer
      }
      console.log(body)

      const url= `${URL}/admin/vendor/signup`

      //body: data by user
      axios.post(url, body).then((response)=>{
        const result= response.data

        if(result['status']=== 'success')
        {
          toast.success(`Vendor ${name} added successfully, !!!`,
          {
            position: 'top-center'
          })
          //navigating user to the sign in page
          navigate('/adminDashboard')
        } else{
          toast.error('This vendor already exists !!!',
          {
            position: 'top-center'
          })
        }
      })
    }

  }

    return(
        <div style={styles.boundary}>

        <h2 style= {styles.h2}>Add Vendor</h2>
        <br /><br />
        <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Name</label>
              <input value= {name}
               onChange={(e)=> {
                      setName(e.target.value)
                  }} 
              type="text" className="form-control" style= {styles.fields}/>
            </div>
          </div>
          
        </div>
        <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Garage Name</label>
              <input value= {garage}
               onChange={(e)=> {
                      setGarage(e.target.value)
                  }} 
              type="text" className="form-control" style= {styles.fields}/>
            </div>
          </div>
          
        </div>
        
        <div className="row">
        <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Area</label>
              <input value= {exact_address}
               onChange={(e)=>{
                         setExactAddress(e.target.value)
              }}
               type="text" className="form-control" style= {styles.fields} />
            </div>
          </div>
        <div className="col">   
        <div className="mb-3">
          <label htmlFor="" className= "form-label">City</label>
          <input value= {address}
           onChange={(e)=> {
                      setAddress(e.target.value)
                  }} 
          type="text" className="form-control" style= {styles.fields} />
        </div>
        </div>
        </div>
        <div className="mb-3">
                  <label htmlFor="" className= "form-label">Contact Number</label>
                  <input value= {contact}
                   onChange={(e)=> {
                      setContact(e.target.value)
                  }} 
                  type="text" className="form-control" style= {styles.fields} />
            </div>

        <div className="mb-3">
          <label htmlFor="" className= "form-label">Email Address</label>
          <input value= {email}
           onChange={(e)=> {
                      setEmail(e.target.value)
                  }} 
          type="email" className="form-control" style= {styles.fields} />
        </div>
        <div className="mb-3">
          <label htmlFor="inputPassword" className= "form-label">Password</label>
          <input value= {password}
           onChange={(e)=> {
                      setPassword(e.target.value)
                  }} 
          type="password" className="form-control" style= {styles.fields} />
        </div>
        <div className="mb-3">
                  <label htmlFor="" className= "form-label">Confirm Password</label>
                  <input onChange={(e)=> {
                      setConfirmPassword(e.target.value)
                  }} 
                  type="password" className="form-control" style= {styles.fields} />
            </div>
            <div className="mandatory" style={styles.mandatory}>
          <p>* Mandatory field. Will be used in case of a forgotten password</p>
        </div>
          <div className="mb-3">
            <label htmlFor="" className= "form-label">What was the name of your first pet ?</label>
            <input value= {answer}
             onChange={(e)=> {
                      setAnswer(e.target.value)
                  }}  type="text" className="form-control" style= {styles.fields} />
          </div>
             
             <br />
             
             <div>
                 <button onClick={EditVendor} className= "btn btn-primary">Add Vendor</button>
            </div>

            
        
    </div>
    )
}

export default EditVendorProfile