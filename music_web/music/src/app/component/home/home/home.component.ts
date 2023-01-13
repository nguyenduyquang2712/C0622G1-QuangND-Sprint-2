import { Component, OnInit } from '@angular/core';
import {Album} from "../../../model/album/album";
import {AlbumService} from "../../../service/album/album.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  albums: Album ;
  constructor(private _albumService: AlbumService) { }

  ngOnInit(): void {
    this._albumService.getAllAlbum().subscribe(data=>{
      this.albums = data[0];
      console.log(data[0])
    })
  }

}
