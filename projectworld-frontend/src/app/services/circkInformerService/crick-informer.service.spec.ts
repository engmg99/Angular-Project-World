import { TestBed } from '@angular/core/testing';

import { CrickInformerService } from './crick-informer.service';

describe('CrickInformerService', () => {
  let service: CrickInformerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrickInformerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
