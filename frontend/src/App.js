import React from "react";
import './App.css';
import Navbar from "./Navbar/Navbar";
import Mainpage from "./Mainpage/Mainpage";
import Play from "./Mainpage/Play";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Ranked from './Mainpage/Ranked';



function App() {
    return (
        <div>
            <Navbar/>
            <div className='container'>
                <Router>
                    <Routes>
                        {/* Hier werden die verschiedenen Wege zu den Mainscreens definiert */}
                        <Route path="/" element={(<Mainpage/>)}/>
                        <Route path="/play" element={(<Play/>)}/>
                        <Route path='/ranked' element={(<Ranked/>)}/>

                        {/* das wird angezeigt wenn die Falsche URl eingegeben wird. No touchy, als ich das erstellt hab gings auf einmal sonst bugts  */}
                        <Route path="/*" element={(<h1>This is the wrong page</h1>)}/>
                    </Routes>
                </Router>
            </div>
        </div>
    )

}

export default App