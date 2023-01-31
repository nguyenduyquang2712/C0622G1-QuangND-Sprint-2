import { Component, OnInit } from '@angular/core';
import {AlbumService} from "../../../service/album/album.service";
import {Album} from "../../../model/album/album";

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  albums: Album ;
  constructor(private _albumService: AlbumService) { }

  ngOnInit(): void {
    this._albumService.getAllAlbum().subscribe(data=>{
    this.albums = data;
    console.log(data)
  })
  }

}
