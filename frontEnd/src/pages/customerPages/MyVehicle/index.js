import { Link } from 'react-router-dom'
import '../AddVehicle/index.css'
import './index.css'

const styles= {
    h2: {
        textAlign: 'center',
        fontWeight: 'bold',
        fontSize: '50px',
    },
    
    boundary: {
        border: '1px solid gray',
        borderRadius: '5px',
        padding: '25px',
        width: '50vw',
        backgroundColor: 'rgb(220, 230, 230)',
        opacity: '0.70'
    },
}

const MyVehicle= ()=> {

    return(
        <div className="myVehicle">
             <img className="graffiti" src={require('../../../assets/graffiti.jpg')} />
            <div className="vehicleDetails" style= {styles.boundary}>
            <h2 style= {styles.h2}>My Vehicle Details.</h2>
            
        <br/><br/>
        <div className="mb-3">
                  <Link to= "/customer/addVehicle" className= "btn btn-success">Add Vehicle</Link>
                  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                  <p>
                      <span>Insurance Expired ?</span><br/>Let us help you with the renewal ...
                      <a href="https://www.policybazaar.com/motor-insurance/car-insurance/" target={"_blank"}>Click Here</a>
                  </p>
        </div>
                </div>
        </div>
    )
}

export default MyVehicle