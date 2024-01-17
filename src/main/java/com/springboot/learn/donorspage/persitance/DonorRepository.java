package com.springboot.learn.donorspage.persitance;

import com.springboot.learn.donorspage.persitance.modal.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Integer> {
}
