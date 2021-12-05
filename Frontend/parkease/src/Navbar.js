import React from "react";

import "./Navbar.css";
import { Link } from "react-router-dom";
function Navbar(props) {
  const handleClick = () => {
    props.handleLogout();
  };
  const logout = () => {};
  return (
    <div className='navbar'>
      <li className='navbar__link'>PARKEASY</li>

      <Link
        className='navbar__link'
        to={props.user ? "" : "/Signin"}
        onClick={props.user ? handleClick : ""}
        style={{ color: "inherit", textDecoration: "inherit" }}>
        <li className='navbar__link2'>{props.user ? "Logout" : "Login"}</li>
      </Link>
    </div>
  );
}

export default Navbar;
