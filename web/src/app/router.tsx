import {createBrowserRouter, Outlet, RouterProvider as ReactRouterProvider} from "react-router";
import NotFound from "./errors/NotFound.tsx";
import Home from "./index.tsx";
import Root from "./root.tsx";
import ErrorLayout from "./errors/layout.tsx";
import AppLayout from "./layout.tsx";
import ProductPage from "./products/[slug]/ProductPage.tsx";

const router = createBrowserRouter([
    {
        path: '*',
        element: <NotFound />
    },
    {
        path: '/',
        element: <AppLayout />,
        children: [
            {
                index: true,
                element: <Root path={'/app'} />,
            },
            {
                path: '/app',
                element: <Outlet />,
                children: [
                    {
                        index: true,
                        element: <Home />,
                    },
                    {
                        path: '/app/products/:slug',
                        element: <ProductPage />
                    }
                ]
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
