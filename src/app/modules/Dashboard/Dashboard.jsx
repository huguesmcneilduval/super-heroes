import React, { Component } from 'react'
import { Container } from "reactstrap";

export default class Dashboard extends Component {
    render() {
        return (
            <div>
                <Container>
                    <h1 className="text-center mt-5 pt-5">Welcome in SuperHeroManagement</h1>
                </Container>
            </div>
        )
    }
}
