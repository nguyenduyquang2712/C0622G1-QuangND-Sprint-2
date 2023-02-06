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
  getAlbumById(id:number): Observable<Album>{
    return this._httpClient.get<Album>('http://localhost:8080/api/v1/music/'+id);
  }
  getOrderAlbumByUserID(userId: number): Observable<any>{
    return this._httpClient.get('http://localhost:8080/api/v1/music/orderAlbum/'+userId);
  }

  test(paramElement: number):Observable<void> {
    return this._httpClient.get<void>('http://localhost:8080/api/v1/music/add/'+paramElement)

  }

  addAlbumToCart(id: number, userId: number): Observable<void> {
    return this._httpClient.get<void>('http://localhost:8080/api/v1/music/add/?id='+id+'&userId='+userId);
  }
}
