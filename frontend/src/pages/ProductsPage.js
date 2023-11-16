import React, {useEffect, useState} from 'react';
import Header from "../components/Header";
import {useDispatch, useSelector} from "react-redux";
import {addToCart, cartSelector} from "../redux/slices/cartSlice";

// const products = [
//     {
//         id: 1,
//         name: 'Headphone',
//         price: 19.99,
//         imageUrl: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
//         pointToBeAwarded: 245,
//     },
//     {
//         id: 2,
//         name: 'Wristwatch',
//         price: 24.99,
//         imageUrl: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=1399&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
//         pointToBeAwarded: 389,
//     },
//     {
//         id: 3,
//         name: 'Sunglasses',
//         price: 455.99,
//         imageUrl: 'https://images.unsplash.com/photo-1572635196237-14b3f281503f?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
//         pointToBeAwarded: 178,
//     },
//     {
//         id: 4,
//         name: 'Chair',
//         price: 240.99,
//         imageUrl: 'https://images.unsplash.com/photo-1503602642458-232111445657?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
//         pointToBeAwarded: 432,
//     },
//     {
//         id: 5,
//         name: 'Toy Car',
//         price: 74.99,
//         imageUrl: 'https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 299,
//     },
//     {
//         id: 6,
//         name: 'Lipstick',
//         price: 24.99,
//         imageUrl: 'https://images.unsplash.com/photo-1586495777744-4413f21062fa?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cHJvZHVjdHxlbnwwfHwwfHx8Mg%3D%3D',
//         pointToBeAwarded: 187,
//     },
//     {
//         id: 7,
//         name: 'Pepsi',
//         price: 474.99,
//         imageUrl: 'https://images.unsplash.com/photo-1553456558-aff63285bdd1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cHJvZHVjdHxlbnwwfHwwfHx8Mg%3D%3D',
//         pointToBeAwarded: 326,
//     },
//     {
//         id: 8,
//         name: 'Wristwatch',
//         price: 56.99,
//         imageUrl: 'https://images.unsplash.com/photo-1546868871-7041f2a55e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 241,
//     },
//     {
//         id: 9,
//         name: 'Speaker',
//         price: 31.99,
//         imageUrl: 'https://images.unsplash.com/photo-1543512214-318c7553f230?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 158
//     },
//     {
//         id: 10,
//         name: 'Thermos',
//         price: 68.99,
//         imageUrl: 'https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 172,
//     },
//     {
//         id: 11,
//         name: 'Heels',
//         price: 87.99,
//         imageUrl: 'https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 311,
//     },
//     {
//         id: 12,
//         name: 'Bag',
//         price: 258.99,
//         imageUrl: 'https://images.unsplash.com/photo-1511556820780-d912e42b4980?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D',
//         pointToBeAwarded: 425,
//     }
// ]

const ProductPage = () => {
    const dispatch = useDispatch()
    const [products, setProducts] = useState([]);
    const cartProducts = useSelector(cartSelector);

    const handleAddToCart = (product) => {
        dispatch(addToCart(product))
    }

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/products').then(res => res.json()).then(setProducts);
    }, []);

    return (
        <div className='cart-container-out'>
            <Header/>
            <div className='cart-container-inner'>
                <h1>Products</h1>
                <div style={{display: 'flex', flexWrap: 'wrap'}}>
                    {products.map((product) => (
                        <div key={product.id} style={{margin: '10px', textAlign: 'center'}}>
                            <img src={product.image} alt={product.name} style={{width: '150px', height: '150px'}}/>
                            <div>{product.name}</div>
                            <div>${product.price}</div>
                            <div>{product.pointToBeAwarded}</div>
                            <button disabled={product.id in cartProducts} onClick={() => handleAddToCart(product)}>{product.id in cartProducts ? 'Added to cart' : 'Add to Cart'}</button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default ProductPage;
