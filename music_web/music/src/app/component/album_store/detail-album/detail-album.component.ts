import { Component, OnInit } from '@angular/core';
import {Album} from "../../../model/album/album";
import {AlbumService} from "../../../service/album/album.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-detail-album',
  templateUrl: './detail-album.component.html',
  styleUrls: ['./detail-album.component.css']
})
export class DetailAlbumComponent implements OnInit {

  album: Album;
  constructor(private _albumService: AlbumService,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((param:Params)=>{
      this._albumService.getAlbumById(param['id']).subscribe(data=>{
        this.album = data;
        console.log(this.album)
      })
    })
  }

}
