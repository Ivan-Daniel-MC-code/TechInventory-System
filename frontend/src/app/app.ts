import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common'; // ¡Añade esto para que el HTML entienda la lógica!
import { ProductListComponent } from './components/product-list/product-list';
import { UserListComponent } from './components/user-list/user-list';

@Component({
  selector: 'app-root',
  standalone: true, // Asegúrate de que tenga esto
  imports: [CommonModule, ProductListComponent, UserListComponent], // Añadimos CommonModule
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('mi-primer-proyecto');

  // LA PERILLA: Esta variable decide qué componente se muestra
  // Empezamos mostrando 'productos' por defecto
  view: string = 'productos'; 
}