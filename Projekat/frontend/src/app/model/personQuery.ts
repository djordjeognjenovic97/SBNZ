export class PersonQuery {
  age: number;
  occasion: string;
  gender: string;

  constructor(age: number, occasion: string, gender: string) {
    this.age = age;
    this.occasion = occasion;
    this.gender = gender;
  }
}
