import {Typography} from "@mui/material";
import ProductList from "../components/item-list/ProductList.tsx";
import Product from "../types/product/Product.ts";

export default function Home() {
    const products: Product[] = [
        new Product({
            id: '1',
            name: 'Shirt',
            description: 'A shirt',
            priceUSD: 10,
            imageURL: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtFFxktqA06SC8Npj4teYqCAQNh8U9S7i15Q&s',
            tags: ['Clothing', 'Shirt']
        }),
        new Product({
            id: '2',
            name: 'Pants',
            description: 'Pants',
            priceUSD: 20,
            imageURL: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW2z5vTZNw9lphzf69Sq4ntQmM5zq5AXCU4w&s',
            tags: ['Clothing', 'Pants']
        }),
        new Product({
            id: '3',
            name: 'Shoes',
            description: 'Shoes',
            priceUSD: 30,
            imageURL: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW2z5vTZNw9lphzf69Sq4ntQmM5zq5AXCU4w&s',
            tags: ['Clothing', 'Shoes']
        }),
        new Product({
            id: '4',
            name: 'Shoes',
            description: 'Shoes',
            priceUSD: 30,
            imageURL: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW2z5vTZNw9lphzf69Sq4ntQmM5zq5AXCU4w&s',
            tags: ['Clothing', 'Shoes']
        }),
    ];

    return (
        <>
            <Typography variant='h3'>Clothing Store</Typography>
            <ProductList products={products} />
        </>
    );
}
