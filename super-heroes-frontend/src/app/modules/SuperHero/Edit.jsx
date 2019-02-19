import React, { Component } from 'react'
import { Form as SuperHeroForm } from ".";

import { NavLink } from "react-router-dom";

import { Container, Form, Button } from "reactstrap";
import SuperHeroService, { Schema as SuperHeroSchema } from "../../services/SuperHeroService";

import { Route } from '.';

export default class Edit extends Component {
    constructor(props, context) {
        super(props, context);
        this.onChange = this.onChange.bind(this);
        this.doSubmit = this.doSubmit.bind(this);

        this.state = {
            hero: SuperHeroSchema
        }
    }

    componentDidMount () {
      SuperHeroService.findById(this.props.match.params.id, (err, hero) => {
          if(!err) {
              this.setState({
                  hero : hero
              })
          }
      })
    }
    

    onChange(e) {
        const { name, value } = e.target;
        this.setState({
            hero: {
                ...this.state.hero,
                [name]: value
            }
        })

    }
    doSubmit(e) {
        e.preventDefault();
        const { hero } = this.state;

        SuperHeroService.save(hero.id, hero, (err) => {
            if (!err) {
                this.props.history.push(Route.main);
            } else {
                alert("SOMETHING WENT WRONG!");
            }
        })
    }
    render() {
        const { hero } = this.state;
        return (
            <Container className="mb-5 pb-5">
                <h1>Create Hero</h1>
                <Form onSubmit={this.doSubmit}>
                    <SuperHeroForm hero={hero} onChange={this.onChange}></SuperHeroForm>
                    <Button className="btn btn-default btn-success" onClick={this.doSubmit}>Create</Button>
                    <NavLink className="btn btn-default btn-danger float-right" to={Route.main}>Cancel</NavLink>
                </Form>
            </Container>
        )
    }
}
