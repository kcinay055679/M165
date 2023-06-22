import {GroceryItem} from "./GroceryItem";
import {Person} from "./Person";

export class Shop {
  name: string;
  groceryItems: GroceryItem[];
  employees: Person[];
  id: string;

  constructor(name: string, groceryItems: GroceryItem[], employess: Person[], id: string) {
    this.name = name;
    this.groceryItems = groceryItems;
    this.employees = employess;
    this.id = id;
  }

}
