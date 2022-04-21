import React from "react";
import './Buttong.css';

const Button = ({ color, text, onClick, float }) => {
    return (
        <button
            onClick={onClick}
            style = {{ backgroundColor: color }}
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