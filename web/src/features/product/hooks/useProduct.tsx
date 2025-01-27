import Product from "../../../types/product/Product.ts";
import {useNavigate} from "react-router";
import productApi from "../api/ProductApi.ts";
import {AddToCartRequest} from "../../../types/product/AddToCartRequest.ts";

export function useProduct(product?: Product | null) {
    const navigate = useNavigate();

    function goTo() {
        if (!product) return;
        navigate(product.getLink());
    }

    async function addToCart(request: AddToCartRequest) {
        if (!product) return;
        await productApi.addToCart(request);
    }

    return { goTo, addToCart };
}
