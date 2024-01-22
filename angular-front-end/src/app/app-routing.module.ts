import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {AccountsComponent} from "./accounts/accounts.component";
import {CustomerComponent} from "./customer/customer.component";

const routes: Routes = [
  { path :"customer" , component:CustomerComponent},
  { path :"accounts" , component:AccountsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
