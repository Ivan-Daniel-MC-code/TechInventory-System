export interface Product {
    id?: number;
    sku: string;
    name: string;
    description: string;
    price: number;
    stock: number;
    minStock: number;
    imageUrl: string;
    // Aquí definimos las relaciones como objetos simples
    category?: { id: number; name?: string };
    brand?: { id: number; name?: string };
    supplier?: { id: number; companyName?: string };
    createdAt?: string;
}