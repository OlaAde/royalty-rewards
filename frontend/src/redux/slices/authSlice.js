import {createSlice} from '@reduxjs/toolkit'
import _ from 'lodash'

const initialState = {}

export const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    addAuth: (state, action) => {
      return { ...state, ...action.payload }
    },
  }
})

export const { addAuth, removeAuth, addToken } = authSlice.actions

export const userSelector = (state) => _.get(state, 'auth.user', '')

export default authSlice.reducer
