import React from 'react';
import { Route } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import PostListPage from './pages/PostListPage';

const App = () => {
  return (
    <>
      <Route component={PostListPage} path={["/@:username",'/']} exact></Route>
      <Route component={LoginPage} path="/login"></Route>
      <Route component={RegisterPage} path="/register"></Route>
    </>
  );
};

export default App;