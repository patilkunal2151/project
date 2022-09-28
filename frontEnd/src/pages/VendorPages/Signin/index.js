import React, { useState } from "react"
import { toast } from 'react-toastify'
import { URL } from '../../../utils'
import axios from 'axios'
import { useNavigate } from "react-router"

const styles= {
    boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '15px',
        width: '50vw',
        height: '65vh',
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

const VendorSignin= ()=> {

const [email, setEmail]= useState('')
const [password, setPassword]= useState('')

const navigate= useNavigate()

const signinVendor= ()=> {
    if(email.length=== 0)
    {
        toast.warning('Please enter your email',
        {
            position: "top-center"
        })
    }else if(password.length=== 0)
    {
        toast.warning('Please enter your password',
        {
            position: "top-center"
        })
    }else
    {
        const body= {
            email,
            password
        }
        console.log(body)

        const url= `${URL}/vendor/signin`

        axios.post(url, body).then((response)=> {
            const result= response.data
            console.log(result)

            if(result['status'] === 'success')
            {
                toast.success("Signed in sucessfully. Hey, there....",
                { 
                position: "top-center"
            })
            //Now we use session storage(temporary) to use the user info on console(the data sent by the server)
            const { id, name, address }= result['data'] //sent by server
            sessionStorage['id']= id
            sessionStorage['name'] = name
            sessionStorage['address'] = address
            sessionStorage['loginStatus'] = 1

            navigate('/vendorDashboard')
            }else{
                toast.error('Invalid username or password',
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
               <h2 style= {styles.h2}>Vendor SignIn</h2>
               <br /><br/> 
            
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Enter your email address:</label>
                 <input 
                 onChange={(e)=> {
                     setEmail(e.target.value)
                 }}
                 type="email" className="form-control" style= {styles.fields} />
               </div>
               <div className="mb-3">
                 <label htmlFor="" className= "form-label">Enter password</label> 
                 <input onChange={(e)=> {
                     setPassword(e.target.value)
                 }}
                 type="password" className="form-control" style= {styles.fields}/>   
               </div>   
           </div>
           <br />
           
           <button onClick={signinVendor} className= "btn btn-primary">Login</button>

        </div>
        
    )
}

export default VendorSignin