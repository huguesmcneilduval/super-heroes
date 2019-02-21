import React, { Component } from 'react'

import SuperHeroService from '../../services/MissionService';
import { Route, ListTable as MissionTable } from './';
import { NavLink } from "react-router-dom";

export default class List extends Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            missions: []
        }
    }
    
    componentDidMount() {
        SuperHeroService.findAll((err, missions) => {
            if (!err) {
                this.setState({
                    missions: missions
                });
            }
        })
    }

    render() {
        const { missions } = this.state;

      
        return (
            <div>
                <NavLink className="btn btn-default btn-success" to={Route.create}>Create new Mission</NavLink>
                <MissionTable missions={missions}></MissionTable>
            </div>
        )
    }
}
