import React, {useEffect, useState} from 'react';
import {getOne} from "../../api/accountApi";
import useCustomMove from "../../hooks/useCustomMove";
const initState = {
    accountId:0,
    accountNumber:'',
    accountName:'',
    accountMemo:'',
    accountState:'',
    balance:0,
    createdAt:''
}
function InfoComponent({accountId}) {

    const [account, setAccount] = useState(initState)
    const {moveToList, moveToUpdateMemo, moveToUpdatePw}  = useCustomMove()

    useEffect(() => {
        getOne(accountId).then(data => {
            console.log(data)
            setAccount(data)
        })
    }, [accountId]);
    return (
        <div className={"border-2 border-sky-100 mt-5 m-2 p-4"}>
            {makeDiv('계좌번호', account.accountNumber)}
            {makeDiv('계좌이름', account.accountName+" ("+account.accountMemo+")" )}
            {makeDiv('계좌상태', account.accountState)}
            {makeDiv('잔액', account.balance)}
            {makeDiv('계좌생성일', account.createdAt)}

            <div className={"flex justify-center p-4"}>
                <button type={"button"} className={"text-xs rounded p-2 m-2 w-24 text-white bg-blue-100"}
                        onClick={() => moveToUpdateMemo(account.accountId)}>
                    계좌별명변경
                </button>
                <button type={"button"} className={"text-xs rounded p-2 m-2 w-24 text-white bg-blue-100"}
                        onClick={() => moveToUpdatePw(account.accountId)}>
                    비밀번호변경
                </button>
            </div>

            거래내역 테이블

            <div className={"flex justify-center p-4"}>
                <button type={"button"} className={"rounded p-2 px-3 w-20 text-white bg-blue-300"}
                        onClick={() => moveToList()}>
                    목록
                </button>
            </div>


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

export default InfoComponent;