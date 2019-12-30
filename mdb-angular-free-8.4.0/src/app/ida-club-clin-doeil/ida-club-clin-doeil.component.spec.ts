import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdaClubClinDoeilComponent } from './ida-club-clin-doeil.component';

describe('IdaClubClinDoeilComponent', () => {
  let component: IdaClubClinDoeilComponent;
  let fixture: ComponentFixture<IdaClubClinDoeilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdaClubClinDoeilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdaClubClinDoeilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
