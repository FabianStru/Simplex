import React, {useState, useEffect, useRef} from "react";
import './Dropdown.css';
import {CSSTransition} from "react-transition-group";
//import DropdownItem from "./Dropdown";


function Dropdowngenerix (props) {
    const [activeMenu, setActiveMenu] = useState('main');
    const [menuHeight, setMenuHeight] = useState();
    const dropdownRef= useRef(null);
    const [dDL,setDDL] = useState([])



    function DropdownItem(props){

        return(
            <a href={props.href} className='menu-item' onClick={props.onClick}>
                <span className="icon-button">{props.leftIcon}</span>
                {props.children}
                <span className="icon-button">{props.rightIcon}</span>
            </a>
        )
    }

    function BuildDropdown () {
        setDDL(props.Dropdownlist)
        let length = dDL.length;
        let Hannes= [];
        for(let i=0;i<length;i++) {
            Hannes[i]=<DropdownItem
                onClick={()=>onKack(i)}
                //href={'/'+dDL[i]}
                >
                {dDL[i]}
            </DropdownItem>
        }
        return Hannes;
    }
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
    function onKack(i){
        console.log("i : "+ i)
            console.log("dDL[i] : "+dDL[i])
            props.A(dDL[i])
            props.dropdownBoolean(false)
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
                    <BuildDropdown/>
                </div>
            </CSSTransition>
        </div>

    )
}


export default Dropdowngenerix