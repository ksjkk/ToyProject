import React,{Component} from 'react';
import Nav from './components/Nav';
import Article from './components/Article';
import NowLoading from './components/NowLoading';

export default class App extends Component{
  state = {
    article : {
      item : {title:'Welcome', desc:'Hello, React & Ajax'},
      isLoading : false
    },
    list : {
      items:[],
      isLoading:false
    }
  }
  componentDidMount(){
    var newList = Object.assign({},this.state.list,{isLoading:true});
    this.setState({list:newList});

    fetch('list.json')
    .then(function(result){
        return result.json();
    })
    .then(function(json){
        this.setState(
          {list:
            {items:json,isLoading:false}
          });
    }.bind(this))

    var myHeaders = new Headers();

    var param = {};
    //param.id = '218076';
    param.id = 'fxV2BVP2PX28VT42';
    param.password = 'dkdk184511';
    var convertParam = 'id='+param.id+'&password='+param.password;
    
    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: convertParam,
      redirect: 'follow'
    };
    
    fetch("http://localhost:8080/login/ssoLogin", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
  }

  render(){
    var nav = null;
    if(this.state.list.isLoading){
      nav = <NowLoading />;
    }
    else{
      nav = 
        <Nav list={this.state.list.items} onClick={function(id){
          var newArticle = Object.assign({},this.state.article,{isLoading:true});
          this.setState({article:newArticle});
          fetch(id+'.json')
          .then(function(result){
            return result.json();
          })
          .then(function(json){
            this.setState({
              article: {
                item : {
                  title:json.title,
                  desc:json.desc
                },
                isLoading:false
              }
            })
          }.bind(this))
        }.bind(this)} />
    }

    var article = null;
    if(this.state.article.isLoading){
      article = <NowLoading />
    }
    else{
      article = <Article title={this.state.article.item.title} desc={this.state.article.item.desc} />
    }
    return(
      <div className="App">
        <h1>햇규</h1>
        {nav}
        {article}
      </div>
    )
  }
}