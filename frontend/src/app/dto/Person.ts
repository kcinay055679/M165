export class Person {
  firstName: string;
  lastName: string;
  employmentLvl: number;
  isMale: boolean;

  constructor(firstName: string, lastName: string, employmentLvl: number, isMale: boolean) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.employmentLvl = employmentLvl;
    this.isMale = isMale;
  }

}
