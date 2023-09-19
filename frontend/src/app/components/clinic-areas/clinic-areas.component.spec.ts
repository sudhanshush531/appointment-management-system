import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClinicAreasComponent } from './clinic-areas.component';

describe('ClinicAreasComponent', () => {
  let component: ClinicAreasComponent;
  let fixture: ComponentFixture<ClinicAreasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClinicAreasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClinicAreasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
