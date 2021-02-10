import React from 'react'

const Item = ({ summary, description }) => {
  return (
    <div>
      <p>{ summary }</p>
      <p>{ description }</p>
    </div>
  )
}

export default Item