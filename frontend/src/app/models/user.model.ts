export interface User {
    id?: number;
    first_name: string;
    last_name: string;
    email: string;
    password: string;
    phone: string;
    role: string;
    status?: boolean;
    createdAt?: string;
}