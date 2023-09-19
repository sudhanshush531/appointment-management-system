import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-appointment-availability',
  templateUrl: './appointment-availability.component.html',
  styleUrls: ['./appointment-availability.component.css']
})
export class AppointmentAvailabilityComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  timeslots = [
    { time: '10:00 AM', available: true },
    { time: '11:00 AM', available: true },
    { time: '12:00 PM', available: false },
    { time: '01:00 PM', available: true },
    { time: '02:00 PM', available: false },
    { time: '03:00 PM', available: true }
  ];

  selectedTimeslot: any;

  selectTimeSlot(timeslot: any) {
    if (timeslot.available) {
      this.selectedTimeslot = timeslot;
    }
  }

  bookAppointment() {
    // logic for booking the selected appointment
  }

}
