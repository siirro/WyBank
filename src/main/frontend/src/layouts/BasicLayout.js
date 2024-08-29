import React from 'react';
import BasicMenu from "../components/menus/BasicMenu";

function BasicLayout({children}) {
    return (
        <>
            <header className={'bg-white'}>
                <BasicMenu/>
            </header>

            <div className={'bg-white my-5 w-full flex flex-col space-y-4 md:flex-row md:space-x-4 md:space-y-0'}>
                <aside className={"bg-teal-50 md:w-1/5 lg:w-1/5 px-5 py-40"}>
                    <h1>Sidebar</h1>
                </aside>
                <main className={"bg-teal-50 md:w-4/5 lg:w-4/5 px-5 py-40"}>{children}</main>

            </div>
        </>
    );
}

export default BasicLayout;