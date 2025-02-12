import React, { useState } from 'react'
import "./CSS/LoginSignup.css"

export default function LoginSignup() {

const [state,setState] = useState("Login");
const [formData,setFormData]=useState({
  firstname:"",
  lastname:"",
  password:"",
  email:"",
  city:"",
  country:""
})

const changeHandler = (e) =>{
  setFormData({...formData,[e.target.name]:e.target.value})
}

const login = async () => {
  console.log("Login Function Executed", formData);
  let responseData;

  try {
    const response = await fetch('http://localhost:8080/Home/SignIn', {
      method: "POST",
      headers: {
        Accept: "application/json",  // Fix the Accept header to expect JSON
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    });

    // Check if the response is ok (status 200-299)
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }

    // Try parsing the response as JSON
    responseData = await response.json();

    if (responseData.success) {
      localStorage.setItem('auth-token', responseData.token);
      window.location.replace("/");
    } else {
      alert(responseData.errors);
    }
  } catch (error) {
    // Catch any errors during the fetch or JSON parsing
    console.error("Login error:", error);
    alert("An error occurred while logging in.");
  }
};
const signup = async () =>{
    console.log("Signup Function Executed",formData);
    let responseData;
    await fetch('http://localhost:8080/Home/SignUp',{
      method:"POST",
      headers:{
        Accept:"application/form",
        'Content-Type':'application/json',
      },
      body:JSON.stringify(formData),
    }).then((response)=>response.json()).then((data)=>responseData=data)

    if(responseData.success){
      
      window.location.replace("/");
    }
    else{
      alert(responseData.errors);
    }
}

  return (
    <div className='loginsignup'>
      <div className="loginsignup-container">
        <h1>{state}</h1>
        <div className='loginsignup-fields'>
         {state === "Sign Up"?<input name="firstname" value={formData.firstname} onChange={changeHandler} type='text' placeholder='First Name'/>:<></>}
         {state === "Sign Up"?<input name="lastname" value={formData.lastname} onChange={changeHandler} type='text' placeholder='Last Name'/>:<></>}
         <input name='email' value={formData.email} onChange={changeHandler} type='email' placeholder='Email Address'/>
         <input name='password' value={formData.password} onChange={changeHandler} type='password' placeholder='Password'/>
         {state === "Sign Up"?<input name="city" value={formData.city} onChange={changeHandler} type='text' placeholder='City Name'/>:<></>}  
         {state === "Sign Up"?<input name="country" value={formData.country} onChange={changeHandler} type='text' placeholder='Country Name'/>:<></>}
        </div>
        <button onClick={()=>{state==="Login"?login():signup()}}>Continue</button>
        {state==="Sign Up"?
        <p className="loginsignup-login">Already Have an account? <span onClick={()=>{setState("Login")}}>Login Here</span></p>:
        <p className="loginsignup-login">Create an account? <span onClick={()=>{setState("Sign Up")}}>Click Here</span></p>}
        
        
        <div className="loginsignup-agree">
          <input type='checkbox' name='' id=''/>
          <p>By continuing, I agree to the terms of use & privacy policy</p>
        </div>
      </div>
    </div>
  )
}
