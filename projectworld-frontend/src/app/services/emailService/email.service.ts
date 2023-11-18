import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Email} from 'src/app/domain/email';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EmailService {
  public apiServerUrl = environment.apiBaseUrl + '/email';

  constructor(private http: HttpClient) {}

  public sendEmail(emailData: Email): Observable<string> {
    return this.http.post(`${this.apiServerUrl}/sendEmail`, emailData, {responseType: 'text'});
  }
}
