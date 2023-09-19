import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Feedback } from '../classes/feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private apiUrl = 'https://example.com/api/feedbacks';

  constructor(private http: HttpClient) { }

  getFeedbackById(id: number): Observable<Feedback> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Feedback>(url);
  }

  addFeedback(feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(this.apiUrl, feedback);
  }

  getFeedbacks(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(this.apiUrl);
  }

  submitFeedback(feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(this.apiUrl, feedback);
  }

  replyFeedback(feedbackId: number, reply: string): Observable<any> {
    const url = `${this.apiUrl}/${feedbackId}/reply`;
    return this.http.post(url, { reply });
  }


}
