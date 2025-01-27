import RouterProvider from "./router.tsx";
import {ThemeProvider} from "@mui/material";
import {theme} from "./theme.tsx";
import QueryProvider from "../config/QueryProvider.tsx";

export default function Providers() {
    return (
        <ThemeProvider theme={theme}>
            <QueryProvider>
                <RouterProvider />
            </QueryProvider>
        </ThemeProvider>
    );
}
