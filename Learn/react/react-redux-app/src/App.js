import React,{Component} from 'react';
import './App.css';
import AddNumberRoot from './components/AddNumberRoot';
import DisplayNumberRoot from './components/DisplayNumberRoot';


export default class App extends Component{
  state = {
    number:0
  };
  render(){
    return (
      <div className="App">
        <h1>ANG~도혁띠</h1>
        <AddNumberRoot/>
        <DisplayNumberRoot/>
      </div>
    );
  }
}