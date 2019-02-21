import React, { Component } from 'react'
import { Form as MissionForm } from ".";

import { NavLink } from "react-router-dom";

import { Container, Form, Button } from "reactstrap";
import MissionService, { Schema } from "../../services/MissionService";

import { Route } from '.';

export default class Create extends Component {
    constructor(props, context) {
        super(props, context);
        this.doDelete = this.doDelete.bind(this);
        this.doComplete = this.doComplete.bind(this);

        this.state = {
            mission: Schema
        }
    }
    componentDidMount() {
        MissionService.findById(this.props.match.params.id, (err, mission) => {
            if (!err) {
                this.setState({
                    mission: mission
                });
            } else {
                alert("CATASTROPHE");
            }
        })
    }

    doDelete() {
        MissionService.delete(this.state.mission.id, (err) => {
            if (!err) {
                this.props.history.push(Route.main);
            }
        })
    }
    doComplete(e) {
        e.preventDefault();
        const { mission } = this.state;
        this.save({
            ...mission,
            completed: true
        });

    }
    save(mission) {
        MissionService.save(mission.id, mission, (err) => {
            if (!err) {
                this.props.history.push(Route.main);
            } else {
                alert("SOMETHING WENT WRONG!");
            }
        });
    }

    render() {
        const { mission } = this.state;
        return (
            <Container className="mb-5 pb-5">
                <h1>Mission : {mission.missionName}</h1>
                <Form onSubmit={e => e.preventDefault()}>
                    <MissionForm mission={mission}></MissionForm>

                    <NavLink className="btn btn-default btn-success" to={Route.edit.replace(":id", mission.id)}>Edit Mission</NavLink>

                    <Button className="btn btn-default btn-success" disabled={mission.completed} onClick={this.doComplete}>{mission.completed ? "Completed" : "Mark as completed"}</Button>

                    <NavLink className="btn btn-default btn-danger float-right" to={Route.main}>Cancel</NavLink>

                    <Button className="btn btn-default btn-danger float-top float-right" onClick={this.doDelete} disabled={mission.completed}>{mission.completed ? "Cannot delete completed mission" : "Delete"}</Button>
                </Form>
            </Container>
        )
    }
}
