import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { NewsapiserviceService } from './newsapiservice.service';

describe('NewsapiserviceService', () => {
  let service: NewsapiserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule,RouterTestingModule]
    });
    service = TestBed.inject(NewsapiserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
