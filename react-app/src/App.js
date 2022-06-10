import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import StudentList from './StudentList';
import GroupEdit from './GroupEdit';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/students' exact={true} component={StudentList}/>
          <Route path='/new' exact={true} component={GroupEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
