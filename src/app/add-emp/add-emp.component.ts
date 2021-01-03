import { Employee } from './../Employee';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {



  constructor(private service:AdminService) { }
  message:any
  emp  = new Employee("",0,"","","",0);
  ngOnInit(): void {
  }

   public register()
  {
    this.service.addEmp(this.emp)
    .subscribe(res=>this.message=res)
  }

}
