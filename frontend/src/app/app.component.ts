import { Component } from '@angular/core';
import {ApiService} from "./services/api.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';

  constructor(private router: Router) {
  }

  navigateToAccess() {
    this.router.navigate(["/access"]);
  }
}
