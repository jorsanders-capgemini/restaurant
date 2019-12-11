import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private RESTAURANT_API_SERVER = 'http://localhost:8080/api';

  constructor(private httpClient: HttpClient) {}

  public sendGetRequest(endpoint) {
    return this.httpClient.get(this.RESTAURANT_API_SERVER + '/' + endpoint);
  }

  public saveNewDish(endpoint, descriptionForm) {
    console.log('saving dish');

    const request = {
      description: descriptionForm
    };

    console.log(request);

    const body = JSON.stringify(request);

    console.log(body);

    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const options = { headers };

    console.log('sending..');
    return this.httpClient.put(this.RESTAURANT_API_SERVER + '/' + endpoint, body, options);
  }
}
