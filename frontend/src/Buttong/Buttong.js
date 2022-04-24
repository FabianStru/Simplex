import React from "react";
import './Buttong.css';

const Button = ({ text, onClick, float }) => {
    return (
        <button
            onClick={onClick}
            className = 'button'
            style = {{float: float}}
            >
            {text}
        </button>
    )
}
Button.defaultProps = {
    color: 'black',
    text: 'BTN',
}

export default Button