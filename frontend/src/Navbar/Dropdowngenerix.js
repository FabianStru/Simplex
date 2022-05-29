import React, {useState, useEffect, useRef} from "react";
import './Dropdown.css';
import {CSSTransition} from "react-transition-group";
import {ReactComponent as Icon} from './Icons/Icon.svg';
import {ReactComponent as Pfeil} from './Icons/Pfeil.svg';


function Dropdowngenerix (props) {
    const [activeMenu, setActiveMenu] = useState('main');
    const [menuHeight, setMenuHeight] = useState();
    const dropdownRef= useRef(null);
    const [dDL,setDDL] = useState([])
    console.log('List'+props.Dropdownlist)

    /*
    function onClick(){
        if(props.Dropdownlist){
            props.A=this.props.href
        }
        else{
            if(this.props.goToMenu) {
                setActiveMenu(this.props.goToMenu)
            }
        }
    }

     */
    function BuildDropdown () {
        setDDL(props.Dropdownlist)
        console.log('DDL'+dDL.length)
        let length = dDL.length;
        let Hannes= [];
        for(let i=0;i<length;i++) {
            Hannes[i]=<DropdownItem
                href={'/'+dDL[i]}>
                {dDL[i]}
            </DropdownItem>
        }
        console.log('HALLO  : ' + Hannes)
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

    function DropdownItem(props){

        return(
            <a href={props.href} className='menu-item' /*onClick={onClick} */>
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
                    <BuildDropdown/>
                </div>
            </CSSTransition>
        </div>

    )
}


export default Dropdowngenerix