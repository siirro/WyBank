import React from 'react';
import Header from "../components/menus/header";

function BasicLayout({children}) {
    return (
        <>
            <Header/>

            <div className={'bg-white my-5 w-full flex flex-col space-y-1 md:flex-row md:space-x-2 md:space-y-0'}>
                <aside className={"bg-teal-50 md:w-1/5 lg:w-1/5 px-5 h-[500px] flex"}>
                    <h1 className={"text-xl md:text-2xl"}>Sidebar</h1>
                </aside>
                <main className={"bg-teal-50 md:w-4/5 lg:w-4/5 px-5 h-[500px]"}>{children}</main>
            </div>
        </>
    );
}

export default BasicLayout;