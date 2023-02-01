import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Album} from "../../model/album/album";

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  constructor(private _httpClient: HttpClient) {
  }

  getAllAlbum(pageNumber: number, nameAlbum:string): Observable<any> {
    return this._httpClient.get('http://localhost:8080/api/v1/music'+'?name='+nameAlbum+'&page=' + pageNumber);
  }
}
