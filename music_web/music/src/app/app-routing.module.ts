import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./component/home/home/home.component";
import {AlbumComponent} from "./component/album_store/album/album.component";
import {PaymentCartComponent} from "./component/album_store/payment-cart/payment-cart.component";
import {LoginComponent} from "./component/login/login/login.component";
import {UserComponent} from "./component/user/user/user.component";
import {AdminGuard} from "./security/guard/admin.guard";
import {UserGuard} from "./security/guard/user.guard";
import {DetailAlbumComponent} from "./component/album_store/detail-album/detail-album.component";


const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'album',component:AlbumComponent
  },
  {
    path:'payment/:id',component:PaymentCartComponent, canActivate: [UserGuard]
  },
  {
    path:'login', component:LoginComponent
  },
  {
    path:'user', component:UserComponent, canActivate: [AdminGuard]
  },
  {
    path:'playlist', component:UserComponent, canActivate: [UserGuard]
  },
  {
    path:'detail/:id', component:DetailAlbumComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ scrollPositionRestoration: "enabled" })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
