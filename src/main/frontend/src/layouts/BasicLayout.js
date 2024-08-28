import React from 'react';

function BasicLayout({children}) {
    return (
        <>
            <header className={'bg-teal-200 p-5'}>
                <div className={''}>
                    <main>{children}</main>
                    <aside>
                        <h1>Sidebar</h1>
                    </aside>
                </div>
            </header>
        </>
    );
}

export default BasicLayout;