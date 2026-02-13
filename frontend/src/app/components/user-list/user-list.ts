import { Component } from '@angular/core';
import { first } from 'rxjs';
import { User } from '../../models/user.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
  imports: [CommonModule],
  templateUrl: './user-list.html',
  styleUrls: ['./user-list.css'],
})
export class UserListComponent {
  users: User[]=[
    {first_name: 'Ivan',last_name: 'El Amo', email:'ivan@example.com',password:'password',phone:'123',role:'ADMIN',status:true,createdAt:'2026-01-25'},
    {first_name: 'Ana',last_name: 'La Jefa', email:'ana@example.com',password:'password',phone:'456',role:'USER',status:true,createdAt:'2026-03-25'}
  ];
}
