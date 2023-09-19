import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Feedback } from 'src/app/classes/feedback';
import { FeedbackService } from 'src/app/services/feedback.service';


@Component({
  selector: 'app-feedback-form',
  templateUrl: './feedback-form.component.html',
  styleUrls: ['./feedback-form.component.css']
})
export class FeedbackFormComponent implements OnInit {

  form : Feedback = new Feedback;

  feedbacks !: Feedback[];
  errorMessage !: string;
  feedbackForm !: FormGroup;
feedback !: Feedback;
  constructor(private feedbackService: FeedbackService, private router: Router, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.feedbackForm = this.formBuilder.group({
      fId : [''],
      message :['']
    })
  }

  onSubmit() {
    this.form.fId= this.feedbackForm.value.fId;
    this.form.message = this.feedbackForm.value.message;
    this.feedbackService.addFeedback(this.form).subscribe(res=>{console.log(res)});
  }

  getFeedbacks() {
    this.feedbackService.getFeedbacks().subscribe(
      feedbacks => this.feedbacks = feedbacks,
      error => this.errorMessage = error.message
    );
  }

  submitFeedback(feedback: Feedback) {
    this.feedbackService.submitFeedback(feedback).subscribe(
      createdFeedback => {
        this.feedbacks.push(createdFeedback);
        // Clear the form
        feedback.fId = 1;
        feedback.message = '';
      },
      error => this.errorMessage = error.message
    );
  }

  replyFeedback(feedbackId: number, reply: string) {
    this.feedbackService.replyFeedback(feedbackId, reply).subscribe(
      result => {
        // Update the feedback list to reflect the reply
        const feedbackIndex = this.feedbacks.findIndex(f => f.fId === feedbackId);
        this.feedbacks[feedbackIndex].message = reply;
      },
      error => this.errorMessage = error.message
    );
  }

}
