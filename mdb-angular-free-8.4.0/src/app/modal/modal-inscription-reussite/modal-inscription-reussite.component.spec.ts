import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalInscriptionReussiteComponent } from './modal-inscription-reussite.component';

describe('ModalInscriptionReussiteComponent', () => {
  let component: ModalInscriptionReussiteComponent;
  let fixture: ComponentFixture<ModalInscriptionReussiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalInscriptionReussiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalInscriptionReussiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
