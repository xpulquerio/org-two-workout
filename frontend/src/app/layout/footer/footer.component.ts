import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  imports: [],
  standalone: true,
  templateUrl: './footer.component.html',
   styleUrl: './footer.component.css',
})
export class FooterComponent {

    // FAB
  fabOpen = false;
  
    // FAB
  toggleFab() {
    this.fabOpen = !this.fabOpen;
    // toggle class on container (handled via binding in template)
  }

  abrirReceita() {
    console.log('abrir modal receita');
    // abrir modal / navegar
  }
  abrirDespesa() {
    console.log('abrir modal despesa');
  }
  abrirTransferencia() {
    console.log('abrir modal transferencia');
  }

}
