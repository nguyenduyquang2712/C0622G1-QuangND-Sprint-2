import { Component, OnInit } from '@angular/core';
import {Album} from "../../../model/album/album";
import {AlbumService} from "../../../service/album/album.service";
import {ActivatedRoute, Params} from "@angular/router";
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
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    if (this._tokenService.isLogged()) {
      this.currentUser = JSON.parse(this._tokenService.getUser());
    }
    this._activatedRoute.params.subscribe((param:Params)=>{
      this._albumService.getAlbumById(param['id']).subscribe(data=>{
        this.album = data;
        console.log(this.album)
      })
    })
  }

  addToCart(id: number) {
    this._albumService.addAlbumToCart(id,this.currentUser.id).subscribe(data=>{
      console.log(data)
    })
  }
}
