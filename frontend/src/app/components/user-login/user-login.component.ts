import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/classes/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserService } from 'src/app/services/user.service';




@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  username: string="";
  password : string="";
  errorMessage = 'Invalid Credentials';
  successMessage: string="";
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {   }

  ngOnInit() {
  }

  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      this.router.navigate(['/hello-world']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  }







  // loginForm: FormGroup;
  // errorMessage: string | undefined;
  // user ! : User;

  // constructor(
  //   private fb: FormBuilder,
  //   private userService: UserService,
  //   private router: Router
  // ) {
  //   this.loginForm = this.fb.group({
  //     email: ['', [Validators.required, Validators.email]],
  //     password: ['', [Validators.required]]
  //   });
  // }
  // ngOnInit(): void {
  //   throw new Error('Method not implemented.');
  // }

  // onSubmit() {
  //   const email = this.loginForm.value.email;
  //   const password = this.loginForm.value.password;
  //   this.userService.login(email, password).subscribe(
  //     () => {
  //       this.router.navigate(['/userdashboard']);
  //     },
  //     (error: string | undefined) => {
  //       this.errorMessage = error;
  //     }
  //   );
  // }

}
