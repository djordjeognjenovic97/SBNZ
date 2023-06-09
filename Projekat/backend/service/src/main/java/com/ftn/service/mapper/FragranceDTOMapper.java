package com.ftn.service.mapper;

import com.ftn.model.Fragrance;
import com.ftn.service.dto.FragranceDTO;

public class FragranceDTOMapper {
    public FragranceDTO toDto(Fragrance entity) {
        return new FragranceDTO(entity.getId(), entity.getName(), entity.getGender(), entity.getLongevity(), entity.getProjection(), entity.getConcentration(), entity.getDesigner(), entity.getFamily(), entity.getPrice(), entity.getScore());
    }
}
