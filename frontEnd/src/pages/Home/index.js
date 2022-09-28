import React from "react"
import { Link } from "react-router-dom"
import './index.css'

const Home= ()=>
    {
        return(
            <div className="container" >
                <div className= "coverPhoto">
                <img className="cover" src={require('../../assets/timeline1.jpg')} />
                <div className="imgText1">Get your vehicles serviced now.<br /><br/>
                <Link to= "/signin" className="button">SignIn</Link><br/>
                <Link to= "/signup" className="button">SignUp</Link>
                </div>
            </div>
            <div className="citySel">
                <table>
                    <tbody>
                    <tr>
                        <td>Select City - </td>
                        <td>
                            <select className= "myselect">
                                <option value= "Pune">Pune</option>
                                <option value= "Mumbai">Mumbai</option>
                                <option value= "Nagpur">Nagpur</option>
                            </select>
                        </td>
                        <td><button className= "btn btn-primary">Search</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
           
            
            </div>
            
        )
    }

    export default Home