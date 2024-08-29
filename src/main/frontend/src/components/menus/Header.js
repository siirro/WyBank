import React from 'react';
import {Link} from "react-router-dom";

function Header(props) {
    return (
        <header className={'bg-white'}>
            <nav id="navbar">
                <div className={"flex px-[190px] h-12"}>
                    <div className={"w-4/5"}>
                        <ul className={"flex p-2 text-blue-200"}>
                            <li className={"pr-6 text-2xl"}>
                                <Link to={'/'}>WyBank로고</Link>
                            </li>
                        </ul>
                    </div>
                    <div className={"w-1/5 flex justify-end font-medium p-3"}>
                        <div className={"text-blue-400 text-sm m-1 rounded"}>
                            <Link to={'/login'}>로그인</Link>
                        </div>
                        <div className={"text-blue-400 text-sm m-1 rounded"}>
                            <Link to={'/signup'}>회원가입</Link>
                        </div>
                    </div>
                </div>
                <div className={"flex bg-blue-50 px-[200px]"}>
                    <ul className={"flex flex-grow items-center space-x-4 py-4 text-blue-300 font-bold"}>
                        <li className={"mr-3 text-2xl"}>
                            <Link to={'/account/'}>조회</Link>
                        </li>
                        <li className={"text-2xl"}>
                            <Link to={'/transaction'}>이체</Link>
                        </li>
                        <li className={"text-2xl"}>
                            <Link to={'/loan'}>대출</Link>
                        </li>
                        <li className={"text-2xl"}>
                            <Link to={'/notice'}>고객센터</Link>
                        </li>
                        <li className={"text-2xl"}>
                            <Link to={'/about'}>은행소개</Link>
                        </li>
                    </ul>
                    <div className={"flex items-center ml-auto"}>
                        <input className={"mr-3 h-8"}></input>
                        <span className={"mr-2"}>검색</span>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;