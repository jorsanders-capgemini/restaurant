import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private RESTAURANT_API_SERVER = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest(endpoint){
    return this.httpClient.get(this.RESTAURANT_API_SERVER + '/' + endpoint);
  }
}
