export class Fragrance {
  id:number;
  fname:string;
  gender:string;
  longevity:string;
  projection:string;
  concentration:string;
  designer:string;
  family:string;
  price:number;
  score:number;

 constructor(id:number,
  fname:string,
  gender:string,
  longevity:string,
  projection:string,
  concentration:string,
  designer:string,
  family:string,
  price:number,
  score:number) {
    this.id = id;
    this.fname = fname;
    this.gender = gender;
    this.longevity = longevity;
    this.projection = projection;
    this.concentration = concentration;
    this.designer = designer;
    this.family = family;
    this.price = price;
    this.score = score;
 }

}
