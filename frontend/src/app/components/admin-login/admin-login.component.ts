import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

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
      this.router.navigate(['/userdashboard']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  }





  // loginForm: FormGroup;
  // errorMessage: string | undefined;

  // constructor(
  //   private fb: FormBuilder,
  //   private authService: AuthenticationService,
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
  //   this.authService.(email, password).subscribe(
  //     () => {
  //       this.router.navigate(['/admin/dashboard']);
  //     },
  //     (error: string | undefined) => {
  //       this.errorMessage = error;
  //     }
  //   );
  // }

}
