import React, { useContext, useRef, useState } from 'react'
import "./Navbar.css"
import logo from '../Assets/favicon.ico'
import { Link } from 'react-router-dom';
import { ShopContext } from '../../Context/ShopContext';
import cart_icon from "../Assets/cart_icon.jpg"
import dropdown_image from "../Assets/dropdown_image.png"

export default function Navbar() {

    const[menu,setMenu]=useState("shop");
    // const[getTotalCartItems]=useContext(ShopContext);
    const menuRef=useRef();
    const dropdown_toggle=(e)=>{
       menuRef.current.classList.toggle('nav-menu-visible')
       e.target.classList.toggle('open');
    }
  return (
    <div className='navbar'>
      <div className='nav-logo'>
      <img src={logo} alt=""/>
      <p>Clothico</p>
      <img className='nav-dropdown' onClick={dropdown_toggle} src={dropdown_image} alt="" />
      </div>
      <ul ref={menuRef} className='nav-menu'>
        <li onClick={()=>{setMenu("shop")}}><Link style={{textDecoration:"none"}} to="/">Shop</Link> {menu==="shop"?<hr/>:<></>}</li>
        <li onClick={()=>{setMenu("mens")}}><Link style={{textDecoration:"none"}} to="/mens">Men</Link> {menu==="mens"?<hr/>:<></>}</li>
        <li onClick={()=>{setMenu("womens")}}><Link style={{textDecoration:"none"}} to="/womens">Women</Link> {menu==="womens"?<hr/>:<></>}</li>
      </ul>
     <div className='nav-login'>
      {localStorage.getItem('auth-token')
      ?<button onClick={()=>{localStorage.removeItem('auth-token');window.location.replace('/')}}>Logout</button>
      :<Link to="/login"><button>Login</button></Link>}
     {/* <Link to="/cart"><img src={cart_icon} alt="" /></Link>  */}
     {/* <div className="nav-cart-count">0</div> */}
     </div>
    </div>
  )
}
