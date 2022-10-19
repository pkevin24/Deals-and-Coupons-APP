import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { DealserviceService } from './dealservice.service';

describe('DealserviceService', () => {
  let service: DealserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule]
    });
    service = TestBed.inject(DealserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
