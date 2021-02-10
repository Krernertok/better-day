import React from 'react'
import ItemGroup from './ItemGroup'

const Checklist = ({ itemGroups }) => {
  return (
    <>
      { itemGroups.map(itemGroup => <ItemGroup 
                                      key={itemGroup.title}
                                      title={itemGroup.title}
                                      items={itemGroup.items}
                                    />) }
    </>
  )
}

export default Checklist