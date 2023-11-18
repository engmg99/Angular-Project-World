import {Component, OnInit} from '@angular/core';
import {Accounts} from 'src/app/domain/accounts';

@Component({
  selector: 'app-bank-accounts',
  templateUrl: './bank-accounts.component.html',
  styleUrls: ['./bank-accounts.component.css'],
})
export class BankAccountsComponent implements OnInit {
  accounts: Accounts[] = [];
  accId: number = 0;
  constructor() {}

  ngOnInit(): void {}
  createAcc(name: any, bankName: any, amt: any) {
    console.log(name, bankName, amt);
    let accObj = {
      id: this.accId++,
      name: name,
      bankName: bankName,
      balance: amt,
    };
    this.accounts.push(accObj);
  }
}
