import React from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";
function Navbar() {
  return (
    <div className='navbar'>
      <li className='navbar__link'>PARKEASY</li>
      <Link
        className='navbar__link'
        to='/Signin'
        style={{ color: "inherit", textDecoration: "inherit" }}>
        <li className='navbar__link2'>Login</li>
      </Link>
    </div>
  );
}

export default Navbar;
