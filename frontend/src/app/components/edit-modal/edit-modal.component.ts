import { Component } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {ShopChain} from "../../dto/ShopChain";

@Component({
  selector: 'app-edit-modal',
  templateUrl: './edit-modal.component.html',
  styleUrls: ['./edit-modal.component.scss']
})
export class EditModalComponent {
  constructor(public dialogRef: MatDialogRef<ShopChain>) {
  }

  closeDialogData() {
    this.dialogRef.close("Moin");
  }

  closeDialogCancel() {
    this.dialogRef.close();
  }
}
