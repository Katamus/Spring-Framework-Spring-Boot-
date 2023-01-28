import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  public cliente:Cliente = new Cliente();
  private errors: string[] = [];

  public titulo:string = "";

  constructor(private clienteService:ClienteService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarCliente();
  }

  cargarCliente(): void{
    this.activatedRoute.params.subscribe(params=>{
      let id = params['id'];
      if(id){
        this.clienteService.getCliente(id).subscribe(
          (cliente) => this.cliente = cliente
        )
      }
    })
  }

  public create(){
    this.clienteService.create(this.cliente).subscribe(
      response=> {
        this.router.navigate(['/clientes'])
        Swal.fire('Nuevo cliente',`Cliente ${this.cliente.nombre} creado con éxito!`,'success');
      },
      err=>{
        this.errors = err.error.errors as string[];
        console.log('Código del error desde el backend: '+ err.status);
        console.log(this.errors);
      }
    )
  }

  public update():void {
    this.clienteService.update(this.cliente).subscribe(
      response=> {
        this.router.navigate(['/clientes'])
        Swal.fire('Actualizar cliente',`Cliente ${this.cliente.nombre} Actualizado con éxito!`,'success');
      },
      err=>{
        this.errors = err.error.errors as string[];
        console.log('Código del error desde el backend: '+ err.status);
        console.log(this.errors);
      }
    )
  }

}
