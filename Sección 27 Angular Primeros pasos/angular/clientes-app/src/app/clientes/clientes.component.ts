import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2'
import { tap } from 'rxjs';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent implements OnInit {


  clientes: Cliente[] = [];

  constructor( private clienteService:ClienteService) { }

  ngOnInit(): void {
    this.clienteService.getClientes().pipe(
      tap(cliente=>{
        console.log("Log desde componente");
        console.log(cliente);
      })
    ).subscribe(data=>this.clientes = data);
  }

  delete(cliente:Cliente):void {
    Swal.fire({
      title: 'Do you want to save the changes?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      if (result.isConfirmed) {
        this.clienteService.delete(cliente.id).subscribe(
          data=>{
            this.clientes = this.clientes.filter(cli => cli.id !== cliente.id);
            Swal.fire('Saved!', '', 'success')
          }
        );
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })
  }

}
