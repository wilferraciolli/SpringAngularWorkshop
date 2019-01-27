import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OportunityService {

  apiUrl = 'http://localhost:8080/api/oportunities';

  constructor(private httpClient: HttpClient) { }

  findAll() {
    return this.httpClient.get(this.apiUrl);
  }

  create(oportunidade: any) {
    return this.httpClient.post(this.apiUrl, oportunidade);
  }


}
