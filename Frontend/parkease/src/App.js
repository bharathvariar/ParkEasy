import "./App.css";
import { HomePage } from "./HomePage";
import Navbar from "./Navbar";
import Signup from "./Signup";
import SignIn from "./Signin";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className='App'>
        <Navbar></Navbar>
        <Switch>
          <Route path='/' exact component={HomePage} />
          <Route path='/Signup' component={Signup} />
          <Route path='/Signin' component={SignIn} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
