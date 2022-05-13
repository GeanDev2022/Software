import { createStore, combineReducers, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';
import { appointmentReducer } from '../reducers/appointmentReducer';
import { authReducer } from '../reducers/authReducer';
import { commentReducer } from '../reducers/commentReducer';
import { serviceReducer } from '../reducers/serviceReducer';
import { userReducer } from '../reducers/userReducer';


const composeEnhancers = (typeof window !== 'undefined' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__) || compose;

const reducers = combineReducers({
    auth: authReducer,
    Service: serviceReducer,
    Appointment: appointmentReducer,
    Comment: commentReducer,
    userTop : userReducer
   
});


export const store = createStore(
    reducers,
    composeEnhancers(
        applyMiddleware( thunk )
    )
);