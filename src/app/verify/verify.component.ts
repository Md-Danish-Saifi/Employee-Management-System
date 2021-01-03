import { AdminService } from './../admin.service';
import { ActivatedRoute, Router, Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit {

  token:any
  message:any

  constructor(private router:ActivatedRoute,private service:AdminService,private routing:Router) { }

  ngOnInit(): void {
    this.token = this.router.snapshot.queryParamMap.get('token');
    this.service.verifyEmail(this.token)
    .subscribe(res=>this.message=res)

    setTimeout(() => {
      this.routing.navigate(["home"])
    }
    , 5000);


}
}
