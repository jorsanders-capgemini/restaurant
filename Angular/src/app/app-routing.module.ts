import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { HttpClientModule } from '@angular/common/http';
import { DishesComponent } from './dishes/dishes.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'ingredients', component: IngredientsComponent},
  {path: 'dishes', component: DishesComponent},
];

@NgModule({
  imports: [
      RouterModule.forRoot(routes),
      HttpClientModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
