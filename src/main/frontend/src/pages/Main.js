import React from 'react';
import {Link} from "react-router-dom";

function Main(props) {
    return (
        <div className={'text-3xl'}>
            <div className={'flex'}>
                <Link to={'/about'}>About</Link>
            </div>
            Main Page
        </div>
    );
}

export default Main;