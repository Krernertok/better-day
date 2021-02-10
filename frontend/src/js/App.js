import React, { useState, useEffect } from 'react'
import Header from './components/Header'
import Checklist from './components/Checklist'

const App = () => {
  const [items, setItems] = useState([])

  const itemUrl = 'http://localhost:3001/api/items'

  useEffect(() => {
    fetch(itemUrl)
      .then(response => response.json())
      .then(itemData => setItems(itemData))
  }, [])

  return (
    <>
      <Header title='Better Days' />
      <Checklist itemGroups={items} />
    </>
  )
}

export default App