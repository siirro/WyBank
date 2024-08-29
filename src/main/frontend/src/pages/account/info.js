import React from 'react';
import {createSearchParams, useNavigate, useParams, useSearchParams} from "react-router-dom";

function Info(props) {

    const navigate = useNavigate()
    const {account_id} = useParams();

    const [queryParams] = useSearchParams()
    const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
    const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10

    const queryStr = createSearchParams({page:page, size:size}).toString();

    const moveToUpdate = (account_id) => {
        navigate({
            pathname: `/account/update/${account_id}`,
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
        <div>
            info {account_id}번 계좌
            <div>
                <button onClick={() => moveToUpdate(account_id)}>계좌비번변경</button>
                <button onClick={moveToList}> 목록돌아가기</button>
            </div>
        </div>
    );
}

export default Info;