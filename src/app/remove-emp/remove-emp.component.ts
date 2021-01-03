import { AdminService } from './../admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-remove-emp',
  templateUrl: './remove-emp.component.html',
  styleUrls: ['./remove-emp.component.css']
})
export class RemoveEmpComponent implements OnInit {

  emp:any
  constructor(private service:AdminService) { }

  ngOnInit(){this.service.Emp().subscribe(res=>this.emp=res)
  }

  public remove(id)
  {
    this.service.removeEmp(id).subscribe(res=>this.emp=res)
    alert("Employee "+id+" Removed Successfully")
  }

}
