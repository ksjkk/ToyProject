import React,{useState, useEffect} from 'react';
import {Line,Bar,Pie,Bubble,Polar,Radar,Doughnut,HorizontalBar,Scatter} from 'react-chartjs-2';

const Chart = () => {
    const [chartData,setChartData] = useState({});
    const [bubbleData,setBubbleData] = useState({});
    const chart = () => {
        setChartData({
            labels : ['mon','tue','wed','thu','fri','sat','sun'],
            datasets : [
                {
                    label : 'level of thicness',
                    data : [32,45,12,76,69,29,99],
                    backgroundColor : [
                        'rgba(255,255,255,0.6)',
                        'rgba(255,0,0,0.6)',
                        'rgba(0,255,0,0.6)',
                        'rgba(0,0,255,0.6)',
                        'rgba(255,255,0,0.6)',
                        'rgba(255,0,255,0.6)',
                        'rgba(0,255,255,0.6)'
                    ],
                    borderWidth:1,
                    borderColor:'black'
                }
            ]
        });
        setBubbleData({
            labels : ['mon','tue','wed','thu','fri','sat','sun'],
            type : 'bubble',
            datasets : [
                {
                    label : 'level of thicness',
                    data : [
                        {x:12,y:10,r:12},
                        {x:15,y:3,r:15},
                        {x:7,y:15,r:18},
                        {x:23,y:5,r:8},
                        {x:21,y:8,r:13},
                        {x:10,y:15,r:10},
                        {x:18,y:10,r:26}
                    ],
                    backgroundColor : [
                        'rgba(255,255,255,0.6)',
                        'rgba(255,0,0,0.6)',
                        'rgba(0,255,0,0.6)',
                        'rgba(0,0,255,0.6)',
                        'rgba(255,255,0,0.6)',
                        'rgba(255,0,255,0.6)',
                        'rgba(0,255,255,0.6)'
                    ],
                    borderWidth:1,
                    borderColor:'black'
                }
            ]
        })
    }
    useEffect(() => {
        chart()
    },[]);
    return(
        <div className="App" style={{width:"30%"}}>
            <Line
                data = {chartData}
                options = {{
                    responsive:true,
                    
                    title : {text: 'LINE',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Bar
                data = {chartData}
                options = {{
                    responsive:true,
                    
                    title : {text: 'BAR',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Pie
                data = {chartData}
                options = {{
                    responsive:true,
                    title : {text: 'PIE',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Bubble
                data = {bubbleData}
                options = {{
                    legend:{
                        display:true
                    },
                    responsive:true,
                    title : {text: 'BUBBLE',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Polar
                data = {chartData}
                options = {{
                    responsive:true,
                    title : {text: 'POLAR',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Radar
                data = {chartData}
                options = {{
                    responsive:true,
                    title : {text: 'RADAR',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Doughnut
                data = {chartData}
                options = {{
                    responsive:true,
                    title : {text: 'DOUGHNUT',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <HorizontalBar
                data = {chartData}
                options = {{
                    responsive:true,
                    title : {text: 'HORIZONTAL BAR',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
            <Scatter
                data = {bubbleData}
                options = {{
                    responsive:true,
                    title : {text: 'SCATTER',display:true},
                    scales : {
                        yAxes : [{
                            ticks:{
                                autoSkip:true,
                                maxTicksLimit:10,
                                beginAtZero:true
                            },
                            gridLines:{
                                display:false
                            }
                        }],
                        xAxes:[{
                            type:'linear',
                            gridLines:{
                                display:false
                            }
                        }]
                    }
                }}
            />
        </div>
    )
}
export default Chart;