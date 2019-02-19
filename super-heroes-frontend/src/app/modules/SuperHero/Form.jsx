import React, { Component } from 'react'
import { FormGroup, Label, Input, FormText } from 'reactstrap';

import Helper from "../../Helpers";

const FormControl = (props) => {
    if (!Helper.isFunction(props.onChange)) {
        return (
            <div>{props.value}</div>
        )
    }
    else {
        return (
            <Input {...props} />
        )
    }
}

export default class SuperHeroForm extends Component {
    render() {
        const { hero, onChange } = this.props;
        return (
            <div>
                <FormGroup>
                    <Label for="firstname">First Name</Label>
                    <FormControl type="firstname" name="firstname" id="firstname" placeholder="First Name"
                        value={hero.firstname} onChange={onChange} />
                </FormGroup>
                <FormGroup>
                    <Label for="lastname">Last Name</Label>
                    <FormControl type="lastname" name="lastname" id="lastname" placeholder="Last Name"
                        value={hero.lastname} onChange={onChange} />
                </FormGroup>
                <FormGroup>
                    <Label for="superheroname">Super Hero Name</Label>
                    <FormControl type="superheroname" name="superheroname" id="superheroname" placeholder="Super Hero Name"
                        value={hero.superheroname} onChange={onChange} />
                </FormGroup>
            </div>
        )
    }
}
