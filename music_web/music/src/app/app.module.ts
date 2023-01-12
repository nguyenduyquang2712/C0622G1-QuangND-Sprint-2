import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home/home.component';
import { HeaderComponent } from './component/home/header/header.component';
import { FooterComponent } from './component/home/footer/footer.component';
import { AlbumComponent } from './component/album_store/album/album.component';
import { DetailAlbumComponent } from './component/album_store/detail-album/detail-album.component';
import { PaymentCartComponent } from './component/album_store/payment-cart/payment-cart.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './component/login/login/login.component';
import {HttpClientModule} from "@angular/common/http";
import { UserComponent } from './component/user/user/user.component';
import { PlayListComponent } from './component/user/play-list/play-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AlbumComponent,
    DetailAlbumComponent,
    PaymentCartComponent,
    LoginComponent,
    UserComponent,
    PlayListComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
