import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Employee} from 'src/app/domain/employee';
import {EmployeeService} from 'src/app/services/employeeService/employee.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css'],
})
export class EditEmployeeComponent implements OnInit {
  public emp = {} as Employee;

  constructor(
    private empService: EmployeeService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    let empId = this.activatedRoute.snapshot.params['id']; // mentioned "id" because we mentioned it in angular routes
    // console.log(this.activatedRoute.snapshot);
    this.empService.getEmployeeById(empId).subscribe({
      next: (res) => {
        this.emp = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
  onSubmit() {
    console.log(this.emp);
    this.empService.updateEmployee(this.emp, this.emp.id).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigate(['/employees']);
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
