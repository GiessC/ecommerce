import {Drawer} from "@mui/material";

type MenuProps = { isOpen: boolean, setIsOpen: (isOpen: boolean) => void; };

export default function Menu({ isOpen, setIsOpen }: MenuProps) {
    return (
        <Drawer open={isOpen} onClose={() => setIsOpen(false)}>
            Stuff
        </Drawer>
    );
}
