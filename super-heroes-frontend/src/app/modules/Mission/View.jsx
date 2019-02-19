import React, { Component } from 'react'
import { Form as SuperHeroForm } from ".";

import { NavLink } from "react-router-dom";

import { Container, Form, Button } from "reactstrap";
import SuperHeroService, { Schema as SuperHeroSchema } from "../../services/SuperHeroService";

import { Route } from '.';

export default class Create extends Component {
    constructor(props, context) {
        super(props, context);
        this.doDelete = this.doDelete.bind(this)
        this.state = {
            hero: SuperHeroSchema
        }
    }
    componentDidMount() {
        SuperHeroService.findById(this.props.match.params.id, (err, hero) => {
            if (!err) {
                this.setState({
                    hero: hero
                });
            } else {
                alert("CATASTROPHE");
            }
        })
    }

    doDelete() {
        SuperHeroService.delete(this.state.hero.id, (err) => {
            if (!err) {
                this.props.history.push(Route.main);
            }
        })
    }

    render() {
        const { hero } = this.state;
        return (
            <Container className="mb-5 pb-5">
                <h1>Hello {hero.superheroname}</h1>
                <Form onSubmit={e => e.preventDefault()}>
                    <SuperHeroForm hero={hero}></SuperHeroForm>
                    <Button className="btn btn-default btn-danger float-top float-right" onClick={this.doDelete}>Delete</Button>
                    <NavLink className="btn btn-default btn-success" to={Route.edit.replace(":id", hero.id)}>Edit Super Hero</NavLink>
                    <NavLink className="btn btn-default btn-danger float-right" to={Route.main}>Cancel</NavLink>
                </Form>
            </Container>
        )
    }
}
