import Box from "@mui/material/Box";
import {AppBar, IconButton, Toolbar} from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';
import Menu from "./Menu.tsx";
import {useOpenable} from "../../hooks/useOpenable.tsx";
import Search from "./Search.tsx";
import ShoppingCartButton from "./ShoppingCartButton.tsx";

export default function MenuBar() {
    const { isOpen: isMenuOpen, setIsOpen: setIsMenuOpen, toggleOpen: toggleMenuOpen } = useOpenable();

    return (
        <Box>
            <AppBar position={'static'}>
                <Toolbar>
                    <Menu isOpen={isMenuOpen} setIsOpen={setIsMenuOpen} />
                    <IconButton size={'large'} aria-label={'Menu'} onClick={toggleMenuOpen}>
                        <MenuIcon />
                    </IconButton>
                    <Search />
                    <ShoppingCartButton />
                </Toolbar>
            </AppBar>
        </Box>
    );
}
