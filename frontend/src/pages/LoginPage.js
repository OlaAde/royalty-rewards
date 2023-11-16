import React, {useState} from 'react';
import './Pages.css';
import {useNavigate} from "react-router-dom";
import {addAuth} from "../redux/slices/authSlice";
import {useDispatch} from "react-redux";
import toast from "react-hot-toast";

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const dispatch = useDispatch()
    const notify = (message) => toast(message);
    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        fetch('http://localhost:8080/api/v1/auth/login', {
            method: 'POST',
            headers: {'Content-Type': 'Application/json'},
            body: JSON.stringify({email, password})
        }).then(response => response.json()).then((response) => {
            if (response.id) {
                console.log('response', response)
                dispatch(addAuth({user:response}))
                navigate('/home')
            } else {
                notify(response?.title ?? response ?? 'Error occurred')
            }
        }).catch(err => {
            notify(err.title)
        })
    };

    return (
        <div className="container">
            <form className="form" onSubmit={handleSubmit}>
                <h2>Login</h2>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        placeholder="Enter your email"
                        value={email}
                        onChange={handleEmailChange}
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        placeholder="Enter your password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                </div>
                <button type="submit">Login</button>
                <a href={"/signup"}> Sign Up</a>
            </form>
        </div>
    );
};

export default Login;

