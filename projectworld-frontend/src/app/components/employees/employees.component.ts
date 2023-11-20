import {HttpErrorResponse} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Employee} from 'src/app/domain/employee';
import {EmployeeService} from 'src/app/services/employeeService/employee.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css'],
})
export class EmployeesComponent implements OnInit {
  public employeesList: Employee[] = [];

  constructor(
    private empService: EmployeeService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.getEmployeeList();
  }

  getEmployeeList() {
    this.empService.getEmployeesList().subscribe({
      next: (value: any) => {
        this.employeesList = value;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
        console.log(err.status);
      },
    });
  }

  handleEditEmployee(empId: number) {
    this.router.navigate(['edit-employee', empId]);
  }

  handleDeleteEmployee(empId: number) {
    this.empService.deleteEmployee(empId).subscribe({
      next: (res) => {
        console.log(res);
        this.getEmployeeList();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  handlePreview(empId: number) {
    this.router.navigate(['view-employee', empId]);
  }

  // handleAddEmp() {
  //   this.router.navigate(row.id, {relativeTo: this.route});
  // }
}
