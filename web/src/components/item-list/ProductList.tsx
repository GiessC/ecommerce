import Product from "../../types/product/Product.ts";
import Box from "@mui/material/Box";
import ProductListItem from "./ProductListItem.tsx";

interface ProductListProps {
    products: Product[];
}

export default function ProductList({ products }: ProductListProps) {
    return (
        <Box className={'flex flex-wrap space-x-4 space-y-4'}>
            {products.map((product) => (
                <ProductListItem key={product.id} product={product} />
            ))}
        </Box>
    );
}
