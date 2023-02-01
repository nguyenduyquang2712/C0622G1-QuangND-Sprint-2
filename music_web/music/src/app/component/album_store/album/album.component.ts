import { Component, OnInit } from '@angular/core';
import {AlbumService} from "../../../service/album/album.service";
import {Album} from "../../../model/album/album";

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  albums: Album[] ;
  pageData: any;
  constructor(private _albumService: AlbumService) { }

  ngOnInit(): void {
    this._albumService.getAllAlbum(0).subscribe(data=>{
    this.albums = data.content;
    this.pageData= data;
    console.log(data.totalPages)
  })
  }



  goToPage(i: number) {
    this._albumService.getAllAlbum(i).subscribe(
      data => {
        this.albums = data.content;
        this.pageData= data;
        console.log(data.content)
      });
  }
}
