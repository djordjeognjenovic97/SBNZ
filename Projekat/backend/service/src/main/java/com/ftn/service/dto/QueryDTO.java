package com.ftn.service.dto;

import com.ftn.model.FragranceQuery;
import com.ftn.model.PersonQuery;

public class QueryDTO {
    private PersonQuery personQuery;
    private FragranceQuery fragranceQuery;
    
    public QueryDTO() {
    }

    public QueryDTO(PersonQuery personQuery, FragranceQuery fragranceQuery) {
        this.personQuery = personQuery;
        this.fragranceQuery = fragranceQuery;
    }

    public PersonQuery getPersonQuery() {
        return personQuery;
    }

    public void setPersonQuery(PersonQuery personQuery) {
        this.personQuery = personQuery;
    }

    public FragranceQuery getFragranceQuery() {
        return fragranceQuery;
    }

    public void setFragranceQuery(FragranceQuery fragranceQuery) {
        this.fragranceQuery = fragranceQuery;
    }

    
}
