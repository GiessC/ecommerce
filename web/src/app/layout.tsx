import {Box} from "@mui/material";
import {Outlet} from "react-router";

export default function AppLayout() {
    return (
        <Box className={'h-full w-full flex flex-col'}>
            <Outlet />
        </Box>
    );
}
