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


  //Get Requests
  getShopChains() {
    return this.http.get<ShopChain[]>("http://localhost:8080/chains");
  }

  //Delete Requests
  deleteShoppingChain(id: string) {
    this.http.delete("http://localhost:8080/chains/" + id).subscribe(() => {});
  }

  //Put Requests
  putShoppingChain(id: string, shoppingChain: ShopChain) {
    return this.http.put("http://localhost:8080/chains/" + id, shoppingChain);
  }
}
