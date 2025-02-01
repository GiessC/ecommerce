import {Navigate} from "react-router";

type RootProps = {
    path: string
}

export default function Root({ path }: RootProps) {
    return (
        <Navigate to={path} />
    );
}
