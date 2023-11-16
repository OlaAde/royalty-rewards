import React from 'react';
import './Pages.css';
import Header from '../components/Header';
import {useDispatch, useSelector} from "react-redux";
import {cartSelector, clearCart, removeFromCart} from "../redux/slices/cartSlice";
import {userSelector} from "../redux/slices/authSlice";
import {useNavigate} from "react-router-dom";

const CartPage = () => {
    const cartProducts = Object.values(useSelector(cartSelector));

    const {token} = useSelector(userSelector);
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const handleRemove = (product) => {
        dispatch(removeFromCart(product))
    };

    const handleDone = () => {

        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Authorization", "Bearer " + token);
        myHeaders.append("NAME", "Bearer " + token);
        const payload = {
            productIds: cartProducts.map(p => p.id)
        }

        fetch('http://localhost:8080/api/v1/purchases', {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(payload)
        }).then(res => res.json()).then(res => {
            if (res.id) {
                dispatch(clearCart())
                navigate(0)
            }
        })
    };


    return (
        <div className='cart-container-out'>
            <Header/>
            <div className='cart-container-inner'>
                <h1>Shopping Cart</h1>
                <ul className="product-list">
                    {cartProducts.map((product) => (
                        <li key={product.id} className="product-item">
                            <div className="product-info">
                                <img src={product.image} alt={product.name} className="product-image"/>
                                <div className="product-details">
                                    <div className="product-name">{product.name}</div>
                                    <div className="product-price">${product.price}</div>
                                    <div className="product-price">Point to be
                                        awarded: {product.pointsToBeAwarded}</div>
                                </div>
                            </div>
                            <button onClick={() => handleRemove(product)} className="remove-button">Remove</button>
                        </li>
                    ))}
                </ul>
                <div>Total:
                    ${Math.round(cartProducts.reduce((total, product) => total + parseFloat(product.price), 0))} </div>
                <div>Total point to be
                    awarded: {Math.round(cartProducts.reduce((total, product) => total + parseInt(product.pointsToBeAwarded), 0))} </div>
                {cartProducts.length > 0 ? <button onClick={handleDone} className="done-button">Pay Now</button> :
                    <div> You have no products in cart, You can add one <a href={'/home'}>here </a></div>}
            </div>
        </div>
    );
};

export default CartPage;
