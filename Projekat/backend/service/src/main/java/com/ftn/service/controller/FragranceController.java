package com.ftn.service.controller;

import java.util.ArrayList;
import java.util.List;

import com.ftn.model.Fragrance;
import com.ftn.service.dto.AccumulateFragranceDTO;
import com.ftn.service.dto.FragranceDTO;
import com.ftn.service.dto.QueryDTO;
import com.ftn.service.mapper.FragranceDTOMapper;
import com.ftn.service.services.FragranceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FragranceController {
    @Autowired
    private FragranceService fragranceService;

    private FragranceDTOMapper fragranceDTOMapper;

    public FragranceController() {
        fragranceDTOMapper = new FragranceDTOMapper();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FragranceDTO>> getAllFragrances(){
        List<Fragrance> fragrances = fragranceService.findAll();

        return new ResponseEntity<>(toFragranceDTOList(fragrances), HttpStatus.OK);
    }

    private List<FragranceDTO> toFragranceDTOList(List<Fragrance> fragrances){
        List<FragranceDTO> fragranceDTOs = new ArrayList<>();
        for (Fragrance fragrance : fragrances){
            fragranceDTOs.add(fragranceDTOMapper.toDto(fragrance));
        }
        return fragranceDTOs;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bestFrags", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<FragranceDTO>> bestFrags(@RequestBody QueryDTO queryDTO) {
        List<Fragrance> frags = fragranceService.queryFragrances(queryDTO);

        return new ResponseEntity<>(toFragranceDTOList(frags), HttpStatus.OK);
    }

    @GetMapping("brandStats/{brandName}")
    private ResponseEntity<AccumulateFragranceDTO> getBrandStats(@PathVariable(value = "brandName") String brandName) {
        AccumulateFragranceDTO accumulateFragranceDTO = fragranceService.getStats(brandName);
        return new ResponseEntity<>(accumulateFragranceDTO, HttpStatus.OK);
    }
}
