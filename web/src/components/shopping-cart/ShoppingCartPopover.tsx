import Box from "@mui/material/Box";
import {Popover} from "@mui/material";

interface ShoppingCartPopoverProps {
    anchorEl: Element | null;
    onClose: () => void;
}

export default function ShoppingCartPopover({ anchorEl, onClose }: ShoppingCartPopoverProps) {
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
