import React, {Component} from 'react';
//import store from './../store';

export default class AddNumber extends Component {
    state = {
        size:1
    };
    render() {
        return (
            <div>
                <h1>Add Number</h1>
                <input id="btn_plus" type="button" value="+" onClick={function(e){
                    this.props.onClick(this.state.size);
                }.bind(this)}/>
                <input id="input_number" type="text" value={this.state.size}
                    onChange={function(){
                        this.setState({size:Number(document.getElementById("input_number").value)});
                    }.bind(this)}
                />
            </div>
        )
    }
}