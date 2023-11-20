import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Employee} from 'src/app/domain/employee';
import {EmployeeService} from 'src/app/services/employeeService/employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css'],
})
export class EmployeeDetailComponent implements OnInit {
  public employee = {} as Employee;
  id: number = 0;
  constructor(
    private empService: EmployeeService,
    private activatedRoutes: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.id = this.activatedRoutes.snapshot.params['id'];
    this.empService.getEmployeeById(this.id).subscribe({
      next: (res) => {
        console.log(res);
        this.employee = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
