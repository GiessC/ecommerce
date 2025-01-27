import Box from "@mui/material/Box";
import {AppBar, IconButton, Toolbar} from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';

export default function MenuBar() {
    return (
        <Box className={'flex-grow'}>
            <AppBar position={'static'}>
                <Toolbar>
                    <IconButton size={'large'} aria-label={'Menu'}>
                        <MenuIcon />
                    </IconButton>
                </Toolbar>
            </AppBar>
        </Box>
    );
}
