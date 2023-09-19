import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  registrationForm !: FormGroup;
  submitted = false;

  user = {
    userName: '',
    email: '',
    password: '',
  };
  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    this.userService.adUser(this.user)
      .subscribe(
        response => console.log('User registered successfully!', response),
        error => console.error('Error registering user:', error)
      );
  }
  
}