import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{

  customers :any;
  constructor(private http:HttpClient) {
  }

  ngOnInit(): void {
      this.http.get("http://192.168.100.198:8083/CUSTOMER-SERVICE/customers")
      .subscribe({
        next: data=>{
          this.customers=data;
        },
        error: err=>{
          console.log(err);
        }
      })

  }

}
