import React from "react";
import { Link } from "react-router-dom";
import newpurple from "./newpurple.png";
import axios from "axios";
import "./HomePage.css";
export const HomePage = () => {
  return (
    <>
      <div className='homepage'>
        <div className='homepage__content'>
          <h1>WELCOME!</h1>
          <h3>To ParkEasy</h3>
          <hr />
          <p>
            ParkEasy is a website that books parking slots in advance for people
            travelling to crowded locations.
          </p>
          <Link
            className='btn__link'
            to='/Signup'
            style={{ color: "inherit", textDecoration: "inherit" }}>
            <button className='btn'>BOOK NOW</button>
          </Link>
        </div>
        <div className='homepage__image'>
          <img src={newpurple} alt='' />
        </div>
      </div>
    </>
  );
};
