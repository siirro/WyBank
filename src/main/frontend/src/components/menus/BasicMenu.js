import React from 'react';
import {Link} from "react-router-dom";

function BasicMenu(props) {
    return (
        <nav id="navbar">
            <div className={"flex px-[180px] h-12"}>
                <div className={"w-4/5"}>
                    <ul className={"flex p-2 text-blue-200"}>
                        <li className={"pr-6 text-2xl"}>
                            <Link to={'/'}>WyBank로고</Link>
                        </li>
                    </ul>
                </div>
                <div className={"w-1/5 flex justify-end font-medium p-3"}>
                    <div className={"text-blue-400 text-sm m-1 rounded"}>
                        로그인
                    </div>
                    <div className={"text-blue-400 text-sm m-1 rounded"}>
                        회원가입
                    </div>
                </div>
            </div>
            <div className={"flex bg-blue-50 px-[200px]"}>
                <div className={""}>
                    <ul className={"flex p-4 text-blue-300 font-bold"}>
                        <li className={"pr-20 text-2xl"}>
                            <Link to={'/about'}>조회</Link>
                        </li>
                        <li className={"pr-20 text-2xl"}>
                            <Link to={'/about'}>이체</Link>
                        </li>
                        <li className={"pr-20 text-2xl"}>
                            <Link to={'/about'}>대출</Link>
                        </li>
                        <li className={"pr-20 text-2xl"}>
                            <Link to={'/about'}>고객센터</Link>
                        </li>
                        <li className={"pr-20 text-2xl "}>
                            <Link to={'/about'}>은행소개</Link>
                        </li>
                        <li>
                            <input></input>
                            <span>검색</span>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>

    );
}

export default BasicMenu;