import React, { useContext } from 'react'
import "./CSS/ShopCategories.css"
import { ShopContext } from '../Context/ShopContext'
import all_product from '../Components/Assets/all_product';
import Item from '../Components/Item/Item';

export default function ShopCategories(props) {
  const {all_product}=useContext(ShopContext);
  return (
    <div className='shop-category'>
      <img className='shopcategory-banner' src={props.banner} alt=""/>
      <div className='shopcategory-indexsort'>
        <p>
          <span>Showing 1-3</span> out of 5 products
        </p>
        <div className='shopcategory-sort'>
          sort by 
        </div>
      </div>
      <div className="shopcategory-products">
        {all_product.map((item,i)=>{
          if(props.category===item.category)
          {
            return <Item key={i} id={item.id} name={item.name} image={item.image} new_price={item.new_price} old_price={item.old_price}/>
          }
          else{
            return null;
          }
        })}
      </div>
      {/* <div className='shopcategory-loadmore'>
        Explore More
      </div> */}
    </div>
  )
}
