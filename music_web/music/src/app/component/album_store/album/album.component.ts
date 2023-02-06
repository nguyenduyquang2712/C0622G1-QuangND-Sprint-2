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
  nameAlbum: string='';
  pageData: any;
  constructor(private _albumService: AlbumService) { }

  ngOnInit(): void {
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
}
