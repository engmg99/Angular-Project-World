import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BankAccountsComponent} from './components/bank-accounts/bank-accounts.component';
import {BookStoreComponent} from './components/book-store/book-store.component';
import {EmailComponent} from './components/email/email.component';
import {HomeComponent} from './components/home/home.component';
import {SendEmailComponent} from './components/send-email/send-email.component';
import {EmployeesComponent} from './components/employees/employees.component';
import {CreateEmployeeComponent} from './components/employees/create-employees/create-employee/create-employee.component';
import {EditEmployeeComponent} from './components/employees/edit-employee/edit-employee.component';
import {EmployeeDetailComponent} from './components/employees/employee-details/employee-detail/employee-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'bookstore', component: BookStoreComponent},
  {path: 'home', component: HomeComponent},
  {path: 'email', component: EmailComponent},
  {path: 'sendEmail', component: SendEmailComponent},
  {path: 'bankAccounts', component: BankAccountsComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},
  {path: 'edit-employee/:id', component: EditEmployeeComponent},
  {path: 'view-employee/:id', component: EmployeeDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
