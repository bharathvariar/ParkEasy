import React from "react";
import Navbar from "./Navbar";
import newpurple from "./newpurple.png";
import "./HomePage.css";
export const HomePage = () => {
  return (
    <>
      <Navbar></Navbar>
      <div className='homepage'>
        <div className='homepage__content'>
          <h1>WELCOME!</h1>
          <h3>To ParkEasy</h3>
          <hr />
          <p>
            ParkEase is a website that books parking slots in advance for people
            travelling to crowded locations.
          </p>
          <button className='btn'>BOOK NOW</button>
        </div>
        <div className='homepage__image'>
          <img src={newpurple} alt='' />
        </div>
      </div>
    </>
  );
};
