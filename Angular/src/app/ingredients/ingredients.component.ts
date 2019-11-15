import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.css']
})
export class IngredientsComponent implements OnInit {

  ingredients = []

  constructor(private dataService: DataService){}

  ngOnInit() {
    this.dataService.sendGetRequest('ingredients').subscribe((data: any[])=>{
      this.ingredients = data;
    })
  }

}
