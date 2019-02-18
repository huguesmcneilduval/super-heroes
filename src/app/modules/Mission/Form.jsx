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

export default class MissionForm extends Component {
    render() {
        const { mission, onChange } = this.props;
        return (
            <div>
                <FormGroup>
                    <Label for="missionName">Mission Name</Label>
                    <FormControl type="text" name="missionName" id="missionName" placeholder="Mission Name"
                        value={mission.missionName} onChange={onChange} />
                </FormGroup>
                
                
            </div>
        )
    }
}
