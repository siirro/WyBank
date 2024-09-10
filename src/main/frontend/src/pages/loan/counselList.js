import React from 'react';
import {createSearchParams, useSearchParams} from "react-router-dom";
import LoanApplicationListComponent from "../../components/loan/LoanApplicationListComponent";

function counselList(props) {

   // const [queryParams] = useSearchParams()
   // const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1
   // const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 10

    return (
        <div className={"p-4 w-full bg-white"}>
            <LoanApplicationListComponent/>
        </div>
    );
}

export default counselList;