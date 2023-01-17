import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { CLIENTES } from "./clientes.json";
import { Observable,of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  
  private urlEndPoint:string = 'localhost:8080/api/clientes';

  constructor(private http:HttpClient) { }

  getCliente():Observable<Cliente[]> {
    //return of(CLIENTES);
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }
}
