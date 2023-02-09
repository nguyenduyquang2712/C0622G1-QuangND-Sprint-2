import {Component, OnInit} from '@angular/core';
import {render} from "creditcardpayments/creditCardPayments";
import {User} from "../../../model/user/user";
import {TokenService} from "../../../service/security/token.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {AlbumService} from "../../../service/album/album.service";
import {PaymentService} from "../../../service/payment/payment.service";
import {PaymentDto} from "../../../model/payment/payment-dto";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  currentUser: User;
  clickCheckPaypal: number = 0;
  currentPaymentId: number;
  subtotal: number;
  total: number;

  constructor(private _tokenService: TokenService,
              private _router: Router,
              private _albumService: AlbumService,
              private _activatedRoute: ActivatedRoute,
              private _paymentService: PaymentService) {
  }

  ngOnInit(): void {
    this.clickCheckPaypal = 0;
    this.total = 0;
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
    }
    this._activatedRoute.params.subscribe((param: Params) => {
      this.currentPaymentId = param["id"];
    })
    this._albumService.getOrderAlbumByUserID(this.currentUser.id).subscribe(data => {
      for (let i = 0; i < data.length; i++) {
        this.total += data[i].quantity * data[i].album.price
      }
      this.subtotal = this.total - 49000;
      console.log(this.total)
    })
  }

  renderPaypal() {
    if (this.clickCheckPaypal == 0) {
      render(
        {
          id: "#myPaypalButtons",
          currency: "USD",
          value: JSON.parse(JSON.stringify((this.total / 23000).toFixed(2))),
          onApprove: (details) => {
            let date= new Date().toJSON().slice(0, 10);
            this._paymentService.updatePayment(this.currentPaymentId, this.total, date).subscribe(data=>{
              console.log("success");
              this._router.navigateByUrl("")
            })

          }
        }
      )
    }
    this.clickCheckPaypal = 1;
  }
}
