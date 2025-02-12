import React, { useContext } from 'react'
import "./ProductDisplay.css"
import { ShopContext } from '../../Context/ShopContext';

export default function ProductDisplay(props) {
    const {product}= props;
    const {addToCart}=useContext(ShopContext);
  return (
    <div className='productdisplay'>
      <div className="productdisplay-left">
          <div className="productdisplay-img-list">
            <img src={product.image} alt="" />
            <img src={product.image} alt="" />
            <img src={product.image} alt="" />
            <img src={product.image} alt="" />
            </div> 
            <div className="productdisplay-img">
                <img className='productdisplay-main-img' src={product.image} alt="" />
            </div>
      </div>
      <div className="productdisplay-right">
       <h1>{product.name}</h1>
       <div className="productdisplay-right-stars">
        <img src="" alt="" />
        <img src="" alt="" />
        <img src="" alt="" />
        <img src="" alt="" />
        <img src="" alt="" />
        <p>(122)</p>
       </div>
       <div className="productdisplay-right-prices">
        <div className="productdisplay-right-price-old">Rs{product.old_price}</div>
        <div className="productdisplay-right-price-new">Rs{product.new_price}</div>
       </div>
       <div className="productdisplay-right-description">
        A lightweight,pullover shirt
       </div>
       <div className="productdisplay-right-size">
        <h1>Select Size</h1>
        <div className="productdisplay-right-size">
            <div>S</div>
            <div>M</div>
            <div>L</div>
            <div>XL</div>
            <div>XXL</div>
        </div>
       </div>
       <button onClick={()=>{addToCart(product.id)}}>Add To Cart</button>
       <p className='productdisplay-right-category'><span>Category:</span>Women,T-shirt,crop top</p>
       <p className='productdisplay-right-category'><span>Tags:</span>Modern</p>
      </div>
    </div>
  )
}
