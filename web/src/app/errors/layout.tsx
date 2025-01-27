import Box from "@mui/material/Box";
import {Outlet} from "react-router";

export default function ErrorLayout() {
    return (
        <Box className={'h-full w-full flex flex-col justify-center items-center'}>
            <Outlet />
        </Box>
    )
}
