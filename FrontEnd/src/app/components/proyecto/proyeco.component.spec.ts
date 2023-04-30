import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyecoComponent } from './proyeco.component';

describe('ProyecoComponent', () => {
  let component: ProyecoComponent;
  let fixture: ComponentFixture<ProyecoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProyecoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProyecoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
