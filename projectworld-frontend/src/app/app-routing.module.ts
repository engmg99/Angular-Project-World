import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BankAccountsComponent } from './components/bank-accounts/bank-accounts.component';
import { BookStoreComponent } from './components/book-store/book-store.component';
import { EmailComponent } from './components/email/email.component';
import { HomeComponent } from './components/home/home.component';
import { SendEmailComponent } from './components/send-email/send-email.component';

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "bookstore", component: BookStoreComponent },
  { path: "home", component: HomeComponent },
  { path: "email", component: EmailComponent },
  { path: "sendEmail", component: SendEmailComponent },
  { path: "bankAccounts", component: BankAccountsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
