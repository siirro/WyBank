import {lazy, Suspense} from "react";
import {Navigate} from "react-router-dom";

const Loading = <div>Loading....</div>
const LoanList = lazy(() => import("../../pages/loan/list"))
const LoanCreate = lazy(() => import("../../pages/loan/create"))
// const LoanInfo = lazy(() => import("../pages/loan/info"))
// const LoanUpdate = lazy(() => import("../pages/loan/update"))


const loanRouter = () => {
    return [
        {
            path: '',
            element: <Navigate replace={true} to={'list'}/>
        },
        {
            path: 'list',
            element: <Suspense fallback={Loading}><LoanList/></Suspense>
        },
        {
            path: 'create',
            element: <Suspense fallback={Loading}><LoanCreate/></Suspense>
        }
    ]
}

export default loanRouter