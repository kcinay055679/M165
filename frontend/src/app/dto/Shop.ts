import {GroceryItem} from "./GroceryItem";
import {Person} from "./Person";

export class Shop {
  name: string;
  groceryItems: GroceryItem[];
  employees: Person[];

  constructor(name: string, groceryItems: GroceryItem[], employess: Person[]) {
    this.name = name;
    this.groceryItems = groceryItems;
    this.employees = employess;
  }

}
