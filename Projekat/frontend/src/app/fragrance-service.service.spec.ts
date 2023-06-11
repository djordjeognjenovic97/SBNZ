import { TestBed } from '@angular/core/testing';

import { FragranceServiceService } from './fragrance-service.service';

describe('FragranceServiceService', () => {
  let service: FragranceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FragranceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
