import {lazy, Suspense} from "react";
import {createBrowserRouter} from "react-router-dom";

const Loading = <div>Loading....</div>
const Main = lazy(() => import("../pages/Main"))
const About = lazy(() => import("../pages/About"))

const root = createBrowserRouter([
    {
        path: '',
        element: <Suspense fallback={Loading}><Main/></Suspense>
    },
    {
        path: 'about',
        element: <Suspense fallback={Loading}><About/></Suspense>
    }
])

export default root