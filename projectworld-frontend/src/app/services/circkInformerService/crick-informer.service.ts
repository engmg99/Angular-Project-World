import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CrickInformerService {
  public apiServerUrl = environment.apiBaseUrl + '/match';

  constructor(private http: HttpClient) {}

  public getAllMatches() {
    return this.http.get(`${this.apiServerUrl}/`);
  }

  public getLiveMatches() {
    return this.http.get(`${this.apiServerUrl}/live`);
  }

  public getPointTable() {
    return this.http.get(`${this.apiServerUrl}/point-table`);
  }
}
