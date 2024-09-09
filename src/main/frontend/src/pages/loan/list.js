import React from 'react';
import {createSearchParams, useSearchParams} from "react-router-dom";
import ListComponent from "../../components/loan/ListComponent";

function List(props) {

    const [queryParams] = useSearchParams()
    const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
    const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10

    return (
        <div className={"p-4 w-full bg-white"}>
            <div className={""}>
                Account List Page  --- {page} --- {size}
            </div>
            <ListComponent/>
        </div>
    );
}

export default List;