import { FindEmpComponent } from './find-emp/find-emp.component';
import { RemoveEmpComponent } from './remove-emp/remove-emp.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes =
[
  {pathMatch:"full",path:"",redirectTo:"home"},
  {path: 'home', component: HomeComponent },
  {path:'add',component:AddEmpComponent},
  {path:'remove',component:RemoveEmpComponent},
  {path:'find',component:FindEmpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
