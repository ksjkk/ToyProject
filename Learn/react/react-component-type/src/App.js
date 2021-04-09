import React,{useState, useEffect} from 'react';
import './App.css';

export default function App() {
  var [funcShowFlag, setFuncShowFlag] = useState(true);
  var [classShowFlag, setClassShowFlag] = useState(true);
  return (
    <div className="container">
      <input id="btn_Func" type="button" value="Func" onClick={function(){
        setFuncShowFlag(!funcShowFlag);
      }}/>
      <input id="btn_Class" type="button" value="Class" onClick={function(){
        setClassShowFlag(!classShowFlag);
      }}/>
      {funcShowFlag ? <FuncComp initNumber={2}></FuncComp> : null}
      {classShowFlag ? <ClassComp initNumber={2}></ClassComp> : null}
    </div>
  );
}

var funcStyle = 'color:blue';
var funcId = 0;
function FuncComp(_props){
  var numberState = useState(_props.initNumber); // 배열로 return, param : state 초기값
  var number = numberState[0];    // state 상태값
  var setNumber = numberState[1]; // 상태바꾸는 함수

  /*
  var dateState = useState((new Date()).toString());
  var _date = dateState[0];
  var setDate = dateState[1];
  */
  var [_date,setDate] = useState((new Date()).toString());

  // side effect
  useEffect(function(){
    console.log('%cfunc => useEffect (componentDidMount) X '+(++funcId),funcStyle);
    return function(){
      console.log('%cfunc => useEffect (componentWillUnmount) return '+(++funcId),funcStyle);
    }
  },[]);  // 1회성
  
  useEffect(function(){
    console.log('%cfunc => useEffect (componentDidMount & componentDidUpdate) Y '+(++funcId),funcStyle);
    return function(){
      console.log('%cfunc => useEffect (componentDidMount & componentDidUpdate) return '+(++funcId),funcStyle);
    }
  });

  useEffect(function(){
    console.log('%cfunc => useEffect date (componentDidMount & componentDidUpdate) B '+(++funcId),funcStyle);
    return function(){
      console.log('%cfunc => useEffect date return '+(++funcId),funcStyle);
    }
  },[_date]);

  useEffect(function(){
    console.log('%cfunc => useEffect number (componentDidMount & componentDidUpdate) C '+(++funcId),funcStyle);
    return function(){
      console.log('%cfunc => useEffect number return '+(++funcId),funcStyle);
    }
  },[number]);  // [] 배열안의 인자가 바뀌었을때만 return callBack Function 호출
  
  console.log('%cfunc => rendor '+(++funcId),funcStyle);
  return(
    <div className="container">
      <h2>function style component</h2>
      <p>Number : {number}</p>
      <p>Date : {_date}</p>
      <input type="button" value="random" onClick={function(){
        setNumber(Math.random());
      }}/>
      <input type="button" value="date" onClick={function(){
        setDate((new Date()).toString());
      }}/>
    </div>
  )
}

var classStyle = 'color:red';
class ClassComp extends React.Component{
  state = {
    number : this.props.initNumber,
    date : (new Date()).toString()
  }
  componentWillMount(){
    console.log('%cclass => componentWillMount',classStyle)
  }
  componentDidMount(){
    console.log('%cclass => componentDidMount',classStyle)
  }
  shouldComponentUpdate(nextProps,nextState){
    console.log('%cclass => shouldComponentUpdate',classStyle);
    return true;  // true면 render 실행
  }
  componentWillUpdate(nextProps,nextState){
    console.log('%cclass => componentWillUpdate',classStyle);
  }
  componentDidUpdate(nextProps,nextState){
    console.log('%cclass => componentDidUpdate',classStyle);
  }
  componentWillUnmount(){
    console.log('%cclass => componentWillUnmount',classStyle)
  }
  render(){
    console.log('%cclass => render',classStyle)
    return(
      <div className="container">
        <h2>class style component</h2>
        <p>Number : {this.state.number}</p>
        <p>Date : {this.state.date}</p>
        <input type="button" value="random" onClick={function(){
          this.setState({number:Math.random()})
        }.bind(this)}/>
        <input type="button" value="date" onClick={function(){
          this.setState({date:(new Date()).toString()})
        }.bind(this)}/>
      </div>
    )
  }
}