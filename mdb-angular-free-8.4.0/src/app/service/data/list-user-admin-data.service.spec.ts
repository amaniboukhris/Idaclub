import { TestBed } from '@angular/core/testing';

import { ListUserAdminDataService } from './list-user-admin-data.service';

describe('ListUserAdminDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListUserAdminDataService = TestBed.get(ListUserAdminDataService);
    expect(service).toBeTruthy();
  });
});
