import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { HttpClientModule } from '@angular/common/http';
import { DishesComponent } from './dishes/dishes.component';
import { DishesAddComponent } from './dishes-add/dishes-add.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'ingredients', component: IngredientsComponent },
  { path: 'dishes', component: DishesComponent },
  { path: 'dishes-add', component: DishesAddComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule],
  exports: [RouterModule]
})
export class AppRoutingModule {}
