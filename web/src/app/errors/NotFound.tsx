import {Link, Typography} from "@mui/material";

export default function NotFound() {
    return (
        <>
            <Typography variant='h4'>Page Not Found</Typography>
            <Typography variant='body1'>The page you are looking for does not exist.</Typography>
            <Link href={'/'}>Return home</Link>
        </>
    );
}
