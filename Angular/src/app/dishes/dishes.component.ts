import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-dishes',
  templateUrl: './dishes.component.html',
  styleUrls: ['./dishes.component.css']
})
export class DishesComponent implements OnInit {
  dishes = [];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.sendGetRequest('dishes').subscribe((data: any[]) => {
      this.dishes = data;
    });
  }
}
