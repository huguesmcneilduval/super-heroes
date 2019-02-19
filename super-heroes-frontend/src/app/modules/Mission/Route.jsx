import React, { Component } from 'react'
import { Route, Switch, Redirect } from "react-router-dom";

import { List, Create, View, Edit } from "./";

const BASE_ROUTE = "/mission"
const Routing = {
    main: `${BASE_ROUTE}/`,
    create : `${BASE_ROUTE}/create`,
    edit : `${BASE_ROUTE}/edit/:id`,
    view : `${BASE_ROUTE}/view/:id`,
}
export {
    Routing as Route
};

export default class SuperHeroRoute extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route exact path={Routing.main} component={List}></Route>
                    <Route exact path={Routing.view} component={View}></Route>
                    <Route exact path={Routing.create} component={Create}></Route>
                    <Route exact path={Routing.edit} component={Edit}></Route>
                    <Redirect to={Routing.main}></Redirect>
                </Switch>
            </div>
        )
    }
}
