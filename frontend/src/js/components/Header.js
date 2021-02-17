import React from 'react'

const Header = ({ title }) => (
  <div className="headerBar">
    <div className="contentContainer">
      <h1 className="siteName">{ title }</h1>
    </div>
  </div>
)

export default Header