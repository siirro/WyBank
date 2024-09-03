import React, {useCallback} from 'react';
import BasicLayout from "../../layouts/BasicLayout";
import {Link, Outlet, useNavigate} from "react-router-dom";

function IndexLoan(props) {

    const navigate = useNavigate();
    const handleClickList = useCallback(() => {
        navigate({pathname: 'list'})
    }, [])
    const handleClickCreate = useCallback(() => {
        navigate({pathname: 'create'})
    }, [])

    return (
        <BasicLayout>
            <div className={"w-full flex m-2 p-2"}>
                <div className={"m-1 p-2 w-30 font-bold text-center"} onClick={handleClickList}>대출내역조회</div>
                <div className={"m-1 p-2 w-30 font-bold text-center"} onClick={handleClickCreate}>대출상담신청</div>
                <div className={"m-1 p-2 w-30 font-bold text-center"}><Link to={'info/1'}>1번계좌</Link></div>
            </div>
            <div className={"flex flex-wrap w-full"}>
                <Outlet/>
            </div>
        </BasicLayout>
    );
}

export default IndexLoan;