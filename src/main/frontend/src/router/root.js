import {lazy, Suspense} from "react";
import {createBrowserRouter} from "react-router-dom";
import accountRouter from "./accountRouter";
import loanRouter from "./loan/loanRouter";
// 코드 스플리팅
const Loading = <div>Loading....</div>
// 필요한 경우에만 랜더링 lazy
const Main = lazy(() => import("../pages/main"))
const About = lazy(() => import("../pages/about/about"))
const AccountIndex = lazy(() => import("../pages/account/indexAccount"))
const LoanIndex = lazy(() => import("../pages/loan/indexLoan"))


const root = createBrowserRouter([
    {
        path: '',
        element: <Suspense fallback={Loading}><Main/></Suspense> // 어떤 컴포넌트를 보여줄지
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