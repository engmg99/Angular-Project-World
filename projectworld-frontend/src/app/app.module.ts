import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {BookStoreComponent} from './components/book-store/book-store.component';
import {HomeComponent} from './components/home/home.component';
import {EmailComponent} from './components/email/email.component';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SendEmailComponent} from './components/send-email/send-email.component';
import {BankAccountsComponent} from './components/bank-accounts/bank-accounts.component';
import {EmployeesComponent} from './components/employees/employees.component';
import {FooterComponent} from './components/footer/footer.component';
import {CreateEmployeeComponent} from './components/employees/create-employees/create-employee/create-employee.component';
import {EditEmployeeComponent} from './components/employees/edit-employee/edit-employee.component';
import {EmployeeDetailComponent} from './components/employees/employee-details/employee-detail/employee-detail.component';
import {MatchHistoryComponent} from './components/cricket-matches/match-history/match-history.component';
import {LiveMatchesComponent} from './components/cricket-matches/live-matches/live-matches.component';
import {MatchPointTableComponent} from './components/cricket-matches/match-point-table/match-point-table.component';
import {MatchCardComponent} from './components/cricket-matches/live-matches/match-card/match-card/match-card.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BookStoreComponent,
    HomeComponent,
    EmailComponent,
    SendEmailComponent,
    BankAccountsComponent,
    EmployeesComponent,
    FooterComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    EmployeeDetailComponent,
    MatchHistoryComponent,
    LiveMatchesComponent,
    MatchPointTableComponent,
    MatchCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
  ],
  providers: [MatSnackBar],
  bootstrap: [AppComponent],
})
export class AppModule {}
