import {lazy, Suspense} from "react";
import {createBrowserRouter} from "react-router-dom";
import accountRouter from "./accountRouter";

const Loading = <div>Loading....</div>
const Main = lazy(() => import("../pages/main"))
const About = lazy(() => import("../pages/about/about"))
const AccountIndex = lazy(() => import("../pages/account/IndexAccount"))

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
    }
])

export default root