import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmailService } from 'src/app/services/emailService/email.service';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {

  constructor(private emailService: EmailService) { }

  ngOnInit(): void {
  }

  doSubmitForm(form: NgForm) {
    console.log("form submitting working");
    console.log(form.value);
    this.emailService.sendEmail(form.value).subscribe((res: string) => {
      console.log(res);

    }, (err: HttpErrorResponse) => {
      console.log(err.message);

    });
  }
}
