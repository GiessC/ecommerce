export interface ProductSizeJSON {
    id: string
    name: string
    priceUSD: number
    quantity: number
}

export default class ProductSize {
    id: string
    name: string
    priceUSD: number
    quantity: number

    constructor({ id, name, priceUSD, quantity }: ProductSizeJSON) {
        this.id = id
        this.name = name
        this.priceUSD = priceUSD
        this.quantity = quantity
    }
}
