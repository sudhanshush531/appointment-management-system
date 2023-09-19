import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/classes/appointment';
import { Clinic } from 'src/app/classes/clinic';
import { Doctor } from 'src/app/classes/doctor';
import { AdminService } from 'src/app/services/admin.service';
import { FeedbackService } from 'src/app/services/feedback.service';
import { UserService } from 'src/app/services/user.service';
import { ClinicAreasComponent } from '../clinic-areas/clinic-areas.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
  template: `
    <div>
      <button (click)="bookAppointment()">Book Appointment</button>
      <button (click)="cancelAppointment()">Cancel Appointment</button>
      <button (click)="viewReceipt()">View Receipt</button>
      <button (click)="leaveFeedback()">Leave Feedback</button>
      <button (click)="rechargeAccount()">Recharge Account</button>
    </div>
  `
})
export class UserDashboardComponent implements OnInit {

  consumerForm !: FormGroup ;
  appointmentOj: Appointment = new Appointment();

  
appointmentForm !: FormGroup;

constructor(
  private adminService: AdminService,
  private userService: UserService,
  private feedbackService: FeedbackService,private formBuilder : FormBuilder ,private _router: Router
) { }
  doctors: Doctor[] = [];
  clinics: Clinic[] = [];
  ngOnInit(): void {
  }
  bookAppointment(): void {
    // Code to book an appointment
  }

  // getDoctorsData(): void {
  //   this.adminService.getAllDoctors.subscribe(
  //     doctors => this.doctors = doctors,
  //     error => console.log(error)
  //   );
  // }
  
  cancelAppointment(): void {
    // Code to cancel an appointment
  }

  viewReceipt(): void {
    // Code to view a receipt
  }

  leaveFeedback(): void {
    // Code to leave feedback
  }

  rechargeAccount(): void {
    // Code to recharge the account
  }

}
