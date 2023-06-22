import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ShopChain} from "../dto/ShopChain";
import {Shop} from "../dto/Shop";
import {Person} from "../dto/Person";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  getShopChains() {
    return this.http.get<ShopChain>("http://localhost:8080/chains");
  }

  getShop() {
    return this.http.get<Shop>("http://localhost:8080/shops");
  }

  getPersons() {
    return this.http.get<Person>("http://localhost:8080/persons");
  }

  getGroceryItem() {
    return this.http.get<Person>("http://localhost:8080/items");
  }
}
