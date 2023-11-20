import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Employee} from 'src/app/domain/employee';
import {EmployeeService} from 'src/app/services/employeeService/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css'],
})
export class CreateEmployeeComponent implements OnInit {
  public emp = {} as Employee;
  constructor(
    private empService: EmployeeService,
    private router: Router,
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.emp);
    this.empService.saveEmployee(this.emp).subscribe({
      next: (res) => {
        console.log(res);
        this.goToEmpList();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  goToEmpList() {
    this.router.navigate(['/employees']);
  }
}
