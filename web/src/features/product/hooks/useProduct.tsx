import Product from "../../../types/product/Product.ts";
import {useNavigate} from "react-router";

export function useProduct(product: Product) {
    const navigate = useNavigate();

    function goTo() {
        navigate(product.getLink());
    }

    function addToCart() {
        console.log('add to cart: ', product.name);
    }

    return { goTo, addToCart };
}
