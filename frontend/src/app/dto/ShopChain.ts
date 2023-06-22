import {Shop} from "./Shop";
import {Person} from "./Person";

export class ShopChain {
  name: string;
  shops: Shop[];
  owner: Person;

  constructor(name: string, shops: Shop[], owner: Person) {
    this.name = name;
    this.shops = shops;
    this.owner = owner;
  }
}
