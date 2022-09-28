import React from "react";
import './index.css'

const styles= {
    container: {
        display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            height: 'auto',
            width: '80vw'
    },
}

const About= ()=> {
    return(
        <div className="container" style= {styles.container}>
        
        <div className="row">
            <div className="col">
                <div className="mission">
                    <div className="head">OUR MISSION</div>
                    <div className="text">Our mission is to make your life easier. Well, at least in terms of servicing your vehicles. We help you find the best service center for your vehicle from our carefully curated Vendor list.</div>
                </div>
            </div>
            <div className="col">
                <div className="fv">
                <div className="head">FUTURE VISION</div>
                <div className="text">We believe in continous development and growth, so as a business we plan on providing you with more and more features and option. We are planning to mark our presence in more cities in the future.
                {/* <ul>
                    <li>&diams; Raipur</li>
                    <li>&diams; Jabalpur</li>
                    <li>&diams; Bhopal</li>
                    <li>&diams; Hyderabad</li>
                </ul> */}
                </div>
                </div>
            </div>
        </div>
        <div className="row">
            <div className="col">
                <div className="of">
                <div className="head">OUR FEATURES</div>    
                <div className="text">
                    <ul>
                        <li>- Upfront and Competitive pricing</li>
                        <li>- 100% Genuine Spare Parts</li>
                        <li>- Quality Assurance</li>
                        <li>- Refer and Earn</li>
                        <li>- Over 350 vendors across three cities</li>
                    </ul>
                </div>
                </div>
            </div>
            <div className="col"></div>
            <div className="col">
                <div className="ta">
                <div className="head">TARGET AUDIENCE</div>
                <div className="text">We, as an organisation believe in making lives easier. We aim to cater to a diverse audience, by providing features for everyone. As if booking a service while sipping your morning coffee was not cool enough, now you can see reviews from other customers, post your own, ping us on twitter and what not !!!</div>
                </div>
            </div>
        </div>
    </div>
    )
}

export default About