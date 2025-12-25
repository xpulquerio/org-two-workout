import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Account } from '../../../models/account.model';
import { CalendarBarComponent } from '../calendar-bar/calendar-bar.component';

@Component({
  selector: 'app-train',
  imports: [FormsModule, CalendarBarComponent],
  standalone: true,
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css'],
})

export class TrainComponent implements OnInit {
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