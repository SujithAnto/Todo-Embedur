import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Search from './Search';

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [filter, setFilter] = useState('pending');
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    axios.get('/api/todos')
      .then(response => setTodos(response.data));
  }, []);

  const filteredTodos = todos.filter(todo => 
    (filter === 'all' || todo.status === filter) &&
    (todo.name.toLowerCase().includes(searchTerm.toLowerCase()))
  );

  return (
    <div>
      <Search setSearchTerm={setSearchTerm} />
      <button onClick={() => setFilter('pending')}>Pending</button>
      <button onClick={() => setFilter('completed')}>Completed</button>
      <button onClick={() => setFilter('all')}>All</button>
      <table>
        <thead>
          <tr>
            <th>Task</th>
            <th>Description</th>
            <th>Time Allocated</th>
            <th>Time Spent</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {filteredTodos.map(todo => (
            <tr key={todo.id}>
              <td>{todo.name}</td>
              <td>{todo.description}</td>
              <td>{todo.timeAllocated}</td>
              <td>{todo.timeSpent}</td>
              <td><Link to={`/edit/${todo.id}`}>Edit</Link></td>
              <td><button onClick={() => handleDelete(todo.id)}>Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
      <Link to="/add">Add New Todo</Link>
    </div>
  );

  function handleDelete(id) {
    axios.delete(`/api/todos/${id}`)
      .then(() => setTodos(todos.filter(todo => todo.id !== id)));
  }
}

export default TodoList;
