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
          console.log(parts[0]);
          // setUser(response.data.username);
        }
      });
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
            component={() => <Signup handleRegister={handleSubmitRegister} />}
          />
          <Route
            path='/Signin'
            component={() => (
              <SignIn handleLogin={handleSubmitSign} user={user} />
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
              <AdminSignin handleLogin={handleSubmitAdminSign} user={user} />
            )}
          />
          <Route
            path='/AdminPortal'
            component={() => (
              <AdminPortal handleLogin={handleSubmitAdminSign} user={user} />
            )}
          />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
