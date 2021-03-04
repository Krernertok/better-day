import React from 'react'

const GroupTitle = ({ title, clickHandler }) => {
  return (
    <div className="groupTitle">
      <h3 onClick={ clickHandler }>{ title }</h3>
    </div>
  )
}

export default GroupTitle