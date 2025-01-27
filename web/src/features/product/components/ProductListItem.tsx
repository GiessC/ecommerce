import Product from "../../../types/product/Product.ts";
import {Card, CardActionArea, CardContent, CardMedia, Typography} from "@mui/material";
import {useProduct} from "../hooks/useProduct.tsx";

interface ProductListItemProps {
    className?: string;
    product: Product;
}

export default function ProductListItem({product, className=''}: ProductListItemProps) {
    const { goTo } = useProduct(product);

    return (
        <Card className={`p-4 w-max h-max ${className} cursor-pointer`} key={product.slug}>
            <CardActionArea onClick={goTo}>
                <CardMedia className={'max-w-48 max-h-48'}>
                    <img src={product.imageURL} alt={product.name} />
                </CardMedia>
                <CardContent>
                    <Typography variant={"h5"}>{product.name}</Typography>
                    <Typography variant={'subtitle2'}>${product.priceUSD}</Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
}
