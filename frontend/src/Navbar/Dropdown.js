import React, {useState, useEffect, useRef} from "react";
import './Dropdown.css';
import {CSSTransition} from "react-transition-group";
import {ReactComponent as Icon} from './Icons/Icon.svg';
import {ReactComponent as Pfeil} from './Icons/Pfeil.svg';


function Dropdown () {
    const [activeMenu, setActiveMenu] = useState('main');
    const [menuHeight, setMenuHeight] = useState(224);
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
                timeout={500}
                classNames="menu-primary"
                onEnter={calculateHeight}
            >
                <div className='menu'>
                     <DropdownItem
                         leftIcon={<Icon/>}
                         href='/'
                     >
                        Home
                     </DropdownItem>
                    <DropdownItem
                        leftIcon={<Icon/>}
                        href='/tutorial'
                    >
                        Tutorial
                    </DropdownItem>
                    <DropdownItem
                        leftIcon={<Icon/>}
                        href='/'
                    >
                        Rankings
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
                timeout={500}
                unmountOnExit
                classNames="menu-secondary"
                onEnter={calculateHeight}
            >

                <div className='menu'>

                    <DropdownItem
                        leftIcon='R'
                        href='/Ranked'
                    >
                        Ranked
                    </DropdownItem>
                    <DropdownItem
                        leftIcon='C'
                        href='/play'
                    >
                        Casual
                    </DropdownItem>

                </div>

            </CSSTransition>
        </div>

    )
}


export default Dropdown