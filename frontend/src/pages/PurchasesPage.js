import React, {useEffect, useState} from 'react';
import './Pages.css';
import Header from '../components/Header';
import {useSelector} from "react-redux";
import {userSelector} from "../redux/slices/authSlice";

const PurchasesPage = () => {
    const {token} = useSelector(userSelector);
    const [purchases, setPurchases] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/purchases/me', {headers: {'Authorization': 'Bearer ' + token}}).then(res => res.json()).then(setPurchases);
    }, [token]);

    return (
        <div className='cart-container-out'>
            <Header/>
            <div className='cart-container-inner'>
                <h1>Purchases</h1>
                <ul className="product-list">
                    {purchases.filter(p => p.products?.length > 0).map((purchase) => (
                        <li key={purchase.id} className="product-item">
                            <div className="product-info">
                                {(purchase.products ?? []).map(product => <img src={product.image} alt={product.name}
                                                                               className="product-image"/>)}
                                <div className="product-details">
                                    <div className="product-name">{purchase.products.map(p => p.name).join(' ; ')}</div>
                                    <div className="product-price">${purchase.price}</div>
                                </div>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default PurchasesPage;
