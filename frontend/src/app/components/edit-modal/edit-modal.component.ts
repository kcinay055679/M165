import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ShopChain} from "../../dto/ShopChain";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-edit-modal',
  templateUrl: './edit-modal.component.html',
  styleUrls: ['./edit-modal.component.scss']
})
export class EditModalComponent {
   form: FormGroup = new FormGroup({
    json: new FormControl(JSON.stringify(this.data))
  })

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public dialogRef: MatDialogRef<ShopChain>) {

  }

  closeDialogData() {
    let shopChain = JSON.parse(this.form.get("json")?.value)[0];
    this.dialogRef.close(shopChain);
  }

  closeDialogCancel() {
    this.dialogRef.close(null);
  }
}
