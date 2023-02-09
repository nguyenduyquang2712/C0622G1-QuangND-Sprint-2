import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../../service/security/token.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {User} from "../../../model/user/user";
import {AlbumService} from "../../../service/album/album.service";
// import { render } from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-payment-cart',
  templateUrl: './payment-cart.component.html',
  styleUrls: ['./payment-cart.component.css']
})
export class PaymentCartComponent implements OnInit {
  currentUser: User;
  checkCart: boolean;
  currentPaymentID: number;
  subtotal: number=0;
  orderAlbum: any[];
  tax: number=0;
  total: number=23;
  constructor(private _tokenService: TokenService,
              private _router: Router,
              private _albumService: AlbumService,
              private _activatedRoute: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.checkCart=true;
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
    }
      this._albumService.getOrderAlbumByUserID(this.currentUser.id).subscribe(data=>{
        if(data.length!=0) {
          this.orderAlbum = data;
          this.currentPaymentID = data[0].payment.id;
          console.log(this.currentPaymentID)
          console.log(data);
          this.subtotal = 0;
          for (let i = 0; i < data.length; i++) {
            this.subtotal += data[i].quantity * data[i].album.price;
          }
          this.tax = (this.subtotal / 100) * 5
          this.total = (this.subtotal + this.tax + 49000);
          console.log(this.subtotal)
        } else{
          this.checkCart=false;
        this.total=0;
          }
      })

  }


  subOrderAlbum(albumId: number, quantity: number, orderAlbumId: number) {
    if(quantity>1){
      this._albumService.addAlbumToCart(albumId,-1,this.currentUser.id).subscribe(data=>{
        console.log("success")
        this.ngOnInit();
      })

    }
    else{
      this._albumService.removeOrderAlbum(orderAlbumId).subscribe(data=>{
        console.log("success")
        this.ngOnInit()
      })
    }
  }

  addOrderAlbum(albumId: number, quantity: number) {
    this._albumService.addAlbumToCart(albumId,1, this.currentUser.id).subscribe(data=>{
      console.log("success");
      this.ngOnInit();
    })


  }

  removeOrderAlbum(id: number) {
    this._albumService.removeOrderAlbum(id).subscribe(data=>{
      console.log("success");
      this.ngOnInit();
    })

  }
}
