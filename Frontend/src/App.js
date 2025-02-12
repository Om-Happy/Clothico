import logo from './logo.svg';
import './App.css';
import Navbar from './Components/Navbar/Navbar';
import { Routes,Route, BrowserRouter } from 'react-router-dom';
import Shop from './Pages/Shop';
import ShopCategories from './Pages/ShopCategories';
import Footer from './Components/Footer/Footer';
import LoginSignup from "./Pages/LoginSignup";
import banner_women from "./Components/Assets/banner_women.jpg"
import banner_men1 from "./Components/Assets/banner_men1.jpg"
import Product from './Pages/Product';
import Cart from './Pages/Cart';


function App() {
  return (
    <div>
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Shop/>}/>
        <Route path='/mens' element={<ShopCategories banner={banner_men1} category="men"/>}/>
        <Route path='/womens' element={<ShopCategories banner={banner_women} category="women"/>}/>
        <Route path='/product' element={<Product/>}>
        <Route path=":productId" element={<product/>}/>
        </Route>
        {/* <Route path='/cart' element={<Cart/>}/> */}
        <Route path='/login' element={<LoginSignup/>}/>
      </Routes>
      <Footer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
