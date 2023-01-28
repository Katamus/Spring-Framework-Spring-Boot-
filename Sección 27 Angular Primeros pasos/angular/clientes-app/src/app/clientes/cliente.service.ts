import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from "./clientes.json";
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
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }

  create(cliente:Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.urlEndPoint,cliente,{headers:this.httpHeaders});
  }

  getCliente(id:number):Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e=>{
        this.router.navigate(['/clientes']);
        console.log(e.error.mensaje);
        Swal.fire('Error al editar', e.error.mensaje, 'error'); 
        return throwError(e);
      })
    );
  }

  update(cliente:Cliente):Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`,cliente,{headers:this.httpHeaders});
  }

  delete(id:number):Observable<number>{
    return this.http.delete<number>(`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders}).pipe(map(project=>id));
  }

}
