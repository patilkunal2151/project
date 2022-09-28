import React from 'react'
import { Link } from 'react-router-dom';
import styled from "styled-components";
import './index.css'

const Footer= ()=> {
    return (
<footer className='footer'>
    <div className="container py-5">
      <div className="row py-2">
        {/* <div className="col-lg-3 col-md-6 mb-4 mb-lg-0"><img src= {require('../../assets/logo.png')} alt="" className="mb-3"/>
          <p>Follow us on Social Media.</p>
          <ul className="list-inline mt-1">
            <div className="list-inline-item">
              <li className="list-inline-item"><a href= "https://www.facebook.com" target={"_blank"}><img src= {require('../../assets/fb.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.instagram.com" target={"_blank"}><img src={require('../../assets/insta.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.twitter.com" target={"_blank"}><img src={require('../../assets/twitter.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.linkedin.com" target={"_blank"}><img src={require('../../assets/linkedin.png')}/></a></li>
            </div>
          </ul>
        </div> */}

        <div className="col-lg-3 col-md-6 mb-4 mb-lg-0">
          <h6 className="text-uppercase font-weight-bold mb-4">Contact us</h6>
          <ul className="list-unstyled mb-0">
            <li className="mb-2"><p>Email :</p></li>
            <li className="mb-2"><a href="#" className="text-muted">autoService@gmail.com</a></li>
            <li className="mb-2"><p>Call :</p></li>
            <li className="mb-2"><a href="#" className="text-muted">9922860558</a></li>
          </ul>
        </div>

        <div className="col-lg-3 col-md-6 mb-4 mb-lg-0">
          <h6 className="text-uppercase font-weight-bold mb-4">Company</h6>
          <ul className="list-unstyled mb-0">
            <li className="mb-2"><p>Login as Vendor:</p></li>
            <li className="mb-2"><Link to="/vendor/signin" className="text-muted">Login</Link></li>
            <li className="mb-2"><p>Login as Admin:</p></li>
            <li className="mb-2"><Link to= "/admin/signin" className="text-muted">Login</Link></li>
          </ul>
        </div>

        <div className="col-lg-3 col-md-6 mb-4 mb-lg-0">
          <h6 className="text-uppercase font-weight-bold mb-4">Address</h6>
          <p  className="text-muted mb-4">Complex- 120,Sane Guruji Marg,<br/>Mumbai- 400001.</p>
          {/* <p id="add">Complex- 120,Sane Guruji Marg,<br />Mumbai- 400001.</p> */}
        </div>

        <div className="col-lg-3 col-md-6 mb-4 mb-lg-0">
        <h6 className="text-uppercase font-weight-bold mb-4">AutoService</h6>
        <img src= {require('../../assets/logo.png')} alt="" className="mb-1"/>
          <p>Follow us on Social Media.</p>
          <ul className="list-inline mt-1">
            <div className="list-inline-item">
              <li className="list-inline-item"><a href= "https://www.facebook.com" target={"_blank"}><img src= {require('../../assets/fb.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.instagram.com" target={"_blank"}><img src={require('../../assets/insta.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.twitter.com" target={"_blank"}><img src={require('../../assets/twitter.png')}/></a></li>
              <li className="list-inline-item"><a href= "https://www.linkedin.com" target={"_blank"}><img src={require('../../assets/linkedin.png')}/></a></li>
            </div>
          </ul>
        </div>

      </div>
    </div>

      <div className= 'copyright'>
        <div className="container text-center">
        <p>© Unauthorized use of AUTOSERVICE&trade; name and logo&trade; are subject to Copyright infringement.</p>
        </div>
      </div>
    
  </footer>
    )
}

export default Footer