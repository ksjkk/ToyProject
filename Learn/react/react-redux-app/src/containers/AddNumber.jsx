import AddNumber from './../components/AddNumber';
import {connect} from 'react-redux';

function mapReduxDispatchToReactProps(dispatch){
    return {
        onClick : function(_size){
            dispatch({type:'INCRE',size:_size})
        }
    }
}
export default connect(null,mapReduxDispatchToReactProps)(AddNumber);
/*
import React, {Component} from 'react'
import store from './../store';
export default class extends Component{
    render(){
        return <AddNumber onClick={function(_size){
            store.dispatch({type:'INCRE',size:_size});
        }} />
    }
}
*/