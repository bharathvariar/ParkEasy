import "./App.css";
import { HomePage } from "./HomePage";
import Navbar from "./Navbar";
import Signup from "./Signup";
import SignIn from "./Signin";
import PricingContent from "./Pricing";
import AddressForm from "./Payment/AddressForm";
import Checkout from "./Payment/Checkout";
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
          <Route path='/Pricing' component={PricingContent} />
          <Route path='/Checkout' component={Checkout} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
