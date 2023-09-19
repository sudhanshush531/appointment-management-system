import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { ClinicAreasComponent } from './components/clinic-areas/clinic-areas.component';
import { AppointmentAvailabilityComponent } from './components/appointment-availability/appointment-availability.component';
import { AppointmentBookingComponent } from './components/appointment-booking/appointment-booking.component';
import { FeedbackFormComponent } from './components/feedback-form/feedback-form.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { ReceiptComponent } from './components/receipt/receipt.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './classes/auth-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    UserLoginComponent,
    UserRegistrationComponent,
    ClinicAreasComponent,
    AppointmentAvailabilityComponent,
    AppointmentBookingComponent,
    FeedbackFormComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    ReceiptComponent,
    WelcomePageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
