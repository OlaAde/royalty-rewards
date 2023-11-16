import {createSlice} from '@reduxjs/toolkit'
import _ from 'lodash'

const initialState = {
    items: {}
}

export const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {
        addToCart: (state, action) => {
            state.items = {...state.items, [action.payload.id]: action.payload};
        },
        clearCart: (state) => {
            state.items = {}
        },
        removeFromCart: (state, action) => {
            let dupe = {...state.items}
            delete dupe[action.payload.id]
            state.items = dupe
        }
    }
})

export const {addToCart, removeFromCart, clearCart} = cartSlice.actions

export const cartSelector = (state) => _.get(state, 'cart.items', {})

export default cartSlice.reducer
