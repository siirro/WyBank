import React from 'react';
import {Link} from "react-router-dom";

function About(props) {
    return (
        <div className={'text-3xl'}>
            <div className={'flex'}>
                <Link to={'/about'}>About</Link>
            </div>
            About Page
        </div>
    );
}

export default About;