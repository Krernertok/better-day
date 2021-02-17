import React from 'react'
import ItemGroup from './ItemGroup'

const Checklist = ({ itemGroups }) => {
  return (
    <div className="contentContainer flex-col checklist">
      { itemGroups.map(itemGroup => <ItemGroup 
                                      key={itemGroup.title}
                                      title={itemGroup.title}
                                      items={itemGroup.items}
                                    />) }
    </div>
  )
}

export default Checklist