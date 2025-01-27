import ProductSize, {ProductSizeJSON} from './ProductSize.ts';

export interface ProductJSON {
    id: string;
    name: string;
    description: string;
    priceUSD: number;
    sizes?: ProductSizeJSON[];
    imageURL: string;
    tags: string[];
}

export default class Product {
    id: string;
    name: string;
    description: string;
    priceUSD: number;
    sizes: ProductSize[];
    imageURL: string;
    tags: string[];

    constructor({ id, name, description, priceUSD, sizes, imageURL, tags }: ProductJSON) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceUSD = priceUSD;
        this.sizes = sizes ? sizes.map((size) => new ProductSize(size)) : [];
        this.imageURL = imageURL;
        this.tags = tags;
    }
}
