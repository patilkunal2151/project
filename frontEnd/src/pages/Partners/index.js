import React from "react"
import './index.css'


const Partners= ()=> {
    return(
        <div className="partners">
        <div className="coverPhoto">
            <img className="cover" src= {require('../../assets/timeline2.jpg')}/>
            <div className="imgText">Own a Workshop ?<br /> Join Auto Service&trade; and grow your business. <br /> Call : 9922860558</div>    
        </div>
        <div className="features">
            <div className="row">
            <div className="col">
                    <div className="number">100k+</div>
                    <div className="desc">Signed up users already</div>
                </div>
                <div className="col">
                    <div className="number">350+</div>
                    <div className="desc">Partners already on board</div>
                </div>
                {/* <div className="col">
                    <div className="number">100k+</div>
                    <div className="desc">Signed up users already</div>
                </div> */}
                <div className="col">
                    <div className="number">125cr</div>
                    <div className="desc">Payed out to partners</div>
                </div>
            </div>
        </div>
        {/* <div className="features">
            <div className="row">
                <div className="col">
                    <div className="number">&#8501;</div>
                    <div className="desc">Consumables and Operations Support</div>
                </div>
                <div className="col">
                    <div className="number">&#9728;</div>
                    <div className="desc">Get more customers</div>
                </div>
                <div className="col">
                    <div className="number">&#9762;</div>
                    <div className="desc">More Publicity</div>
                </div>
            </div>
        </div>
        <div className="features">
            <div className="row">
                <div className="col">
                    <div className="number">&#9816;</div>
                    <div className="desc">Business Growth</div>
                </div>
                <div className="col">
                    <div className="number">&#9784;</div>
                    <div className="desc">Outdo your Competition</div>
                </div>
                <div className="col">
                    <div className="number">&#9813;</div>
                    <div className="desc">Exclusive Perks</div>
                </div>
            </div>
        </div> */}
        </div>
    )
}

export default Partners