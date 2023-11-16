import React from 'react';
import {Route, Routes, useNavigate} from "react-router-dom";
import ProductsPage from "../pages/ProductsPage";
import CartPage from "../pages/CartPage";
import {useSelector} from "react-redux";
import {userSelector} from "../redux/slices/authSlice";
import PurchasesPage from "../pages/PurchasesPage";

const MainRoutes = () => {
    const navigate = useNavigate();
    const user = useSelector(userSelector);


    if (!user) {
        navigate('/login')
    }

    return (
        <Routes>
            <Route path={"/purchases"} element={<PurchasesPage/>}/>
            <Route path={"/cart"} element={<CartPage/>}/>
            <Route path={"/home"} element={<ProductsPage/>}/>
            <Route path={"/"} element={<ProductsPage/>}/>
        </Routes>
    );
};

export default MainRoutes;