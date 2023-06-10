import { FragranceQuery } from './fragranceQuery';
import { PersonQuery } from './personQuery';

export class Query {
  personQuery: PersonQuery;
  fragranceQuery: FragranceQuery;

  constructor(personQuery: PersonQuery, fragranceQuery: FragranceQuery) {
      this.personQuery = personQuery;
      this.fragranceQuery = fragranceQuery;
    }
}
