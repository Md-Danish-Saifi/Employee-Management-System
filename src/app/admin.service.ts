import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  public addEmp(emp)
  {
    return this.http.post("http://localhost:8080/add",emp,{responseType:"text" as "json"});
  }
  public Emp()
  {
    return this.http.get("http://localhost:8080/get");
  }
  public removeEmp(id)
  {
    return this.http.get("http://localhost:8080/delete/"+id);
  }

  public findEmp(name)
  {
    return this.http.get("http://localhost:8080/find/"+name);
  }
}
