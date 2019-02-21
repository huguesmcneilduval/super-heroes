import React, { Component } from 'react';
import { withRouter, NavLink } from "react-router-dom";
import { Table, Button } from "reactstrap";
import { Route, style } from "./";

import MissionService from "../../services/MissionService";
import SuperHeroService, { Schema } from "../../services/SuperHeroService";


export default withRouter(class EditMission extends Component {
    constructor(props, context) {
        super(props, context);
        this.doRouting = this.doRouting.bind(this);
        this.select = this.select.bind(this)
        this.heroHasMission = this.heroHasMission.bind(this)
        this.save = this.save.bind(this);

        this.state = {
            missions: [],
            hero: Schema
        }
    }

    componentDidMount() {
        SuperHeroService.findById(this.props.match.params.id, (err, hero) => {
            if (!err) {
                MissionService.findAll((err, missions) => {
                    if (!err) {
                        this.setState({
                            hero: hero,
                            missions: missions
                        })
                    }
                });

            }
        })

    }

    save(e) {
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

    select(mission) {
        const { hero } = this.state;

        const heroMission = mission.selected ? hero.missions.filter(hM => hM.id !== mission.id) : hero.missions.concat([mission]);

        this.setState({
            hero: {
                ...hero,
                missions: heroMission
            }
        })
    }

    doRouting(hero) {

        this.props.history.push(Route.view.replace(":id", hero.id));
    }

    heroHasMission(mission) {
        const { hero } = this.state;
        return hero.missions.filter(heroMission => heroMission.id === mission.id).length > 0;
    }

    render() {
        const { missions, hero } = this.state;

        const trs = missions.map(mission => {
            return {
                ...mission,
                selected: this.heroHasMission(mission)
            }
        }).map((mission,i) => (
            <tr key={i} className={mission.selected ? style.selected : ""} onClick={e => this.select(mission)}>
                <th scope="row">{mission.id}</th>
                <td>{mission.missionName}</td>
                <td>{mission.completed ? "Completed" : "Not Completed"}</td>
            </tr>
        ));

        return (
            <div>
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

                <Button onClick={this.save} className="btn btn-default btn-success">Save</Button>
                <NavLink to={Route.view.replace(":id", hero.id)} className="btn btn-default btn-danger float-right">Cancel</NavLink>
            </div>

        )
    }
});
