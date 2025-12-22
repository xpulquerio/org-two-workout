import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Account } from '../../../models/account.model';

@Component({
  selector: 'app-settings',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css'],
})

export class SettingsComponent {
  // data
  page_name = "Configurações";
  // forms
  accountName = '';
  accountList: Account[] = [];
  loadingAccounts = false;
  // controla o pop-up
  isAccountCreateOpen = false;
  
  constructor(

      // private readonly accountService: AccountService,
  
    ) {}

  ngOnInit(): void {
    console.log('ENTROU NO COMPONENTE DE CONTAS');
    this.AccountList();
  }

  openPopupAccountCreate() {
    this.isAccountCreateOpen = true;
  }

  closePopupAccountCreate() {
    this.isAccountCreateOpen = false;
  }

  saveAccount() {
    console.log("Conta criada:", this.accountName);

    // this.accountService.AccountCreate({ name: this.accountName }).subscribe({
    //   next: () => {
    //     this.accountName = '';
    //     this.AccountList(); // 🔥 atualiza a lista
    //     this.closePopupAccountCreate();
    //   },
    //   error: err => console.error(err)
    // });

    // this.closePopupAccountCreate();
  }
  
  AccountList() {
    this.loadingAccounts = true;

  //   this.accountService.AccountList().subscribe({
  //     next: (res: Account[]) => {
  //       this.accountList = res;
  //       this.loadingAccounts = false;
  //     },
  //     error: err => {
  //       console.error(err);
  //       this.loadingAccounts = false;
  //     }
  //   });
  }

}
