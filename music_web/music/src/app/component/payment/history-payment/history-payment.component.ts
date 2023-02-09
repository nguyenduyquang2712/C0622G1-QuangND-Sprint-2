import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../../service/security/token.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PaymentService} from "../../../service/payment/payment.service";
import { User } from 'src/app/model/user/user';

@Component({
  selector: 'app-history-payment',
  templateUrl: './history-payment.component.html',
  styleUrls: ['./history-payment.component.css']
})
export class HistoryPaymentComponent implements OnInit {
  paidpayment: any;
  currentUser: User;
  constructor(private _tokenService: TokenService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute,
              private _paymentService: PaymentService) { }

  ngOnInit(): void {
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
    }
    this._paymentService.getAllPaidPaymentByUserId(this.currentUser.id).subscribe(data=>{
      this.paidpayment = data;
    })
  }

}
