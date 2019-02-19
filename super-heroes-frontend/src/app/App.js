import React, { Component } from 'react'
import {BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";
import SuperHero, { Route as SuperHeroRoute} from "./modules/SuperHero";
import Mission, { Route as MissionRoute} from "./modules/Mission";

import Header from "./modules/Header";

export default class App extends Component {
  render() {
    return (
      <Router>
        <div>

              <Header></Header>
            
              <Switch>
                  <Route path={SuperHeroRoute.main} component={SuperHero}></Route>
                  <Route path={MissionRoute.main} component={Mission}></Route>
                  <Redirect to={SuperHeroRoute.main}/>
              </Switch>
        </div>
      </Router>
    )
  }
}
