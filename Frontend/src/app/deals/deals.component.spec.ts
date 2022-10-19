import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealsComponent } from './deals.component';

describe('DealsComponent', () => {
  let component: DealsComponent;
  let fixture: ComponentFixture<DealsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      declarations: [ DealsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {


    fixture = TestBed.createComponent(DealsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
});
