import { Component } from '@angular/core';
import {ApiService} from "./services/api.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';

  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
    this.apiService.getShopChains().subscribe((data) => {
      console.log(data);
    })
  }
}
