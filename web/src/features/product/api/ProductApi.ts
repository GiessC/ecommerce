import Product from '../../../types/product/Product.ts';

async function getProductBySlug(slug: string): Promise<Product | null> {
    return new Product({
        slug,
        name: 'Product name',
        description: 'Product description',
        priceUSD: 0,
        sizes: [],
        imageURL: '',
        tags: [],
    })
}

const ProductApi = { getProductBySlug };
export default ProductApi;
