import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhototequeComponent } from './phototeque.component';

describe('PhototequeComponent', () => {
  let component: PhototequeComponent;
  let fixture: ComponentFixture<PhototequeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhototequeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhototequeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
