import React, { Component } from 'react';

class Control extends Component{
    render(){
        console.log('==> Control render');
        return(
            <ul>
                <li>
                    <input
                        type="button"
                        value="create"
                        onClick={function(e){
                            e.preventDefault();
                            this.props.onChangeMode('C');
                        }.bind(this)}
                    ></input>
                </li>
                <li>
                    <input
                        type="button"
                        value="update"
                        onClick={function(e){
                            e.preventDefault();
                            this.props.onChangeMode('U');
                        }.bind(this)}
                    ></input>
                </li>
                <li>
                    <input
                        type="button"
                        value="delete"
                        onClick={function(e){
                            e.preventDefault();
                            this.props.onChangeMode('D');
                        }.bind(this)}
                    ></input>
                </li>
            </ul>
        );
    }
}

export default Control;