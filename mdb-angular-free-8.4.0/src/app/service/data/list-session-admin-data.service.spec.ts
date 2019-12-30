import { TestBed } from '@angular/core/testing';

import { ListSessionAdminDataService } from './list-session-admin-data.service';

describe('ListSessionAdminDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListSessionAdminDataService = TestBed.get(ListSessionAdminDataService);
    expect(service).toBeTruthy();
  });
});
