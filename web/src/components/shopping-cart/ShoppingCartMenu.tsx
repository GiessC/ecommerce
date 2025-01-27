import Box from "@mui/material/Box";
import {Popover} from "@mui/material";

interface ShoppingCartMenuProps {
    anchorEl: Element | null;
    onClose: () => void;
}

export default function ShoppingCartMenu({ anchorEl, onClose }: ShoppingCartMenuProps) {
    const isOpen = Boolean(anchorEl);

    return (
        <Box sx={{ display: 'flex', alignItems: 'center', textAlign: 'center' }}>
            <Popover
                transformOrigin={{ horizontal: 'right', vertical: 'top' }}
                anchorOrigin={{ horizontal: 'right', vertical: 'bottom' }}
                anchorEl={anchorEl}
                open={isOpen}
                onClose={onClose}
            >
            </Popover>
        </Box>
    );
}
