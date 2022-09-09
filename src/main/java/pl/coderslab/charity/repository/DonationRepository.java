package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {

    @Query("SELECT SUM(quantity) FROM Donation")
    Optional<Integer> sumQuantity();

    @Query("SELECT COUNT(Id) FROM Donation")
    Optional<Integer> sumDonation();
}
