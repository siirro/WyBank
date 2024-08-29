import React from 'react';
import {useParams} from "react-router-dom";

function Info(props) {

    const {account_id} = useParams();
    console.log(account_id)

    return (
        <div>info</div>
    );
}

export default Info;