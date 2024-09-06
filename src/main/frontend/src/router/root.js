import {lazy, Suspense} from "react";
import {createBrowserRouter} from "react-router-dom";
import accountRouter from "./accountRouter";
import loanRouter from "./loan/loanRouter";

const Loading = <div>Loading....</div>
const Main = lazy(() => import("../pages/main"))
const About = lazy(() => import("../pages/about/about"))
const AccountIndex = lazy(() => import("../pages/account/indexAccount"))
const LoanIndex = lazy(() => import("../pages/loan/IndexLoan"))


const root = createBrowserRouter([
    {
        path: '',
        element: <Suspense fallback={Loading}><Main/></Suspense>
    },
    {
        path: 'about',
        element: <Suspense fallback={Loading}><About/></Suspense>
    },
    {
        path: 'account',
        element: <Suspense fallback={Loading}><AccountIndex/></Suspense>,
        children: accountRouter()
    },
    {
        path: 'loan',
        element: <Suspense fallback={Loading}><LoanIndex/></Suspense>,
        children: loanRouter()
    }
])

export default root