import {Box} from "@mui/material";
import {Outlet} from "react-router";
import MenuBar from "../components/menu-bar/MenuBar.tsx";

export default function AppLayout() {
    return (
        <Box className={'h-full w-full flex flex-col'}>
            <MenuBar />
            <Outlet />
        </Box>
    );
}
