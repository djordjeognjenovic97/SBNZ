export class AccumulateFragrance {
  brandName: string;
  minPrice: number;
  maxPrice: number;
  avgPrice: number;

  constructor(
    brandName: string,
    minPrice: number,
    maxPrice: number,
    avgPrice: number) {
      this.brandName = brandName;
      this.minPrice = minPrice;
      this.maxPrice = maxPrice;
      this.avgPrice = avgPrice;
  }
}
