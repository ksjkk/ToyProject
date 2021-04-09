import React, { Component } from 'react';

class CreateContent extends Component{
    render(){
        console.log('==> CreateContent render');
        return(
            <article>
                <h2>Create</h2>
                <form
                    action="/create_process"
                    methos="post"
                    onSubmit={function(e){
                        e.preventDefault();
                        this.props.onSubmit(
                            document.getElementById("title").value.trim(),
                            document.getElementById("desc").value.trim()
                        );
                    }.bind(this)}
                >
                    <p>
                        <input
                            id="title"
                            type="text"
                            name="title"
                            placeholder="title"
                        ></input>
                    </p>
                    <p>
                        <textarea
                            id="desc"
                            name="desc"
                            placeholder="description"
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

export default CreateContent;