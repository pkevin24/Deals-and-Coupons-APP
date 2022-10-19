import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

import { DemologinComponent } from './demologin.component';

describe('DemologinComponent', () => {
  let component: DemologinComponent;
  let fixture: ComponentFixture<DemologinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[HttpClientTestingModule, RouterTestingModule,FormsModule],
      declarations: [ DemologinComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemologinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
