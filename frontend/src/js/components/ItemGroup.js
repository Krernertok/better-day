import React, { useState } from 'react'
import Item from './Item'

const ItemGroup = ({ title, items }) => {
  const [ showItems, toggleShowItems ] = useState(true)

  const clickHandler = () => {
    toggleShowItems(!showItems)
  }

  return (
    <div id={ title }>
      <h3 onClick={ clickHandler }>{ title }</h3>
      { items.map(item => <Item 
                            key={ item.id } 
                            item={ item }
                            showItems={ showItems }
                          />) }
    </div>
  )
}

export default ItemGroup