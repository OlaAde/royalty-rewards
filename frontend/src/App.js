import React from 'react';

import AuthPages from "./pages/AuthPages";
import {BrowserRouter} from "react-router-dom";
import MainRoutes from "./components/MainRoutes";
import {useSelector} from 'react-redux'
import {userSelector} from "./redux/slices/authSlice";

const App = () => {
    const user = useSelector(userSelector);
    console.log('user', user)
    return (
        <BrowserRouter basename={"/"}>
            <React.Suspense fallback={<div
                className="animated fadeIn pt-3 text-center">Loading...</div>}>
                {user ? <MainRoutes/> : <AuthPages/>}
            </React.Suspense>
        </BrowserRouter>
    );
};

export default App;

