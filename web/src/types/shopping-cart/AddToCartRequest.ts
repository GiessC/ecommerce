import {addToCartSchema} from '../../features/product/api/ProductApi.ts';
import {z} from 'zod';

export type AddToCartRequest = z.infer<typeof addToCartSchema>;
