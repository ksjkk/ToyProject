import React,{Component} from 'react';
import {Route,Switch, NavLink} from 'react-router-dom';
import MainCss from './MainCss';
import Contact from './components/Contact';
import Home from './components/Home';
import Topics from './components/Topics';
import $ from 'jquery';

export default class App extends Component {
  componentDidMount(){
    //package,json proxy
    
  }
  render(){
    var ajaxFunc = function(){
      var _data = '{"apiKey":"c7c8ebb80b6141aab5cb1365e6ef6fa4"'+
      ',"secret":"ildong1234"'+
      ',"from":"M02"'+
      ',"type":"INFO"'+
      ',"issuer":"system"'+
      ',"title":"Test"'+
      ',"target":["ID0@218076"]'+
      '}';
     console.log(_data);
      $.support.cors = true;
      $.ajax({
        // url : "http://ehr.ildong.com/GetApprovalCnt2.do?enterCd=ID0&sabun=216206",
        //type : "GET",
        url :"https://8vxu0grpsd.execute-api.ap-northeast-2.amazonaws.com/ifm/event/topic",
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        mimeType: 'application/json',
        async: false,
        data : _data,
        success: function(data) { 
          console.log(data);
        },
        error : function(jqXHR,ajaxSettings,thrownError){
          console.log('err',jqXHR,ajaxSettings,thrownError)
        }
        /*
        dataType : "jsonp",
        success : function(res){
          console.log(res.result);
        },
        error : function(req,status,error){
          console.log(req,status,error);
        }
         */
      });
    }
    ajaxFunc();
    return(
      <div className="App">
        <div>
          <MainCss />
        </div>
        <div>
          <h1 className="ml12">React Router Dom</h1>
          <ul className="mainNav">
            <li><NavLink exact to="/">Home</NavLink></li>
            <li><NavLink to="/topics">Topics</NavLink></li>
            <li><NavLink to="/contact">Contact</NavLink></li>
          </ul>

          {/* exact 없으면 Home 노출 / Switch같은효과 */}
          <Switch>
            <Route exact path="/"><Home /></Route>
            <Route path="/topics"><Topics /></Route>
            <Route path="/contact"><Contact /></Route>
            <Route path="/">Not Found</Route>
          </Switch>
        </div>
      </div>
    )
  }
}