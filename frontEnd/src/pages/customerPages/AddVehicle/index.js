import { useState } from 'react'
import { useNavigate } from 'react-router'
import { toast } from 'react-toastify'
import './index.css'

const styles= {
    fields: {
        border: '1px solid black',
        backgroundColor: 'rgb(170, 211, 238)'
    },
    h2: {
        textAlign: 'center',
        fontWeight: 'bolder',
        fontSize: '25px'
       },
       boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '25px',
        width: '40vw',
        backgroundColor: 'rgb(231, 230, 230)',
        opacity: '0.85'
    },
}

const AddVehicle= ()=> {

    const [vehicle_model, setModel]= useState('')
    const [vehicle_brand, setBrand]= useState('')
    const [vehicle_reg_no, setRegNo]= useState('')
    const [vehicle_type, setType]= useState('')

    const navigate= useNavigate()

    const addVehicle= ()=> {
        if(vehicle_model.length=== 0)
        {
            toast.warning('Please enter the name of your Vehicle Model',
      {
        position: 'top-center'
      })
        }else if(vehicle_brand.length=== 0)
        {
            toast.warning('Please enter the name of your Vehicle Maker',
      {
        position: 'top-center'
      })
        }else if(vehicle_reg_no.length=== 0)
        {
            toast.warning('Please enter your Vehicle Registration Number',
      {
        position: 'top-center'
      })
        }else if(vehicle_type.length=== 0)
        {
            toast.warning('Please enter your Vehicle type',
      {
        position: 'top-center'
      })
        }else
        {
            const body= {
                vehicle_brand,
                vehicle_model,
                vehicle_reg_no,
                vehicle_type
            }
            console.log(body)
        }
    }

    return(
        <div className="addVehicle">
            <img className="graffiti" src={require('../../../assets/graffiti.jpg')} />
            <div className="vehicleDetails" style= {styles.boundary}>
            <h2 style= {styles.h2}>Add Your Vehicle Details</h2>
        <br /><br />
            <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Vehicle model</label>
              <input type="text" className="form-control" style= {styles.fields}/>
            </div>
          </div>
        </div>
            <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Vehicle Brand</label>
              <input type="text" className="form-control" style= {styles.fields}/>
            </div>
          </div>
          <div className="col">
            <div className="mb-3">
            <label htmlFor="" className= "form-label">Registration Number</label>
              <input type="text" className="form-control" style= {styles.fields}/>
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col">
            <div className="mb-3">
              <label htmlFor="" className= "form-label">Vehicle Category</label>
              <input type="text" className="form-control" placeholder="Car/Two-Wheeler/Auto/Electric" style= {styles.fields}/>
            </div>
          </div>
        </div>
            </div>
        </div>
    )
}

export default AddVehicle