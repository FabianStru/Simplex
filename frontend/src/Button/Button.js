import React from "react";
import './Button.css';

const Button = ({ text, onClick,}) => {
    return (
        <button
            onClick={onClick}
            className = 'button'
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