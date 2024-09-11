import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddTodo = () => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [timeAllocated, setTimeAllocated] = useState('');
  const [timeSpent, setTimeSpent] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('/api/todos', { name, description, timeAllocated, timeSpent })
      .then(() => navigate('/'));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" placeholder="Task" value={name} onChange={e => setName(e.target.value)} />
      <input type="text" placeholder="Description" value={description} onChange={e => setDescription(e.target.value)} />
      <input type="text" placeholder="Time Allocated" value={timeAllocated} onChange={e => setTimeAllocated(e.target.value)} />
      <input type="text" placeholder="Time Spent" value={timeSpent} onChange={e => setTimeSpent(e.target.value)} />
      <button type="submit">Add Todo</button>
    </form>
  );
};

export default AddTodo;
