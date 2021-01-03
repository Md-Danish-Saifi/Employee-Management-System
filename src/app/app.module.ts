import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { RemoveEmpComponent } from './remove-emp/remove-emp.component';
import { FindEmpComponent } from './find-emp/find-emp.component';
import { FormsModule } from '@angular/forms';
HttpClientModule
FormsModule

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddEmpComponent,
    RemoveEmpComponent,
    FindEmpComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
