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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AlbumComponent,
    DetailAlbumComponent,
    PaymentCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
