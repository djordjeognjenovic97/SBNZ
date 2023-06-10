export class FragranceQuery {
  brand: string;
  family: string;
  season: string;
  previousCost: number;

  constructor(brand: string, family: string, season: string, previousCost: number) {
    this.brand = brand;
    this.family = family;
    this.season = season;
    this.previousCost = previousCost;
  }
}
