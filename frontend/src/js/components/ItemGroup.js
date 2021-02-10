import React from 'react'
import Item from './Item'

const ItemGroup = ({ title, items }) => {
  return (
    <div>
      <h3>{ title }</h3>
      { items.map(item => <Item 
                            key={ item.id } 
                            summary={ item.summary}
                            description={ item.description}
                          />) }
    </div>
  )
}

export default ItemGroup