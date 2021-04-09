import React,{Component} from 'react';
import { NavLink, Route, useParams } from 'react-router-dom';

var contents = [
    {id:1, title:'HTML', description:'HTML is ...'},
    {id:2, title:'CSS', description:'CSS is ...'},
    {id:3, title:'JS', description:'JS is ...'}
]

function Topic(){
    var params = useParams();
    console.log(params);
    var topic_id = params.topic_id;
    var selected_topic = {
        title : 'Page',
        description : 'Not Found'
    }
    for(var i=0;i<contents.length;i++){
        if(contents[i].id === Number(topic_id)){
            selected_topic = contents[i];
            break;
        }
    }
    return(
        <div>
            <h3>{selected_topic.title}</h3>
            {selected_topic.description}
        </div>
    )
}

export default class Topics extends Component{
    render(){
        var list = [];
        for (var i=0;i<contents.length;i++){
            list.push(
                <li key={contents[i].id}><NavLink
                    to={'/topics/'+contents[i].id}>{contents[i].title}
                </NavLink></li>
            )
        }
        return(
            <div>
                <h2>Topics</h2>
                <ul>
                    {list}
                </ul>
                <Route path="/topics/:topic_id">
                    <Topic></Topic>
                </Route>
            </div>
        )
    }
}