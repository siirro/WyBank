import React from 'react';
import {useNavigate, useParams} from "react-router-dom";

function Info(props) {

    const navigate = useNavigate()
    const {account_id} = useParams();

    const moveToModify = (account_id) => {
        navigate({pathname: `/account/modify/${account_id}`})
    }

    return (
        <div>
            info {account_id}번 계좌
            <div>
                <button onClick={() => moveToModify(account_id)}>Test Modify</button>
            </div>
        </div>
    );
}

export default Info;