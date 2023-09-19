import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppointmentService } from 'src/app/services/appointment.service';



@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {

  appointment: any;

  constructor(
    private route: ActivatedRoute,
    private appointmentService: AppointmentService
  ) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  // ngOnInit(): void {
  //   const id = this.route.snapshot.paramMap.get('id');
  //   this.appointment = this.appointmentService.getAppointmentById(id);
  // }


}
