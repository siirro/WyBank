import {lazy, Suspense} from "react";
import {Navigate} from "react-router-dom";

const Loading = <div>Loading....</div>
const AccountList = lazy(() => import("../pages/account/list"))
const AccountCreateForm = lazy(() => import("../pages/account/createForm"))
const AccountInfo = lazy(() => import("../pages/account/info"))
const AccountUpdateMemo = lazy(() => import("../pages/account/updateMemo"))
const AccountUpdatePw = lazy(() => import("../pages/account/updatePw"))
const AccountProduct = lazy(() => import("../pages/account/product"))
const AccountProductInfo = lazy(() => import("../pages/account/productInfo"))


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
            path: 'create/form',
            element: <Suspense fallback={Loading}><AccountCreateForm/></Suspense>
        },{
            path: 'info/:accountId',
            element: <Suspense fallback={Loading}><AccountInfo/></Suspense>
        },{
            path: 'update/memo',
            element: <Suspense fallback={Loading}><AccountUpdateMemo/></Suspense>
        },{
            path: 'update/pw',
            element: <Suspense fallback={Loading}><AccountUpdatePw/></Suspense>
        },{
            path: 'product',
            element: <Suspense fallback={Loading}><AccountProduct/></Suspense>
        },{
            path: 'product/:accountProductId',
            element: <Suspense fallback={Loading}><AccountProductInfo/></Suspense>
        }

    ]
}

export default accountRouter