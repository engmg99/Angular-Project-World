import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchPointTableComponent } from './match-point-table.component';

describe('MatchPointTableComponent', () => {
  let component: MatchPointTableComponent;
  let fixture: ComponentFixture<MatchPointTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchPointTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchPointTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
