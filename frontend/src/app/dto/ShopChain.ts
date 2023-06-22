import {Shop} from "./Shop";
import {Person} from "./Person";

export class ShopChain {
  id: string;
  name: string;
  shops: Shop[];
  owner: Person;

  constructor(name: string, shops: Shop[], owner: Person, id: string) {
    this.name = name;
    this.shops = shops;
    this.owner = owner;
    this.id = id;
  }
}
