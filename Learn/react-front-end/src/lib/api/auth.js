import client from './client';

export const login = ({ username, password }) =>
    client.post('/api/authenticate',{ username, password });

export const register = ({ username, password }) =>
    client.post('http://localhost:8080/api/register',{ username, password });

export const check = () => client.get('/api/check');