import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginInscriptionComponent } from './login-inscription.component';

describe('LoginInscriptionComponent', () => {
  let component: LoginInscriptionComponent;
  let fixture: ComponentFixture<LoginInscriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginInscriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
