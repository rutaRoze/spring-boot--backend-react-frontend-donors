package com.springboot.learn.donorspage.controller;

import com.springboot.learn.donorspage.exception.DonorNotFoundException;
import com.springboot.learn.donorspage.persitance.modal.Donor;
import com.springboot.learn.donorspage.service.DonorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/donors")
@AllArgsConstructor
@CrossOrigin("*")
public class DonorController {

    private DonorService donorService;

    @GetMapping("/list")
    public List<Donor> findAll() {
        return donorService.findAll();
    }

    @GetMapping
    public Donor findDonorById(
            @RequestParam @Min(1) int donorId
    ) {
        return donorService.findDonorById(donorId);
    }

    @PostMapping
    public Donor addDonor(
            @RequestBody @Valid Donor donor
    ) {
        donor.setId(0);
        Donor donorDB = donorService.saveDonor(donor);

        log.debug("To Donors table was added new donor {}", donorDB);

        return donorDB;
    }

    @DeleteMapping
    public String deleteDonor(
            @RequestParam @Min(1) int donorId
    ) {

        Donor donor = donorService.findDonorById(donorId);

        if (donor == null) {
            throw new DonorNotFoundException("Did not find donor by id - " + donorId);
        }

        donorService.deleteDonorById(donorId);

        return "Deleted donor by id - " + donorId;
    }


}
