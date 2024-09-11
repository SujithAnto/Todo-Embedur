import React from 'react';

const Search = ({ setSearchTerm }) => {
  const handleChange = (e) => {
    setSearchTerm(e.target.value);
  };

  return (
    <input type="text" placeholder="Search..." onChange={handleChange} />
  );
};

export default Search;
