import { TestBed } from '@angular/core/testing';

import { HardcodedAuthentificationService } from './hardcoded-authentification.service';

describe('HardcodedAuthentificationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HardcodedAuthentificationService = TestBed.get(HardcodedAuthentificationService);
    expect(service).toBeTruthy();
  });
});
