import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-find-emp',
  templateUrl: './find-emp.component.html',
  styleUrls: ['./find-emp.component.css']
})
export class FindEmpComponent implements OnInit {

  name:String
  employee:any

  constructor(private service:AdminService) { }

  ngOnInit(): void {
  }
  public search()
  {
    this.service.findEmp(this.name).subscribe(res=>this.employee=res)
  }
}
