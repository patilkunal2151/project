import axios from "axios"
import React, { useEffect, useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify"
import { useLocation } from "react-router"
import { URL } from "../../../utils"

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

const EditProfile= ()=> {
  const [name, setName]= useState('')
  const [birth_date, setBirth_date]= useState('')
  const [email, setEmail]= useState('')
  const [password, setPassword]= useState('')
  const [confirmPassword, setConfirmPassword]= useState('')
  const [address, setAddress]= useState('')
  const [contact, setContact]= useState('')
  const [answer, setAnswer]= useState('')
  const [exact_Address, setExactAddress]= useState('')
  const { state }= useLocation()

  const navigate= useNavigate() //to navigate from one component to anothe

  useEffect(()=> {
      console.log(state)
      const {customer}= state
      setName(customer.name)
      setBirth_date(customer.birth_date)
      setEmail(customer.email)
      setPassword(customer.password)
      setAddress(customer.address)
      setContact(customer.contact)
      setAnswer(customer.answer)
      setExactAddress(customer.exact_Address)
  }, [state])

  const EditProfileCustomer= ()=> {
    if(name.length=== 0)
    {
      toast.warning('Please enter your name',
      {
        position: 'top-center'
      })
    } else if(birth_date.length=== 0)
    {
      toast.warning('Please enter your date of birth',
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
    } else if(contact.length=== 0 )
    {
      toast.warning('Please enter your contact',
      {
        position: 'top-center'
      })
    }
      else if(answer.length=== 0)
      {
        toast.warning('Please enter your Questions answer',
        {
          position: 'top-center'
        })
    } else
    {
      const body= {
        name,
        birth_date,
        exact_Address,
        email,
        password,
        address,
        contact,
        answer,  
      }
      console.log(body)

      const url= `${URL}/customer/editCustomer/${state.customer.id}`

      //body: data by user
      axios.put(url, body).then((response)=>{
        const result= response.data

        if(result['status']=== 'success')
        {
          toast.success(`Hey, your profile has been updated successfully !!`,
          {
            position: 'top-center'
          })
          //navigating user to the dashboard
          navigate('/dashboard')
        }else{
            toast.error(result['error'],
            {
              position: 'top-center'
            })
        }

        
      })
    }

  }

    return(
        <div style={styles.boundary}>

        <h2 style= {styles.h2}>EditProfile</h2>
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
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Birth date</label>
              <input value= {birth_date}
               onChange={(e)=> {
                      setBirth_date(e.target.value)
                  }} 
              type="date" className="form-control" placeholder="YYYY-MM-DD" style= {styles.fields} />
            </div>
          </div>
        </div>
        <div className="mb-3">
          <label htmlFor="" className= "form-label"> Postal Address </label>
          <input value= {exact_Address}
           onChange={(e)=> {
                     setExactAddress(e.target.value)
                  }} 
          type="text" className="form-control" style= {styles.fields} />
        </div>
        <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">City</label>
              <input value= {address}
               onChange={(e)=> {
                      setAddress(e.target.value)
                  }}  type="text" className="form-control" style= {styles.fields} />
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
             <div className="mb-3" style={{textAlign: 'center'}}>
                 
                 <br />
             
             <div className="mb-3">
                  <button onClick= {EditProfileCustomer} className= "btn btn-success">Save Changes</button>
                  <Link to= "/dashboard" className= "btn btn-danger float-end">Discard</Link>
                </div>
          
            </div>
        
    </div>
    )
}

export default EditProfile
