import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/classes/appointment';
import { Clinic } from 'src/app/classes/clinic';
import { Doctor } from 'src/app/classes/doctor';
import { AdminService } from 'src/app/services/admin.service';
import { AppointmentService } from 'src/app/services/appointment.service';
import { FeedbackService } from 'src/app/services/feedback.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-appointment-booking',
  templateUrl: './appointment-booking.component.html',
  styleUrls: ['./appointment-booking.component.css']
})
export class AppointmentBookingComponent implements OnInit {

  appointmentForm: FormGroup;
  billForm  !: FormGroup;

  consumerForm !: FormGroup ;
  appointmentOj: Appointment = new Appointment();


  constructor(private adminService: AdminService,
    private userService: UserService,
    private feedbackService: FeedbackService,private formBuilder: FormBuilder, private appointmentService: AppointmentService,private _router: Router) {
    this.appointmentForm = this.formBuilder.group({
    appointmentId : ['', Validators.required],
    appointmentDate : ['', Validators.required],
    appointmentTime : ['', Validators.required],
    appointmentFees : ['', Validators.required],
    appointmentStatus : ['', Validators.required],
    });
  }

  doctors: Doctor[] = [];
  clinics: Clinic[] = [];
  
  ngOnInit(): void {
    this.billForm = this.formBuilder.group({
      appointmentId : [''],
      appointmentDate : [''],
      appointmentTime : [''],
      appointmentFees : [''],
      appointmentStatus :[''],
    })
  }
  

  onSubmit() {
    // Retrieve the appointment data from the form
    const appointmentData = this.appointmentForm.value;

    // Call the appointment service to create a new appointment
    this.appointmentService.createAppointment(appointmentData).subscribe(
      response => {
        console.log('Appointment created successfully:', response);
        // Clear the form after the appointment is created
        this.appointmentForm.reset();
      },
      error => {
        console.log('Error creating appointment:', error);
      }
    );
  }

}
