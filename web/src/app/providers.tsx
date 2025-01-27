import RouterProvider from "./router.tsx";
import {ThemeProvider} from "@mui/material";
import {theme} from "./theme.tsx";

export default function Providers() {
    return <ThemeProvider theme={theme}><RouterProvider /></ThemeProvider>;
}
