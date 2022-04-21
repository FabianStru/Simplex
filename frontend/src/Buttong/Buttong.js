import React from "react";
const Button = ({ color, text, onClick }) => {
    return (
        <button
            onClick={onClick}
            style = {{ backgroundColor: color }}
            className = 'button'
            >
            {text}
        </button>
    )
}
Button.defaultProps = {
    color: 'green',
    text: 'BTN',
}

export default Button