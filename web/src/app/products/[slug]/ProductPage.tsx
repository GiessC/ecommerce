import Box from "@mui/material/Box";
import {Button, FormControl, FormLabel, MenuItem, Select, TextField, Typography} from "@mui/material";
import {useParams} from "react-router";
import {useQuery} from "@tanstack/react-query";
import ProductApi, {addToCartSchema} from "../../../features/product/api/ProductApi.ts";
import {useProduct} from "../../../features/product/hooks/useProduct.tsx";
import Form from "../../../components/ui/form/Form.tsx";
import {AddToCartRequest} from "../../../types/shopping-cart/AddToCartRequest.ts";
import {ShoppingCartOutlined} from "@mui/icons-material";

function useProductPage() {
    const { slug } = useParams();
    const { data, error, isLoading } = useProductBySlug(slug);
    const { addToCart } = useProduct(data);

    async function addProductToCart(formValues: AddToCartRequest) {
        const { slug } = formValues;
        if (!slug) {
            return;
        }
        await addToCart(formValues);
    }

    return { product: data, slug, error, isLoading, addProductToCart };
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
    const { product, slug, error, isLoading, addProductToCart } = useProductPage();

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
        <Box className={'m-8'}>
            <Form
                schema={addToCartSchema}
                onSubmit={addProductToCart}
                options={{
                    defaultValues: {
                        slug,
                        size: product?.sizes[0],
                    }
                }}
            >
                {({ register }) => (
                    <>
                        <Typography className={'pt-4'} variant={'h4'}>{product?.name}</Typography>
                        <img src={product?.imageURL} aria-label={product?.name} alt=""/>
                        <FormControl>
                            <TextField
                                {...register('slug')}
                                value={slug}
                                hidden
                            />
                        </FormControl>
                        {(product?.sizes.length ?? 0) > 0 && (
                            <FormControl>
                                <FormLabel htmlFor="size">Size: </FormLabel>
                                <Select {...register('size')} defaultValue={product?.sizes[0]}>
                                    {product?.sizes.map((size) => (
                                        <MenuItem key={size} value={size}>{size}</MenuItem>
                                    ))}
                                </Select>
                            </FormControl>
                        )}
                        <Typography variant={'body1'}>{product?.description}</Typography>
                        <Typography className={'pb-4'} variant={'body1'}>${product?.priceUSD}</Typography>
                        <Button variant={'outlined'} type={'submit'} disabled={!product || isLoading}>
                            <ShoppingCartOutlined /> Add to cart
                        </Button>
                    </>
                )}
            </Form>
        </Box>
    )
}
