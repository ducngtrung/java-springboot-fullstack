import React from "react";
import MenuItem from "./MenuItem";

// Destructuring Assignment - ES6
function Menu(props) {
    console.log(props);

    const menus = props.menus;
    const name = props.name;
    // const {menus, name} = props;
    return (
        <>
            <h2>Name: {name}</h2>
            <div className="menu-list">
                {menus.map(menu => (
                    // <a key={menu.path} href={menu.path} className="menu-item">{menu.label}</a>
                    <MenuItem key={menu.path} menu={menu}/>
                ))}
            </div>
        </>  
    );
}

export default Menu;