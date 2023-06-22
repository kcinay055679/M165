import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Output() open: EventEmitter<any> = new EventEmitter<any>();

  toggle() {
    this.open.emit(null);
  }

}
