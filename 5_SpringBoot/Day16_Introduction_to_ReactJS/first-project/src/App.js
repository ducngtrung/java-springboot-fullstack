import React from 'react';
import './App.css';
import Menu from './components/menu/Menu.jsx';

function App() {
  const myStyle = {
    color: "red", 
    backgroundColor: "yellow" 
  };

  const menus = [
    { path: "/", label: "Trang chủ" },
    { path: "/shop", label: "Cửa hàng" },
    { path: "/about", label: "Về chúng tôi" },
    { path: "/contact", label: "Liên hệ" },
  ];

  return (
    <React.Fragment> {/* hoặc <></>, là thẻ ảo dùng để gom nhóm element */}
      <h1 className='heading' style={myStyle}>
        Hello world {1 + 1}!
      </h1>

      <div className="intro-content">
        <h1 className="intro-title">Fashion Trends</h1>
        <p className="intro-description">There are some trends that are just too plain wacky to really affect your wardrobe,
          so for that reason we've left out a few ideas we know you'd rather sidestep.</p>
        <a href="#" className="intro-btn">Buy now</a>
      </div>

      <div className="menu-list">
        {/* Dùng vòng lặp để tạo các thẻ a từ biến "menus" */}
        {menus.map(menu => (
          <a key={menu.path} href={menu.path} className="menu-item">{menu.label}</a>
        ))}

        {/* Nếu sử dụng dấu ngoặc nhọn {} thì phải có từ khóa "return"
        {menus.map(menu => {
          return <a key={menu.path} href={menu.path} className="menu-item">{menu.label}</a>
        })} */}
      </div>

      <Menu menus={menus}/>

    </React.Fragment>
  );
}

export default App;