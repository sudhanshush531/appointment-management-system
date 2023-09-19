import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { AppointmentBookingComponent } from './components/appointment-booking/appointment-booking.component';
import { ClinicAreasComponent } from './components/clinic-areas/clinic-areas.component';
import { FeedbackFormComponent } from './components/feedback-form/feedback-form.component';
import { ReceiptComponent } from './components/receipt/receipt.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'welcome', component: WelcomePageComponent },
  { path: 'consumerlogin', component: UserLoginComponent },
  { path: 'admindashboard', component: AdminDashboardComponent },

  { path: 'adminlogin', component: AdminLoginComponent },
  { path: 'userdashboard', component: UserDashboardComponent },
  { path: 'bookappointment', component: AppointmentBookingComponent },
  { path: 'userRegistration', component: UserRegistrationComponent },
  { path: 'createfeedback', component: FeedbackFormComponent },
  { path: 'clinic', component: ClinicAreasComponent },
  // { path: 'cancelappointment', component: BookingCancellationComponent },
  { path: 'generatereceipt', component: ReceiptComponent },

  { path: 'receipt', component: ReceiptComponent },
  { path: 'feedback', component: FeedbackFormComponent },
];
@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
