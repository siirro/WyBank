import React from 'react';
import {useParams} from "react-router-dom";
import InfoComponent from "../../components/account/InfoComponent";

function Info(props) {

    const {accountId} = useParams();

    return (
        <div className={"w-full bg-white mt-6"}>
            {/*<div>*/}
            {/*    <button onClick={() => moveToUpdate(accountId)}>계좌메모변경</button>*/}
            {/*    <button onClick={moveToList}> 목록돌아가기</button>*/}
            {/*</div>*/}

            <div className={"font-bold text-2xl"}>
                Account {accountId} Info
            </div>
            <InfoComponent accountId={accountId}/>
        </div>
    );
}

export default Info;