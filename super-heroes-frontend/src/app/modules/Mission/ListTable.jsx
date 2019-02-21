import React, { Component } from 'react';

import { withRouter } from "react-router-dom";

import { Route } from "./";

import { Table } from "reactstrap";

export default withRouter(class ListTable extends Component {
    constructor(props, context) {
        super(props, context);
        this.doRouting = this.doRouting.bind(this)
    }
    doRouting(hero) {
        this.props.history.push(Route.view.replace(":id", hero.id));
    }

    render() {
        const { missions } = this.props;

        const trs = missions.map(mission => (
            <tr onClick={e => this.doRouting(mission)}>
                <th scope="row">{mission.id}</th>
                <td>{mission.missionName}</td>
                <td>{mission.completed ? "Completed" : "Not Completed"}</td>
            </tr>
        ));

        return (
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
        )
    }
});
