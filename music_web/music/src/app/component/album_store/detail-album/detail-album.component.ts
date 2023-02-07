import { Component, OnInit } from '@angular/core';
import {Album} from "../../../model/album/album";
import {AlbumService} from "../../../service/album/album.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {User} from "../../../model/user/user";
import {TokenService} from "../../../service/security/token.service";

@Component({
  selector: 'app-detail-album',
  templateUrl: './detail-album.component.html',
  styleUrls: ['./detail-album.component.css']
})
export class DetailAlbumComponent implements OnInit {
  currentUser: User;
  album: Album;
  constructor(private _tokenService: TokenService,
              private _albumService: AlbumService,
              private _activatedRoute: ActivatedRoute,
              private _route: Router) { }

  ngOnInit(): void {

    this._activatedRoute.params.subscribe((param:Params)=>{
      this._albumService.getAlbumById(param['id']).subscribe(data=>{
        this.album = data;
        console.log(this.album)
      })
    })
  }

  addToCart(id: number, amount:number) {
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
      this._albumService.addAlbumToCart(id,amount,this.currentUser.id).subscribe(data=>{
        console.log(data)
      })
    }
    else{
      this._route.navigateByUrl('/login')
    }

  }
}
