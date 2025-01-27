import Box from "@mui/material/Box";
import {Typography} from "@mui/material";
import {useParams} from "react-router";
import {useQuery} from "@tanstack/react-query";
import ProductApi from "../../../features/product/api/ProductApi.ts";

function useProductPage() {
    const { slug } = useParams();
    const { data, error, isLoading } = useProductBySlug(slug);

    return { product: data, error, isLoading };
}

function useProductBySlug(slug?: string) {
    return useQuery({
        queryKey: ['product', slug],
        queryFn: async () => {
            return await ProductApi.getProductBySlug(slug!);
        },
        enabled: !!slug
    })
}

export default function ProductPage() {
    const { product, error, isLoading } = useProductPage();

    if (error) {
        return (
            <Box>
                <Typography variant={'h5'}>Error</Typography>
            </Box>
        )
    }

    if (isLoading) {
        return (
            <Box>
                <Typography variant={'h5'}>Loading...</Typography>
            </Box>
        )
    }

    return (
        <Box>
            <Typography variant={'h5'}>{product?.name}</Typography>
        </Box>
    )
}
