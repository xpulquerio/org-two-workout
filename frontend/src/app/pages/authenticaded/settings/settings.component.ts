import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Account } from '../../../models/account.model';

@Component({
  selector: 'app-settings',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css'],
})

export class SettingsComponent implements OnInit {
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
    //vsf
  }
}