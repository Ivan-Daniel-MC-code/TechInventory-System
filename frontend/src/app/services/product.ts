import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model'; // Asegúrate de crear este modelo primero

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // Esta es la puerta de entrada a tu Backend de Java
  private apiUrl = 'http://localhost:8080/api/products';
 
  constructor(private http: HttpClient) { }

  // GET: Traer todos los productos de SQL Server
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  // POST: Guardar un producto nuevo
  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }
  // Cambiamos Observable<void> por Observable<any>
  deleteProduct(id: number): Observable<any> {
  // Limpiamos los paréntesis extra para que Angular no se confunda de comando
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.apiUrl}/${id}`, product);
  }
}