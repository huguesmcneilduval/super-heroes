import React, { Component } from 'react'
import { Form as MissionForm } from "./";
import { NavLink } from "react-router-dom";

import { Container, Form, Button } from "reactstrap";
import MissionService, { Schema } from "../../services/MissionService";

import { Route } from './';

export default class Create extends Component {
    constructor(props, context) {
        super(props, context);
        this.onChange = this.onChange.bind(this);
        this.doSubmit = this.doSubmit.bind(this);

        this.state = {
            mission: Schema
        }
    }

    onChange(e) {
        const { name, value } = e.target;
        this.setState({
            mission: {
                ...this.state.mission,
                [name]: value
            }
        })

    }
    doSubmit(e) {
        e.preventDefault();
        console.log("yo");
        console.log(this.state.mission);
        MissionService.create(this.state.mission, (err) => {
            if (!err) {
                this.props.history.push(Route.main);
            } else {
                alert("SOMETHING WENT WRONG!");
            }
        })
    }
    render() {
        const { mission } = this.state;
        return (
            <Container className="mb-5 pb-5">
                <h1>Create Mission</h1>
                <Form onSubmit={this.doSubmit}>
                    <MissionForm mission={mission} onChange={this.onChange}></MissionForm>
                    <Button className="btn btn-default btn-success" onClick={this.doSubmit}>Create</Button>
                    <NavLink className="btn btn-default btn-danger float-right" to={Route.main}>Cancel</NavLink>
                </Form>
            </Container>
        )
    }
}
