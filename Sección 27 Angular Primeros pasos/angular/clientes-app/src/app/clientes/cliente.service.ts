import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from "./clientes.json";
import { map, Observable,of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  
  private urlEndPoint:string = 'api/clientes';

  constructor(private http:HttpClient) { }

  getClientes():Observable<Cliente[]> {
    //return of(CLIENTES);
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }

  create(cliente:Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.urlEndPoint,cliente,{headers:this.httpHeaders});
  }

  getCliente(id:number):Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`);
  }

  update(cliente:Cliente):Observable<Cliente>{
    return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`,cliente,{headers:this.httpHeaders});
  }

  delete(id:number):Observable<number>{
    return this.http.delete<number>(`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders}).pipe(map(project=>id));
  }

}
