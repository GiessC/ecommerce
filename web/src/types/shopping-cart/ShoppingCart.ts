import {AddToCartRequest} from './AddToCartRequest.ts';

export interface ShoppingCartJSON {
    products: AddToCartRequest[];
    total: number;
}

export default class ShoppingCart {
    public readonly products: AddToCartRequest[];
    public readonly total: number;

    public constructor({ products, total }: ShoppingCartJSON) {
        this.products = products;
        this.total = total;
    }

    public addProduct(request: AddToCartRequest) {
        this.products.push(request);
    }
}
