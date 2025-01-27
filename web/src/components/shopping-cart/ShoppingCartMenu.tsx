import Box from "@mui/material/Box";
import {Menu, MenuItem} from "@mui/material";

interface ShoppingCartMenuProps {
    anchorEl: Element | null;
    onClose: () => void;
}

export default function ShoppingCartMenu({ anchorEl, onClose }: ShoppingCartMenuProps) {
    const isOpen = Boolean(anchorEl);

    return (
        <Box sx={{ display: 'flex', alignItems: 'center', textAlign: 'center' }}>
            <Menu
                transformOrigin={{ horizontal: 'right', vertical: 'top' }}
                anchorOrigin={{ horizontal: 'right', vertical: 'bottom' }}
                anchorEl={anchorEl}
                open={isOpen}
                onClose={onClose}
            >
                <MenuItem onClick={onClose}>
                </MenuItem>
            </Menu>
        </Box>
    );
}
