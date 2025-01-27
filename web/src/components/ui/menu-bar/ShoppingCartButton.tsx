import {ShoppingCartOutlined} from "@mui/icons-material";
import {IconButton} from "@mui/material";
import React from "react";
import ShoppingCartPopover from "../shopping-cart/ShoppingCartPopover.tsx";

export default function ShoppingCartButton() {
    const [anchorEl, setAnchorEl] = React.useState<Element | null>(null);

    function handleClick(event: React.MouseEvent<HTMLButtonElement>) {
        setAnchorEl(event.currentTarget);
    }

    function handleClose() {
        setAnchorEl(null);
    }

    return (
        <>
            <IconButton onClick={handleClick}>
                <ShoppingCartOutlined className={'text-white'} />
            </IconButton>
            <ShoppingCartPopover anchorEl={anchorEl} onClose={handleClose} />
        </>
    );
}
