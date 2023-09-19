import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Appointment } from '../classes/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private apiUrl = 'https:localhost:8080/appointments';
  
  constructor(private http: HttpClient) { }

  createAppointment(appointmentData: any): Observable<Appointment> {
    // Send a POST request to the API with the appointment data
    return this.http.post<Appointment>(this.apiUrl, appointmentData);
  }

  updateAppointment(id: number, appointmentData: any): Observable<Appointment> {
    // Send a PUT request to the API to update the appointment with the given ID
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Appointment>(url, appointmentData);
  }

  getAllAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/all`).pipe
    (map(response =>response)
    );
  }

  getAppointmentByUserId(userId: number): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/${userId}`);
  }

  getAppointmentById(appointmentId: number): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/${appointmentId}`);
  }

  getAvailableAppointments(clinicId: number, date: string): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/available?clinicId=${clinicId}&date=${date}`);
  }

  bookAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.apiUrl}`, appointment);
  }

  cancelAppointment(appointmentId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${appointmentId}`);
  }

  

}
