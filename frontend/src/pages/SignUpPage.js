import React, {useState} from 'react';
import './Pages.css';
import {useNavigate} from "react-router-dom";
import {addAuth} from "../redux/slices/authSlice";
import {useDispatch} from "react-redux";

const Signup = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState("")
    const [fullname, setFullname] = useState('')
    const [address, setAddress] = useState("")
    const [phoneNumber, setPhoneNumber] = useState("")
    const navigate = useNavigate();
    const dispatch = useDispatch()
    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handleConfirmPasswordChange = (e) => {
        setConfirmPassword(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handlePhoneNumberChange = (e) => {
        setPhoneNumber(e.target.value);
    };

    const handleFullnameChange = (e) => {
        setFullname(e.target.value);
    };

    const handleAddressChange = (e) => {
        setAddress(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log('Email:', email);
        console.log('Password:', password);

        fetch('http://localhost:8080/api/v1/auth/register', {
            method: 'POST',
            headers: {'Content-Type': 'Application/json'},
            body: JSON.stringify({email, password, confirmPassword, address, phoneNumber, fullName: fullname})
        }).then(response => response.json()).then((user) => {
            if (user.id) {
                dispatch(addAuth({user}))
                navigate('/home')
            } else {
                console.error(user)
            }
        })


    };

    return (
        <div className="container">
            <form className="form" onSubmit={handleSubmit}>
                <h2>Sign Up</h2>
                <div>
                    <label>Fullname:</label>
                    <input
                        type="text"
                        placeholder="Enter your fullname "
                        value={fullname}
                        onChange={handleFullnameChange}
                    />
                </div>
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
                    <label>Phone number:</label>
                    <input
                        type="text"
                        placeholder="Enter your phone number"
                        value={phoneNumber}
                        onChange={handlePhoneNumberChange}
                    />
                </div>

                <div>
                    <label>Address:</label>
                    <input
                        type="address"
                        placeholder="Enter your address"
                        value={address}
                        onChange={handleAddressChange}
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

                <div>
                    <label>Confirm Password:</label>
                    <input
                        type="password"
                        placeholder="Enter your password again"
                        value={confirmPassword}
                        onChange={handleConfirmPasswordChange}
                    />
                </div>


                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
};

export default Signup;

