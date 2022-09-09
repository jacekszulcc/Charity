package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Optional;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public int sumAllQuantity(){
        Optional<Integer> sumQuantity = donationRepository.sumQuantity();
        return sumQuantity.orElse(0);
    }

    public int sumAllDonation(){
        Optional<Integer> sumDonation = donationRepository.sumDonation();
        return sumDonation.orElse(0);
    }

}
