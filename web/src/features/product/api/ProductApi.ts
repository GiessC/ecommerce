import Product from '../../../types/product/Product.ts';
import {ProductSize} from '../../../types/product/ProductSize.ts';
import {z} from 'zod';
import {AddToCartRequest} from '../../../types/product/AddToCartRequest.ts';

async function getProductBySlug(slug: string): Promise<Product | null> {
    return new Product({
        slug,
        name: 'Product name',
        description: 'Product description',
        priceUSD: 0,
        sizes: [
            ProductSize.MEDIUM,
            ProductSize.LARGE,
        ],
        imageURL: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW2z5vTZNw9lphzf69Sq4ntQmM5zq5AXCU4w&s',
        tags: [],
    })
}

export const addToCartSchema = z.object({
    slug: z.string(),
    size: z.nativeEnum(ProductSize).optional(),
});


async function addToCart({ slug, size }: AddToCartRequest): Promise<void> {
    console.log(slug, size);
}

const ProductApi = {
    getProductBySlug,
    addToCart,
};
export default ProductApi;
