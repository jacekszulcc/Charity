package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public int sumAllQuantity(){
        if (donationRepository.sumQuantity() != null){
            return donationRepository.sumQuantity();
        }
        else { return 0; }
    }

    public int sumAllDonation(){
        if (donationRepository.sumDonation() != null){
            return donationRepository.sumDonation();
        }
        else { return 0; }
    }

}
