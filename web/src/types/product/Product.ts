import ProductSize, {ProductSizeJSON} from './ProductSize.ts';

export interface ProductJSON {
    slug: string;
    name: string;
    description: string;
    priceUSD: number;
    sizes?: ProductSizeJSON[];
    imageURL: string;
    tags: string[];
}

export default class Product {
    slug: string;
    name: string;
    description: string;
    priceUSD: number;
    sizes: ProductSize[];
    imageURL: string;
    tags: string[];

    constructor({ slug, name, description, priceUSD, sizes, imageURL, tags }: ProductJSON) {
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.priceUSD = priceUSD;
        this.sizes = sizes ? sizes.map((size) => new ProductSize(size)) : [];
        this.imageURL = imageURL;
        this.tags = tags;
    }

    public getLink(): string {
        return `/app/products/${this.slug}`;
    }
}
