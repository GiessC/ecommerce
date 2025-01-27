import {createBrowserRouter, Outlet, RouterProvider as ReactRouterProvider} from "react-router";
import NotFound from "./errors/NotFound.tsx";
import Home from "./index.tsx";
import Root from "./root.tsx";
import ErrorLayout from "./errors/layout.tsx";

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
                element: <Root path={'/app'} />,
            },
            {
                path: '/app',
                element: <Home />
            },
            {
                path: '/errors',
                element: <ErrorLayout />,
                children: [
                    {
                        index: true,
                        element: <Root path={'/errors/not-found'} />
                    },
                    {
                        path: '/errors/not-found',
                        element: <NotFound />
                    }
                ]
            }
        ]
    }
]);

export default function RouterProvider() {
    return <ReactRouterProvider router={router} />
};
