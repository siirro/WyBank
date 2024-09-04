import React, {useEffect, useState} from 'react';
import {getOne} from "../../api/accountApi";
const initState = {
    accountId:0,
    accountNumber:'',
    accountName:'',
    accountMemo:'',
    accountState:'',
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
        <div className={"border-2 border-sky-100 mt-5 m-2 p-4"}>
            {makeDiv('accountNumber', account.accountNumber)}
            {makeDiv('accountName', account.accountName)}
            {makeDiv('accountMemo', account.accountMemo)}
            {makeDiv('accountState', account.accountState)}
            {makeDiv('balance', account.balance)}
            {makeDiv('createdAt', account.createdAt)}

        </div>
    );
}

const makeDiv = (title, value) =>
    <div className={"flex justify-center"}>
        <div className={"relative mb-4 flex w-full flex-wrap items-stretch"}>
            <div className={"w-2/6 p-2"}>{title}</div>
            <div className={"w-4/6 p-2 rounded-r border border-solid shadow-md"}>{value}</div>
        </div>
    </div>

export default ReadComponent;