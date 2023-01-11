import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home/home.component";
import {AlbumComponent} from "./component/album_store/album/album.component";
import {PaymentCartComponent} from "./component/album_store/payment-cart/payment-cart.component";
import {LoginComponent} from "./component/login/login/login.component";


const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'album',component:AlbumComponent
  },
  {
    path:'payment',component:PaymentCartComponent
  },
  {
    path:'login', component:LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ scrollPositionRestoration: "enabled" })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
