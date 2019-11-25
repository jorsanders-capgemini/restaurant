import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngrDishListComponent } from './ingr-dish-list.component';

describe('IngrDishListComponent', () => {
  let component: IngrDishListComponent;
  let fixture: ComponentFixture<IngrDishListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngrDishListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngrDishListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
