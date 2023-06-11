import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FragranceServiceService } from '../fragrance-service.service';
import { Fragrance } from '../model/fragrance';
import { FragranceQuery } from '../model/fragranceQuery';
import { PersonQuery } from '../model/personQuery';
import { Query } from '../model/query';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  fragrances = new Array<Fragrance>();

  brandNameFormControl = new FormControl('');
  ageFormControl = new FormControl('');
  previousCostFormControl = new FormControl('');
  selectOccasion = 'PARTY';
  selectGender = 'MALE';
  selectFamily = 'WOODY';
  selectSeason = 'WINTER';
  constructor(
    private fragranceService: FragranceServiceService
  ) { }

  ngOnInit(): void {
  }

  search(): void {
    let personQuery = new PersonQuery(this.ageFormControl.value, this.selectOccasion, this.selectGender);
    let fragranceQuery = new FragranceQuery(this.brandNameFormControl.value, this.selectFamily, this.selectSeason, this.previousCostFormControl.value);
    let q = new Query(personQuery, fragranceQuery);
    console.log(q);
    this.fragranceService.search(q).subscribe(
      result => {
        console.log(result);
        this.fragrances = result;
      }
    )
  }

}
