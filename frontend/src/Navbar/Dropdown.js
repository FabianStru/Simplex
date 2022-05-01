import React, {useState} from "react";
import './Dropdown.css';
import {CSSTransition} from "react-transition-group";

function Dropdown () {

    const [activeMenu, setActiveMenu] = useState('main');
    const [menuHeight, setMenuHeight] = useState(null);

    function calculateHeight(el){
        const height = el.offsetHeight;
        setMenuHeight(height);
    }

    function DropdownItem(props){

        return(
            <a href={props.href} className='menu-item' onClick={()=> props.goToMenu && setActiveMenu(props.goToMenu)}>
                {props.children}
            </a>
        )
    }
    return (
        <div className='Dropdown' style={{height : menuHeight}}>
            <CSSTransition
                in={activeMenu==='main'}

                unmountOnExit
                className="menu-primary"
                onEnter={calculateHeight}
            >
                <div className='menu'>
                     <DropdownItem
                         leftIcon='Beta'
                         href='/'
                     >
                        Main
                     </DropdownItem>
                    <DropdownItem
                    leftIcon='A'
                    goToMenu='Play'
                >
                    Play
                </DropdownItem>
                </div>

            </CSSTransition>


            <CSSTransition
                in={activeMenu==='Play'}

                unmountOnExit
                className="menu-secondary"
                onEnter={calculateHeight}
            >

                <div className='menu'>

                    <DropdownItem
                        leftIcon='R'
                        href='/playRanked'
                    >
                        Ranked
                    </DropdownItem>
                    <DropdownItem
                        leftIcon='C'
                        href='/play'
                    >
                        Casual
                    </DropdownItem>
                    <DropdownItem
                    leftIcon='<-'
                    goToMenu='main'>
                    Go back
                </DropdownItem>
                </div>

            </CSSTransition>
        </div>

    )
}


export default Dropdown