import React, { Component } from 'react'

import { Table } from "reactstrap";
import SuperHeroService from '../../services/SuperHeroService';
import { Route } from './';
import { NavLink } from "react-router-dom";

export default class List extends Component {
    constructor(props, context) {
        super(props, context);
        this.doRouting = this.doRouting.bind(this)
        this.state = {
            heroes: []
        }
    }
    componentDidMount() {
        SuperHeroService.findAll((err, heroes) => {
            if (!err) {
                this.setState({
                    heroes: heroes
                });
            }
        })
    }

    doRouting(hero) {
        console.log("yo jack");
        console.log(hero);
        this.props.history.push(Route.view.replace(":id", hero.id));
    }

    render() {
        const { heroes } = this.state;

        const trs = heroes.map(hero => (
            <tr onClick={e => this.doRouting(hero)}>
                <th scope="row">{hero.id}</th>
                <td>{hero.firstname}</td>
                <td>{hero.lastname}</td>
                <td>{hero.superheroname}</td>
            </tr>
        ));
        return (
            <div>
                <NavLink className="btn btn-default btn-success" to={Route.create}>Create new Hero</NavLink>
                <Table>
                    ALLO MONSEUR
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Super Hero Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        {trs}
                    </tbody>
                </Table>
            </div>
        )
    }
}
