import React, {useState, useEffect, useRef} from "react";
import './Dropdown.css';
import {CSSTransition} from "react-transition-group";
import {ReactComponent as Icon} from './Icon.svg';
import {ReactComponent as Pfeil} from './Pfeil.svg';


function Dropdown () {
    const [activeMenu, setActiveMenu] = useState('main');
    const [menuHeight, setMenuHeight] = useState(112);
    const dropdownRef= useRef(null);
/*
    useEffect(()=> {
        let a =dropdownRef.current?.firstChild.offsetHeight
        setMenuHeight(a)
    }, [])

 */
    function calculateHeight(el){
        const height = el.offsetHeight;
        setMenuHeight(height);
    }

    function DropdownItem(props){

        return(
            <a href={props.href} className='menu-item' onClick={()=> props.goToMenu && setActiveMenu(props.goToMenu)}>
                <span className="icon-button">{props.leftIcon}</span>
                {props.children}
                <span className="icon-button">{props.rightIcon}</span>
            </a>
        )
    }
    return (
        <div className='Dropdown' style={{height : menuHeight}} ref={dropdownRef}>
            <CSSTransition
                in={activeMenu==='main'}
                unmountOnExit
                timeout={400}
                classNames="menu-primary"
                onEnter={calculateHeight}
            >
                <div className='menu'>
                     <DropdownItem
                         leftIcon={<Icon/>}
                         href='/'
                     >
                        Main
                     </DropdownItem>
                    <DropdownItem

                    goToMenu='Play'
                    rightIcon={<Pfeil/>}
                >
                    Play
                </DropdownItem>
                </div>

            </CSSTransition>


            <CSSTransition
                in={activeMenu==='Play'}
                timeout={400}
                unmountOnExit
                classNames="menu-secondary"
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