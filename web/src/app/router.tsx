import {createBrowserRouter, Outlet, RouterProvider as ReactRouterProvider} from "react-router";
import NotFound from "./errors/NotFound.tsx";
import Home from "./index.tsx";
import Root from "./root.tsx";

const router = createBrowserRouter([
    {
        path: '*',
        element: <NotFound />
    },
    {
        path: '/',
        element: <Outlet />,
        children: [
            {
                index: true,
                element: <Root />,
            },
            {
                path: '/app',
                element: <Home />
            }
        ]
    }
]);

export default function RouterProvider() {
    return <ReactRouterProvider router={router} />
};
