package com.ypp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ypp.model.BillingDetails;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Long> {

	Optional<BillingDetails> findById(Long id);
	//void deleteById(Long id);

}
