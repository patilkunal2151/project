import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
import { URL } from "../../../../utils";
import { Link } from "react-router-dom";

const styles= {
    boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '15px',
        width: '75vw',
        height: '95vh',
        marginTop: '50px',
        marginBottom: '50px',
        marginLeft: '180px',
        backgroundColor: 'rgb(231, 230, 230)',
        opacity: '0.75'
    },
    h2: {
        textAlign: 'center',
        fontWeight: 'bolder',
        fontSize: '25px'
       },
}

const AddReview= ()=> {
    const [vendor, setVendor]= useState('')
    const [title, setTitle]= useState('')
    const [feedback_message, setFeedback]= useState('')

    const navigate= useNavigate()

    const saveReview=() => {
        if(vendor.length=== 0)
        {
            toast.error('Please add a vendor',
            {
                position: 'top-center'
            })
        }else if(title.length=== 0)
        {
            toast.error('Please add a title',
            {
                position: 'top-center'
            })
        }else if(feedback_message.length=== 0)
        {
            toast.error('Please add a review',
            {
                position: 'top-center'
            })
        }else{
            const body= {
                title,
                vendor,
                feedback_message,
                customer_id: sessionStorage['id']
            }

            const url= `${URL}/customer/addFeedback`

            axios.post(url, body).then((response)=>
            {
                const result= response.data
                if(result['status']=== 'success')
                {
                    toast.success('Review Added',
                    {
                        position: 'top-center'
                    })
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
        <div>
            <div style= {styles.boundary}>
            <h2 style= {styles.h2}>Add Review</h2>
            <br />
            <div className="form">
            <div className="mb-3">
                 <label className="label-control">Vendor</label>
                 <input onChange={(e)=>{
                   setVendor(e.target.value)
                } }
                type="text" className="form-control" />    
               </div>

               <div className="mb-3">
                 <label className="label-control">Title</label>
                 <input onChange={(e)=>{
                   setTitle(e.target.value)
                } }
                type="text" className="form-control" />    
               </div>

               <div className="mb-3">
                 <label className="label-control">Review</label>
                 <textarea onChange={(e)=> {
                   setFeedback(e.target.value)
                }  }
                 rows= "14" className="form-control" />   
               </div>
              
               <div className="mb-3">
                  <button onClick= {saveReview} className= "btn btn-success">Save</button>
                  <Link to= "/dashboard" className= "btn btn-danger float-end">Discard</Link>
                </div>

            </div>

        </div>
        </div>
    )
}

export default AddReview;