import React, {useEffect, useState} from 'react';
import '../pages/Pages.css';
import {userSelector} from "../redux/slices/authSlice";
import {useSelector} from "react-redux";
import {cartSelector} from "../redux/slices/cartSlice";
import {useNavigate} from "react-router-dom";

const Header = () => {
    const {token} = useSelector(userSelector)
    const [user, setUser] = useState();

    const navigate = useNavigate();

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/users/me', {
            headers: {'Authorization': 'Bearer ' + token}
        }).then(res => res.json()).then(setUser).catch(() => {
            localStorage.clear()
            navigate(0);
        });
    }, [navigate, token]);

    const cartItems = useSelector(cartSelector);

    return (
        <div className="header">
            <div className="user-info">
                <div className="user-details">
                    <h1>{user?.fullName}</h1>
                    <p>Points Balance: {user?.pointsBalance}</p>

                    <div>
                        {(Object.keys(cartItems) ?? []).length} items in cart

                        {Object.keys(cartItems).length > 0 && <a href={'/cart'}>View them</a>}
                    </div>
                </div>
                <ul>
                    <li>
                        <a href={'/home'}>Home</a>
                    </li>
                    <li>
                        <a href={'/cart'}>Cart</a>
                    </li>
                    <li>
                        <a href={'/purchases'}>Purchases</a>
                    </li>
                </ul>
            </div>
        </div>
    );
};

export default Header;

