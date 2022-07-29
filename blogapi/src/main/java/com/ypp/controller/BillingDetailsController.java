package com.ypp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ypp.model.BillingDetails;
import com.ypp.repository.BillingDetailsRepository;

@RestController
@RequestMapping("/api/bill")
public class BillingDetailsController {
	
	@Autowired
	private BillingDetailsRepository billingDetailsRepository;	

	@PostMapping("/add")
	public BillingDetails createBillingDetails(@RequestBody BillingDetails billingDetails) {
	
    return billingDetailsRepository.save(billingDetails);
       
}
	
		@PutMapping("/{id}")
		public BillingDetails updateBillingDetails(@PathVariable Long id, @RequestBody BillingDetails billingDetails) {
		
//	     return billingDetailsRepository.findById(id);
		 
		  return billingDetailsRepository.findById(id).map(billingDetail -> {
//			  billingDetail.setCreatedAt(billingDetails.getCreatedAt());
//			  billingDetail.setCreatedBy(billingDetails.getCreatedBy());
//			  billingDetail.setUpdatedAt(billingDetails.getUpdatedAt());
//			  billingDetail.setUpdatedBy(billingDetails.getUpdatedBy());
			  billingDetail.setCountry(billingDetails.getCountry());
			  billingDetail.setState(billingDetails.getState());
			  billingDetail.setCity(billingDetails.getCity());
			  billingDetail.setStreet(billingDetails.getStreet());
			  billingDetail.setZipcode(billingDetails.getZipcode());
			  billingDetail.setEmali(billingDetails.getEmali());
			  billingDetail.setNameoncard(billingDetails.getNameoncard());
			  billingDetail.setCardnumber(billingDetails.getCardnumber());
			  billingDetail.setExpirationdate(billingDetails.getExpirationdate());
		        return billingDetailsRepository.save(billingDetail);
		    }).orElseThrow();
}
	
		
		@GetMapping("/all")
		public List<BillingDetails> getBillingDetails() {
		
	    return billingDetailsRepository.findAll();
	      
		}
		
		@GetMapping("/all/{id}")
		public Optional<BillingDetails> getBillingDetailsById(@PathVariable Long id) {
		
	    return billingDetailsRepository.findById(id);
	      
		}
		
//		@DeleteMapping("/dele/{id}")
//		public ResponseEntity<BillingDetails> deleteBillingDetailsById(@PathVariable Long id) {
//			
//			BillingDetails billingDetails = billingDetailsRepository.deleteById(id);
//			return new ResponseEntity<>(billingDetails, HttpStatus.OK);
//		
//	   // return "User Billing details deleted successfully";
//	      
//		}
		
//		@DeleteMapping("/{username}")
//		public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "username") String username,
//				@CurrentUser UserPrincipal currentUser) {
//			ApiResponse apiResponse = userService.deleteUser(username, currentUser);
//
//			return new ResponseEntity< >(apiResponse, HttpStatus.OK);
//		
//		}

}
