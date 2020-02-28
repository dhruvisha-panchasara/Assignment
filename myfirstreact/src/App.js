import React from 'react';
import Home from "./page/Home";
import About from "./page/About";
import User from "./page/User";
import Login from "./page/Login";
import { BrowserRouter as Router, Switch,Route,Link} from "react-router-dom";

function App() {
  return (
    <Router>
      <div>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/About">About</Link>
          </li>
          <li>
            <Link to="/User">Add User</Link>
          </li>
          <li>
            <Link to="/Login">Login</Link>
          </li>
        </ul>

        <hr/>
        
        <Switch>
          <Route path="/About">
            <About/>
          </Route>
          <Route path="/User">
            <User />
          </Route>
          <Route path="/">
            <Home />
          </Route>
          <Route path="/Login">
            <Login />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}
export default App;