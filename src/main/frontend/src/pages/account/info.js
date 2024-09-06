import React from 'react';
import {createSearchParams, useNavigate, useParams, useSearchParams} from "react-router-dom";
import InfoComponent from "../../components/account/infoComponent";

function Info(props) {

    const navigate = useNavigate()
    const {accountId} = useParams();

    const [queryParams] = useSearchParams()
    const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
    const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10

    const queryStr = createSearchParams({page:page, size:size}).toString();

    const moveToUpdate = (accountId) => {
        navigate({
            pathname: `/account/update/memo/${accountId}`,
            search: queryStr
        })
    }

    const moveToList = () => {
        navigate({
            pathname: `/account/list`,
            search: queryStr
        })
    }


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