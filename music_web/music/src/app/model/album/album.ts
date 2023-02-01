import {Image} from "./image";

export interface Album {
  id?: number;
  title?:string;
  price?:number;
  genre?: string;
  description?:string;
  releaseDate?: string;
  instock_status?: number;
  deleteStatus?: number;
  images?: Image[];
  song?:any[];
  orderAlbums?:any[];
}
