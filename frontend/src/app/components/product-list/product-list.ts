import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule], // Necesario para usar *ngFor
  templateUrl: './product-list.html',
  styleUrl: './product-list.css'
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  productoParaEditar: Product | null = null;

  constructor(
  private productService: ProductService,
  private cdr: ChangeDetectorRef // <--- Agregue esto
) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
        console.log('Productos cargados en TS:', this.products.length);
        console.log('Productos cargados:', data);
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Error al cargar productos', err)
    });
  }
  deleteProduct(id: number | undefined):void{
    if (id !== undefined && confirm('¿Estás seguro de eliminar este producto?')){
      this.productService.deleteProduct(id).subscribe({
        next: () => {
          this.products = this.products.filter(p =>p.id != id);
          console.log('Producto eliminado con exito');
        },
        error: (err) => console.error('Error al eliminar',err)
      });
    }
  }
  seleccionarParaEditar(producto: Product){
    this.productoParaEditar = producto;
    console.log("Has seleccionado para editar:", producto.name);
  }
}