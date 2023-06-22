export class Person {
  firstName: string;
  lastName: string;
  employmentLvl: number;
  male: boolean;

  constructor(firstName: string, lastName: string, employmentLvl: number, male: boolean) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.employmentLvl = employmentLvl;
    this.male = male;
  }

}
