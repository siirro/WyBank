import {lazy, Suspense} from "react";
import {Navigate} from "react-router-dom";

const Loading = <div>Loading....</div>
const AccountList = lazy(() => import("../pages/account/list"))
const AccountCreate = lazy(() => import("../pages/account/create"))
const AccountInfo = lazy(() => import("../pages/account/info"))


const accountRouter = () => {
    return [
        {
            path: '',
            element: <Navigate replace={true} to={'list'}/>
        },
        {
            path: 'list',
            element: <Suspense fallback={Loading}><AccountList/></Suspense>
        },{
            path: 'create',
            element: <Suspense fallback={Loading}><AccountCreate/></Suspense>
        },{
            path: 'info/:account_id',
            element: <Suspense fallback={Loading}><AccountInfo/></Suspense>
        }

    ]
}

export default accountRouter