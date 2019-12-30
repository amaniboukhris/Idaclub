import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotDePassOblierComponent } from './mot-de-pass-oblier.component';

describe('MotDePassOblierComponent', () => {
  let component: MotDePassOblierComponent;
  let fixture: ComponentFixture<MotDePassOblierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotDePassOblierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotDePassOblierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
