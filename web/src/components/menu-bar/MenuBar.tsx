import Box from "@mui/material/Box";
import {AppBar, Toolbar} from "@mui/material";

export default function MenuBar() {
    return (
        <Box className={'flex-grow'}>
            <AppBar position={'static'}>
                <Toolbar>
                </Toolbar>
            </AppBar>
        </Box>
    );
}
