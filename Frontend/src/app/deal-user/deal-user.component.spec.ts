import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { DealUserComponent } from './deal-user.component';

describe('DealUserComponent', () => {
  let component: DealUserComponent;
  let fixture: ComponentFixture<DealUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule,RouterTestingModule],
      declarations: [ DealUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DealUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
