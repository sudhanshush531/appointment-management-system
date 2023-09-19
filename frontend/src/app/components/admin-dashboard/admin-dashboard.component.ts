import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/classes/appointment';
import { Feedback } from 'src/app/classes/feedback';
import { User } from 'src/app/classes/user';
import { AdminService } from 'src/app/services/admin.service';
import { AppointmentService } from 'src/app/services/appointment.service';
import { FeedbackService } from 'src/app/services/feedback.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  appointments : Appointment[]=[];
  users !: User[];
  feedbacks !: Feedback[];
  errorMessage!: string;

  constructor(
    adminService : AdminService,
    private appointmentService: AppointmentService,
    private userService: UserService,
    private feedbackService: FeedbackService
  ) { }

  ngOnInit(): void {
    this.appointmentService.getAllAppointments().subscribe(
      (appointments) => {
        this.appointments = appointments;
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );

    this.userService.getUsers().subscribe(
      (users) => {
        this.users = users;
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );

    this.feedbackService.getFeedbacks().subscribe(
      (feedbacks) => {
        this.feedbacks = feedbacks;
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );
  }

  cancelAppointment(appointmentId: number) {
    this.appointmentService.cancelAppointment(appointmentId).subscribe(
      (result) => {
        // Update the appointments list to reflect the cancellation
        this.appointments = this.appointments.filter((a) => a.appointmentId !== appointmentId);
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );
  }

  viewUserAppointment(userId: number) {
    this.appointmentService.getAppointmentByUserId(userId).subscribe(
      appointments => this.appointments = appointments,
      error => console.log(error)
    );
  }

  viewUserData(user: User) {
    // Code to display user data goes here
  }

  viewFeedback(feedback: Feedback) {
    // Code to display feedback data goes here
  }

  replyFeedback(feedbackId: number, reply: string) {
    this.feedbackService.replyFeedback(feedbackId, reply).subscribe(
      (result) => {
        // Update the feedback list to reflect the reply
        const index = this.feedbacks.findIndex((feedback) => feedback.fId === feedbackId);
        if (index !== -1) {
          this.feedbacks[index].message = reply;
        }
      },
      (error) => {
        this.errorMessage = error.message;
      }
    );
  }

}
