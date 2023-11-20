import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Employee} from 'src/app/domain/employee';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseUrl = environment.apiBaseUrl + '/employees';
  constructor(private http: HttpClient) {}

  getEmployeesList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl + '/');
  }

  saveEmployee(emp: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl + '/save-employee', emp);
  }

  getEmployeeById(empId: number): Observable<Employee> {
    return this.http.get<Employee>(this.baseUrl + `/emp/${empId}`);
  }

  updateEmployee(emp: Employee, id: number): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl + `/edit-employee/${id}`, emp);
  }

  deleteEmployee(id: number): Observable<Object> {
    return this.http.delete(this.baseUrl + `/delete-employee/${id}`);
  }
}
