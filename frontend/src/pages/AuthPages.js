import React from 'react';
import {Navigate, Route, Routes} from "react-router-dom";
import LoginPage from "./LoginPage";
import SignUpPage from "./SignUpPage";

const AuthPages = () => {
    return (
        <Routes>
            <Route path={"/signup"} element={<SignUpPage/>}/>
            <Route path={"/login"}  element={<LoginPage/>}/>
            <Route
                path="*"
                element={<Navigate to="/login" replace />}
            />
        </Routes>
    );
};

export default AuthPages;