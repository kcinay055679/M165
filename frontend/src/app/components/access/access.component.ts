import { Component } from '@angular/core';
import {ApiService} from "../../services/api.service";
import {ShopChain} from "../../dto/ShopChain";
import {MatDialog} from "@angular/material/dialog";
import {EditModalComponent} from "../edit-modal/edit-modal.component";

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.scss']
})
export class AccessComponent {
  shopChains: ShopChain[] = [];

  constructor(private api: ApiService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.getShopChains();
  }

  getShopChains() {
    this.api.getShopChains().subscribe((data) => {
      this.shopChains = data;
    });
  }

  deleteShopChain(id: string) {
    this.api.deleteShoppingChain(id);
    this.shopChains = this.shopChains.filter((data) => data.id !== id);
  }

  openModal(id: string) {
    const editedChain = this.shopChains.filter((data) => data.id == id);
    const dialogRef = this.dialog.open(EditModalComponent, {
      data: editedChain,
      height: '800px',
      width: '800px',
    });

    dialogRef.afterClosed().subscribe((data) => {
      console.log(data);
    });
  }
}
