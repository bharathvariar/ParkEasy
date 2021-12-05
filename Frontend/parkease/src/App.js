import "./App.css";
import { useHistory } from "react-router-dom";
import { HomePage } from "./HomePage";
import WelcomeDetails from "./WelcomeDetails";
import Navbar from "./Navbar";
import Services from "./Services";
import AdminSignin from "./AdminSignin";
import Signup from "./Signup";
import SignIn from "./Signin";
import PricingContent from "./Pricing";
import axios from "axios";
import AddressForm from "./Payment/AddressForm";
import AdminPortal from "./AdminPortal";
import Slots from "./Slots";
import Checkout from "./Payment/Checkout";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useState } from "react";
import OTPverification from "./OTPverification";

function App() {
  const [user, setUser] = useState(null);
  const [password, setPassword] = useState(null);
  const [admin, setAdmin] = useState(null);
  const [adminPass, setAdminPass] = useState(null);
  var history = useHistory();

  const handleSubmitRegister = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get("email"),
      password: data.get("password"),
      username: data.get("username"),
    });
    axios
      .post(`http://localhost:8080/parkeasy/user/register`, {
        firstName: data.get("firstName"),
        lastName: data.get("lastName"),
        username: data.get("username"),
        email: data.get("email"),
        password: data.get("password"),
      })
      .then((response) => {
        console.log(response);
        var parts = response.data.email.split("@");
        if (response == "") {
          alert("User already taken");
        } else {
          alert("succefuly registered");

          console.log(parts[0]);
          // setUser(response.data.username);
        }
      });
  };
  const handleOTP = (event) => {
    event.preventDefault();
    let otp = Math.random();
    otp = otp.toString();
    otp = otp[2] + otp[3] + otp[4] + otp[5] + otp[6] + otp[7];
    localStorage.setItem("otp", otp);
    const data = new FormData(event.currentTarget);
    window.Email.send({
      Host: "smtp.gmail.com",
      Username: "parkeasy.help@gmail.com",
      Password: "parking@123",
      To: data.get("email"),
      From: "parkeasy.help@gmail.com",
      Subject: "Registration OTP",
      Body: `Your OTP is ${otp}`,
    }).then((message) => alert(message));
  };
  const handleSubmitSign = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    // eslint-disable-next-line no-console
    console.log({
      usernam: data.get("username"),
      password: data.get("password"),
    });
    axios
      .patch(`http://localhost:8080/parkeasy/user/login`, {
        username: data.get("username"),
        password: data.get("password"),
      })
      .then((response) => {
        console.log(response);
        if (response.data == "") {
          alert("Wrong username or password");
          return "Fail";
        } else {
          console.log(response.data);
          setUser(response.data.username);
          setPassword(response.data.password);
          // history.push("/Welcome");
          return "success";
        }
      });
  };
  const handleSubmitAdminSign = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    // eslint-disable-next-line no-console
    console.log({
      adminId: data.get("adminid"),
      password: data.get("password"),
    });
    axios
      .patch(`http://localhost:8080/parkeasy/admin/login`, {
        adminId: data.get("adminid"),
        password: data.get("password"),
      })
      .then((response) => {
        console.log(response);
        if (response.data == "") {
          alert("Wrong username or password");
          return "Fail";
        } else {
          console.log(response.data);
          setAdmin(response.data.adminId);
          setAdminPass(response.data.password);
          // history.push("/Welcome");
          return "success";
        }
      });
  };
  const handleGoogleLogin = (resp) => {
    setUser(resp.profileObj.givenName);
  };
  const handleLogout = () => {
    axios
      .patch(`http://localhost:8080/parkeasy/user/logout`, {
        username: user,
        password: password,
      })
      .then((response) => {
        setUser(null);
        setPassword(null);
      });
  };
  return (
    <Router>
      <div className='App'>
        <Navbar user={user} handleLogout={handleLogout}></Navbar>
        <Switch>
          <Route path='/' exact component={HomePage} />
          <Route
            path='/Signup'
            component={() => <Signup handleRegister={handleOTP} />}
          />
          <Route
            path='/Signin'
            component={() => (
              <SignIn
                handleLogin={handleSubmitSign}
                user={user}
                handleGoogle={handleGoogleLogin}
              />
            )}
          />
          <Route path='/Pricing' component={PricingContent} />
          <Route path='/Checkout' component={Checkout} />
          <Route path='/Slots' component={Slots} />
          <Route
            path='/Welcome'
            component={() => <WelcomeDetails user={user} />}
          />
          <Route path='/services' component={Services} />
          <Route
            path='/AdminSignin'
            component={() => (
              <AdminSignin
                handleLogin={handleSubmitAdminSign}
                user={user}
                admin={admin}
              />
            )}
          />
          <Route
            path='/AdminPortal'
            component={() => (
              <AdminPortal
                handleLogin={handleSubmitAdminSign}
                user={user}
                admin={admin}
              />
            )}
          />
          <Route path='/Verification' component={OTPverification} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
