import { Injectable } from '@angular/core';
import { formatDate,DatePipe } from '@angular/common';
import { Cliente } from './cliente';
import { map, Observable,catchError, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';
import {Router} from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  
  private urlEndPoint:string = 'api/clientes';

  constructor(private http:HttpClient, private router:Router) { }

  getClientes():Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndPoint).pipe(
      map(response =>{
        let cliente = response;
        return cliente.map(cliente =>{
          cliente.nombre = cliente.nombre.toLocaleUpperCase();
          let datePipe = new DatePipe('en-US');

          cliente.createAt = datePipe.transform(cliente.createAt,'dd/MM/yyyy');//formatDate(cliente.createAt,'dd-MM-yyyy','en-US');
          return cliente;
        })
      })
    );
  }

  create(cliente:Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.urlEndPoint,cliente,{headers:this.httpHeaders}).pipe(
      map( (response:any) => response.cliente as Cliente),
      catchError(e=>{

        if(e.status == 400 ){
          return throwError(e);
        }
        Swal.fire(e.error.mensaje, e.error.error, 'error'); 
        return throwError(e);
      })
    );
  }

  getCliente(id:number):Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e=>{
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error, 'error'); 
        return throwError(e);
      })
    );
  }

  update(cliente:Cliente):Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`,cliente,{headers:this.httpHeaders}).pipe(
      catchError(e=>{

        if(e.status == 400 ){
          return throwError(e);
        }

        console.error(e.error.mensaje);
        
        Swal.fire(e.error.mensaje, e.error.error, 'error'); 
        return throwError(e);
      }));
  }

  delete(id:number):Observable<number>{
    return this.http.delete<number>(`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders}).pipe(
      map(project=>id),
      catchError(e=>{
        console.error(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error, 'error'); 
        return throwError(e);
      })
    );
  }

}
