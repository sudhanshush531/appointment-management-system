import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Appointment } from '../classes/appointment';
import { Clinic } from '../classes/clinic';
import { Doctor } from '../classes/doctor';
import { Feedback } from '../classes/feedback';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private apiUrl = 'http://localhost:8080/admins'; // Replace with your API URL

  constructor(private http: HttpClient) { }

  // Function to get all booked appointments
  getAllAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/appointments`).pipe
    (map(response =>response)
    );
  }

  getAllDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.apiUrl}/doctors`);
  }

  getAllClinics(): Observable<Clinic[]> {
    return this.http.get<Clinic[]>(`${this.apiUrl}/clinics`);
  }

  // Function to cancel a booking
  cancelBooking(bookingId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/appointments/${bookingId}`);
  }

  // Function to get all users
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/users`);
  }

  // Function to get all feedbacks
  getAllFeedbacks(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.apiUrl}/feedbacks`);
  }

  // Function to reply to a feedback
  replyToFeedback(feedbackId: string, reply: string): Observable<any> {
    return this.http.put(`${this.apiUrl}/feedbacks/${feedbackId}`, { reply });
  }

}
