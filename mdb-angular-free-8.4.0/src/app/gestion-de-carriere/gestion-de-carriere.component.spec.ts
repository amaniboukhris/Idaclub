import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionDeCarriereComponent } from './gestion-de-carriere.component';

describe('GestionDeCarriereComponent', () => {
  let component: GestionDeCarriereComponent;
  let fixture: ComponentFixture<GestionDeCarriereComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionDeCarriereComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionDeCarriereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
