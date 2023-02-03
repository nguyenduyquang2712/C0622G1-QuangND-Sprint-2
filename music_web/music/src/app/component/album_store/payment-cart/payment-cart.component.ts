import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../../service/security/token.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {User} from "../../../model/user/user";
import {AlbumService} from "../../../service/album/album.service";

@Component({
  selector: 'app-payment-cart',
  templateUrl: './payment-cart.component.html',
  styleUrls: ['./payment-cart.component.css']
})
export class PaymentCartComponent implements OnInit {
  currentUser: User;
  subtotal: number=0;
  orderAlbum: any[];
  constructor(private _tokenService: TokenService,
              private _router: Router,
              private _albumService: AlbumService,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
    }
      this._activatedRoute.params.subscribe((param:Params)=>{
        if(param["id"]!=''){
          this._albumService.test(param["id"]).subscribe(data=>{
            console.log(data)
          })
        }
      })
      this._albumService.getOrderAlbumByUserID(this.currentUser.id).subscribe(data=>{
        this.orderAlbum = data;
        for (let i = 0; i < data.length ; i++) {
          this.subtotal= data[i].quantity * data[i].album.price;
        }
        console.log(this.subtotal)
      })
  }

}
