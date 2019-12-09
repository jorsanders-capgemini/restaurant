import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';

@Component({
  selector: 'app-dishes-add',
  templateUrl: './dishes-add.component.html',
  styleUrls: ['./dishes-add.component.css']
})
export class DishesAddComponent implements OnInit {
  dishForm: FormGroup;
  constructor() {}
  ngOnInit() {
    this.dishForm = new FormGroup({
      description: new FormControl(''),
      sellingPrice: new FormControl(''),
      ingredients: new FormGroup({
        ingredient1: new FormControl(''),
        ingredient2: new FormControl(''),
        ingredient3: new FormControl(''),
        ingredient4: new FormControl(''),
        ingredient5: new FormControl('')
      }),
      margin: new FormControl(''),
      available: new FormControl('')
    });
  }
  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.dishForm.value);
    this.dishForm.reset();
  }
}
