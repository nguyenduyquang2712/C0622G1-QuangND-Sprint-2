import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private _httpClient: HttpClient) { }


  updatePayment(currentPaymentId: number, total: number, date: string):Observable<void> {
    return this._httpClient.get<void>('http://localhost:8080/api/v1/music/payment/update?paymentId='+currentPaymentId+'&total='+total+'&date='+date);
  }

  getAllPaidPaymentByUserId(id: number): Observable<any> {
    return this._httpClient.get('http://localhost:8080/api/v1/music/payment/paid/'+id);
  }
}
