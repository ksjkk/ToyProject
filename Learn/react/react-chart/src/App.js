import React from 'react';
import logo from './logo.svg';
import './App.css';
import Chart from './components/Chart';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          React - Chart
        </p>
      </header>
      <Chart />
    </div>
  );
}

export default App;
