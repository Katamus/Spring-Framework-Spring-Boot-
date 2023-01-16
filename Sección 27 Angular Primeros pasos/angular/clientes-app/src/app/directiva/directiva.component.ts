import { Component } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html'
})
export class DirectivaComponent{

  habilitar:boolean = true;

  listaCurso:string[] = [`TypeScript`,`JavaScript`,`Java SE`,'C#']

  constructor() { }

  setHabilitar():void {
    this.habilitar = !this.habilitar;
  }

}
