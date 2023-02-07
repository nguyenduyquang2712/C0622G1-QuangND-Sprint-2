import { Component, OnInit } from '@angular/core';
import {AlbumService} from "../../../service/album/album.service";
import {Album} from "../../../model/album/album";
import {User} from "../../../model/user/user";
import {TokenService} from "../../../service/security/token.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  currentUser: User;
  amountAlbum: number;
  albums: Album[] ;
  nameAlbum: string='';
  pageData: any;
  constructor(private _tokenService: TokenService,
              private _albumService: AlbumService,
              private _route: Router) { }

  ngOnInit(): void {
    this.amountAlbum=1;
    this._albumService.getAllAlbum(0,this.nameAlbum).subscribe(data=>{
    this.albums = data.content;
    this.pageData= data;
      console.log(data.content)
  })
  }



  goToPage(i: number) {
    this._albumService.getAllAlbum(i,this.nameAlbum).subscribe(
      data => {
        this.albums = data.content;
        this.pageData= data;
        console.log(data.content)
      });
  }

  findAlbum(value: string) {
    this.nameAlbum=value;
    this.ngOnInit()
  }

  subQuantity() {
    if(this.amountAlbum>1){
      this.amountAlbum--
    }
    else {
      this.amountAlbum=1;
    }
  }

  plusQuantity() {
    this.amountAlbum++
  }

  resetQuantity() {
    this.amountAlbum=1;
  }

  addAlbum(id: number,amountAlbum: number) {
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
      this._albumService.addAlbumToCart(id,amountAlbum,this.currentUser.id).subscribe(data=>{
        console.log("success")
      })
    }
    else{
      this._route.navigateByUrl('/login')
    }
  }
}
