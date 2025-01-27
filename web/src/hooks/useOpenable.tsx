import {useState} from "react";

export function useOpenable() {
    const [isOpen, setIsOpen] = useState<boolean>(false);

    function toggleOpen() {
        setIsOpen((prev) => !prev);
    }

    return {
        isOpen, setIsOpen, toggleOpen
    };
}
