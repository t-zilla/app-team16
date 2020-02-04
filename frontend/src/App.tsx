import React from 'react';
import './App.css';
import Dashboard from './components/containers/Dashboard';
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Login from './components/single-pages/Login';

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/login">
          <Login/>
        </Route>
        <Dashboard/>  
      </Switch>
    </Router>
  );
}

export default App;
