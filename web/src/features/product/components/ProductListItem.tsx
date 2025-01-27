import Product from "../../../types/product/Product.ts";
import {Button, Card, CardActionArea, CardActions, CardContent, CardMedia, Typography} from "@mui/material";
import {useProduct} from "../hooks/useProduct.tsx";
import {ShoppingCartOutlined} from "@mui/icons-material";
import React from "react";

interface ProductListItemProps {
    className?: string;
    product: Product;
}

export default function ProductListItem({product, className=''}: ProductListItemProps) {
    const { goTo, addToCart } = useProduct(product);

    function onAddToCart(event: React.MouseEvent<HTMLButtonElement | null>) {
        event.stopPropagation();
        addToCart();
    }

    return (
        <Card className={`p-4 w-max h-max ${className} cursor-pointer`} key={product.slug} onClick={goTo}>
            <CardActionArea>
                <CardMedia className={'max-w-48 max-h-48'}>
                    <img src={product.imageURL} alt={product.name} />
                </CardMedia>
                <CardContent>
                    <Typography variant={"h5"}>{product.name}</Typography>
                    <Typography variant={'subtitle2'}>${product.priceUSD}</Typography>
                </CardContent>
            </CardActionArea>
            <CardActions>
                <Button variant={'outlined'} onClick={onAddToCart} fullWidth><ShoppingCartOutlined />{' '}Add to cart</Button>
            </CardActions>
        </Card>
    );
}
