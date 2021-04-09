import React, { Component } from 'react';

class UpdateContent extends Component{
    constructor(props){
        super(props);
        this.state = {
            id : this.props.data.id,
            title : this.props.data.title,
            desc : this.props.data.desc
        }
        this.inputFormHandler = this.inputFormHandler.bind(this);
    }
    inputFormHandler(e){
        var _title = document.getElementById("title").value;
        var _desc = document.getElementById("desc").value;
        
        this.setState({title:_title});
        this.setState({desc:_desc});
    }
    render(){
        console.log('==> UpdateConent render');
        console.log(this.props.data);
        return(
            <article>
                <h2>Update</h2>
                <form
                    action="/update_process"
                    methos="post"
                    onSubmit={function(e){
                        e.preventDefault();
                        this.props.onSubmit(
                            this.state.id,
                            document.getElementById("title").value.trim(),
                            document.getElementById("desc").value.trim()
                        );
                    }.bind(this)}
                >
                    <input type="hidden" name="id" value={this.state.id}/>
                    <p>
                        <input
                            id="title"
                            type="text"
                            name="title"
                            placeholder="title"
                            value={this.state.title}
                            onChange={this.inputFormHandler}
                        ></input>
                    </p>
                    <p>
                        <textarea
                            id="desc"
                            name="desc"
                            placeholder="description"
                            value={this.state.desc}
                            onChange={this.inputFormHandler}
                        ></textarea>
                    </p>
                    <p>
                        <input
                            type="submit" value="Submit"
                        ></input>
                    </p>
                </form>
            </article>
        );
    }
}

export default UpdateContent;