import React from 'react';
import BasicLayout from "../../layouts/BasicLayout";
import {Link, Outlet} from "react-router-dom";

function IndexAccount(props) {
    return (
        <BasicLayout>
            <div className={"w-full flex m-2 p-2"}>
                <div className={"m-1 p-2 w-30 font-bold text-center"}><Link to={'list'}>계좌 조회</Link></div>
                <div className={"m-1 p-2 w-30 font-bold text-center"}><Link to={'create'}>계좌 생성</Link></div>
                <div className={"m-1 p-2 w-30 font-bold text-center"}><Link to={'info/1'}>1번 계좌</Link></div>
            </div>
            <div className={"flex flex-wrap w-full"}>
                <Outlet/>
            </div>
        </BasicLayout>
    );
}

export default IndexAccount;