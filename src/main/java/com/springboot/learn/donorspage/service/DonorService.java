package com.springboot.learn.donorspage.service;

import com.springboot.learn.donorspage.exception.DonorNotFoundException;
import com.springboot.learn.donorspage.persitance.DonorRepository;
import com.springboot.learn.donorspage.persitance.modal.Donor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DonorService {

    private DonorRepository donorRepository;

    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    public Donor findDonorById(int id) {

        Optional<Donor> searchResult = donorRepository.findById(id);

        Donor donor = null;

        if (searchResult.isPresent()) {
            donor = searchResult.get();
        } else {
            throw new DonorNotFoundException("Did not find donor by id - " + id);
        }

        return donor;
    }

    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public void deleteDonorById(int id) {
        donorRepository.deleteById(id);
    }
}
