import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clinic-areas',
  templateUrl: './clinic-areas.component.html',
  styleUrls: ['./clinic-areas.component.css']
})
export class ClinicAreasComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  areas = [
    {
      name: 'Area 1',
      address: '123 Main St, City, State, Zip',
      phone: '(123) 456-7890'
    },
    {
      name: 'Area 2',
      address: '456 Oak Ave, City, State, Zip',
      phone: '(123) 456-7890'
    },
    {
      name: 'Area 3',
      address: '789 Maple St, City, State, Zip',
      phone: '(123) 456-7890'
    }
  ];

}
