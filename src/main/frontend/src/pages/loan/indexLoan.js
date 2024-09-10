import React, {useCallback} from 'react';
import BasicLayout from "../../layouts/basicLayout";
import {Link, Outlet, useNavigate} from "react-router-dom";

function IndexLoan(props) {

    const navigate = useNavigate();
    const handleClickLoanList = useCallback(() => {
        navigate({pathname: 'loanList'})
    }, [])
    const handleClickCounselList = useCallback(() => {
        navigate({pathname: 'counselList'})
    }, [])
    const handleClickCreate = useCallback(() => {
        navigate({pathname: 'create'})
    }, [])

    return (
        <BasicLayout>

            <div> WyBank의 인기상품을 확인해보세요.</div>

            <div className={"w-full flex m-2 p-2"}>
                <div className={"m-1 p-2 w-30 font-bold text-center"} onClick={handleClickLoanList}>대출상품</div>
                <div className={"m-1 p-2 w-30 font-bold text-center"} onClick={handleClickCounselList}>대출신청 조회</div>
                <div className={"m-1 p-2 w-30 font-bold text-center"} onClick={handleClickCreate}>대출상담 조회</div>
            </div>
            <div className={"flex flex-wrap w-full"}>
                <Outlet/>
            </div>
        </BasicLayout>
    );
}

export default IndexLoan;