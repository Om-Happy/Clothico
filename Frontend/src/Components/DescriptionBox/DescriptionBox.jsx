import React from 'react'
import "./DescriptionBox.css"

export default function DescriptionBox() {
  return (
    <div className='descriptionbox'>
      <div className="descriptionbox-navigator">
        <div className="descriptionbox-nav-box">Description</div>
        <div className="descriptionbox-nav-box fade">Reviews (122)</div>
      </div>
      <div className="descriptionbox-description">
        <p>
            An E-commerce Website is an online platform.
        </p>
        <p>
            E-commerce websites typically display products. 
        </p>
      </div>
    </div>
  )
}
