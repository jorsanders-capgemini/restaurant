import { Component, OnInit } from '@angular/core';
// import { FormControl } from '@angular/forms';
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
  constructor() {}
  name = new FormControl('');
  dishForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    address: new FormGroup({
      street: new FormControl(''),
      city: new FormControl(''),
      state: new FormControl(''),
      zip: new FormControl('')
    })
  });
  // profileForm = this.fb.group({
  //   firstName: [''],
  //   lastName: [''],
  //   address: this.fb.group({
  //     street: [''],
  //     city: [''],
  //     state: [''],
  //     zip: ['']
  //   })
  // });
  //  constructor(private fb: FormBuilder) {}

  // dishForm = new FormGroup({
  //   firstName: new FormControl(''),
  //   lastName: new FormControl('')
  // });
  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.dishForm.value);
  }
  ngOnInit() {}
  updateName() {
    this.name.setValue('Nancy');
  }
  updateProfile() {
    this.dishForm.patchValue({
      firstName: 'Nancy',
      address: {
        street: '123 Drew Street'
      }
    });
  }
}
