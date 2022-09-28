
import React from "react"
import {NavLogo,Nav,NavLink,Bars,NavMenu,NavBtn,NavBtnLink} from "./NavbarElements";
import { useNavigate } from "react-router"
import './index.css'

const styles= {
  logo: {
     width: '95px', height: '15 px'
  }
}

const Navbar= (props)=> {

  const navigate= useNavigate()

  const name= sessionStorage['name']
  const userId= sessionStorage['id']

  const logoutUser= ()=> {
    sessionStorage.removeItem('id')
    sessionStorage.removeItem('name')
    sessionStorage.removeItem('address')
    sessionStorage.removeItem('loginStatus')

    navigate('/signin')
  }

  const loginStatus= sessionStorage['loginStatus']
  
    
          return loginStatus=== '1' ?(
           
         <>
         <Nav>
          <NavLogo to="/">
             <img className="logo" src= {require('../../assets/logo.png')} style= {styles.logo} />
             <div><span className="navbar-text">AutoService</span></div>

          </NavLogo>
          <Bars />

          <NavMenu>

          <NavLink 
                to="/dashboard" 
                activestyle={{ color:'black' }}
              >
                  Dashboard
              </NavLink>
    
    
              <NavLink 
                to="/home" 
                activestyle={{ color:'black' }}
              >
                  Home
              </NavLink>
    
    
              <NavLink 
                to="/about" 
                activestyle={{ color: 'black' }}
              >
                  About
              </NavLink>
    
    
              <NavLink 
                to="/partners" 
                activestyle={{ color: 'black' }}
              >
                 Partners
                   </NavLink>
    
    
                
                   <NavLink 
                     to="/signin" 
                     activestyle={{ color: 'black' }}
                   >
                   
                       Hi {name}
                   </NavLink>
                  
                   <button onClick={logoutUser} className= "btn btn-danger float-end">Logout</button>
               </NavMenu> 
              </Nav> 
           </>
          )

          : (
            <>
            <Nav>
             <NavLogo to="/">
                <img className="logo" src= {require('../../assets/logo.png')} style= {styles.logo} />
                <span className="navbar-text">Auto Service</span>
             </NavLogo>
             <Bars />
            
             <NavMenu>
                 <NavLink 
                   to="/home" 
                   activestyle={{ color:'black' }}
                 >
                     Home
                 </NavLink>
                 <NavLink 
                   to="/about" 
                   activestyle={{ color: 'black' }}
                 >
                     About
                 </NavLink>
                 <NavLink 
                   to="/partners" 
                   activestyle={{ color: 'black' }}
                 >
                    Partners
                      </NavLink>
                      <NavLink 
                        to="/signin" 
                        activestyle={{ color: 'black' }}
                      >
                          Sign In
                      </NavLink>
                      <NavBtn>
                          <NavBtnLink to="/signup">Sign Up</NavBtnLink>                
                      </NavBtn>
                  </NavMenu> 
                 </Nav> 
              </>
      
          )
         
       }
  

export default Navbar