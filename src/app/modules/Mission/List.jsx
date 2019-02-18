import React, { Component } from 'react'

import { Table } from "reactstrap";
import SuperHeroService from '../../services/MissionService';
import { Route } from './';
import { NavLink } from "react-router-dom";

export default class List extends Component {
    constructor(props, context) {
        super(props, context);
        this.doRouting = this.doRouting.bind(this)
        this.state = {
            mission: []
        }
    }
    componentDidMount() {
        SuperHeroService.findAll((err, mission) => {
            if (!err) {
                this.setState({
                    mission: mission
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
        const { mission } = this.state;

        const trs = mission.map(mission => (
            <tr onClick={e => this.doRouting(mission)}>
                <th scope="row">{mission.id}</th>
                <td>{mission.missionName}</td>
                <td>{mission.isCompleted ? "Completed" : "Not Completed"}</td>
            </tr>
        ));
        return (
            <div>
                <NavLink className="btn btn-default btn-success" to={Route.create}>Create new Hero</NavLink>
                <Table>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Mission Name</th>
                            <th>Completed</th>
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
