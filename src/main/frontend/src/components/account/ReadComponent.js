import React, {useEffect, useState} from 'react';
import {getOne} from "../../api/accountApi";
const initState = {
    accountId:0,
    accountName:'',
    balance:0,
    createdAt:''
}
function ReadComponent({accountId}) {

    const [account, setAccount] = useState(initState)
    useEffect(() => {
        getOne(accountId).then(data => {
            console.log(data)
            setAccount(data)
        })
    }, [accountId]);
    return (
        <div>

        </div>
    );
}

export default ReadComponent;