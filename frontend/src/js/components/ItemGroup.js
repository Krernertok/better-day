import React, { useState } from 'react'
import Item from './Item'
import GroupTitle from './GroupTitle'

const ItemGroup = ({ title, items }) => {
  const [ showItems, toggleShowItems ] = useState(true)

  const clickHandler = () => {
    toggleShowItems(!showItems)
  }

  return (
    <div id={ title } className="itemGroup">
      <GroupTitle title={ title } clickHandler={ clickHandler } />
      { items.map(item => <Item 
                            key={ item.id } 
                            item={ item }
                            showItems={ showItems }
                          />) }
    </div>
  )
}

export default ItemGroup