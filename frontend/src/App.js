import React from "react";
import './App.css';
import Navbar from "./Navbar/Navbar";
import Home from "./Mainpage/Home";
import Casual from "./Mainpage/Casual";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Ranked from './Mainpage/Ranked';
import Rankings from './Mainpage/Rankings';



function App() {
    return (
        <div>
            <Navbar/>
            <div className='container'>
                <Router>
                    <Routes>
                        {/* Hier werden die verschiedenen Wege zu den Mainscreens definiert */}
                        <Route path="/" element={(<Home/>)}/>
                        <Route path="/play" element={(<Casual/>)}/>
                        <Route path='/ranked' element={(<Ranked/>)}/>
                        <Route path='/rankings' element={(<Rankings/>)}/>
                        <Route path='/tutorial' element={(<Tutorial/>)}/>

                        {/* das wird angezeigt wenn die Falsche URl eingegeben wird. No touchy, als ich das erstellt hab gings auf einmal sonst bugts  */}
                        <Route path="/*" element={(<h1>This is the wrong page</h1>)}/>
                    </Routes>
                </Router>
            </div>
        </div>
    )

}

export default App