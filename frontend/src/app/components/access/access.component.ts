import { Component } from '@angular/core';
import {ApiService} from "../../services/api.service";
import {ShopChain} from "../../dto/ShopChain";

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.scss']
})
export class AccessComponent {
  shopChains: ShopChain[] = [];

  constructor(private api: ApiService) {
  }

  ngOnInit() {
    this.getShopChains();
  }

  getShopChains() {
    this.api.getShopChains().subscribe((data) => {
      this.shopChains = data;
    });
  }

}
