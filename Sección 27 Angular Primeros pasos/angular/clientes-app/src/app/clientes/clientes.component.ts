import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent implements OnInit {


  clientes:Cliente[] = [
    {id: 1,nombre : 'Andrés',apellido: 'Guzmán',createAt: '2023-01-21', email: 'profesor@bolsadeideas.com' },
    {id: 2,nombre : 'Mr Jon',apellido: 'Doe',createAt: '2023-01-20', email: 'joe.doe@gmail.com' },
    {id: 3,nombre : 'Linus',apellido: 'Torvalds',createAt: '2023-01-19', email: 'linus.torvalds@gmail.com'}
  
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
