import React from 'react'

const Item = ({ item, showItems }) => {
  return (
    <div className="item" style={ showItems ? null: {display: 'none'} }>
      <label htmlFor={ 'item-' + item.id }>{ item.summary }</label>
      <input className="checkbox" type="checkbox" name={ 'item-' + item.id } id={ 'item-' + item.id }/>
    </div>
  )
}

export default Item