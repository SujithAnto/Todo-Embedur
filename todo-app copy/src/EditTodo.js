import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const EditTodo = () => {
  const { id } = useParams();
  const [todo, setTodo] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    axios.get(`/api/todos/${id}`)
      .then(response => setTodo(response.data));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.put(`/api/todos/${id}`, todo)
      .then(() => navigate('/'));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" value={todo.name} onChange={e => setTodo({ ...todo, name: e.target.value })} />
      <input type="text" value={todo.description} onChange={e => setTodo({ ...todo, description: e.target.value })} />
      <input type="text" value={todo.timeAllocated} onChange={e => setTodo({ ...todo, timeAllocated: e.target.value })} />
      <input type="text" value={todo.timeSpent} onChange={e => setTodo({ ...todo, timeSpent: e.target.value })} />
      <button type="submit">Update Todo</button>
    </form>
  );
};

export default EditTodo;
