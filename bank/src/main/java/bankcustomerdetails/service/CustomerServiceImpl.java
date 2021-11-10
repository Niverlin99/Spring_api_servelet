package bankcustomerdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankcustomerdetails.bean.Customer;
import bankcustomerdetails.dao.CustomerDao;
import bankcustomerdetails.errordetails.ErrorMessage;
import bankcustomerdetails.errordetails.Message;

@Service("customerservice")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getCustomer() {
		List<Customer> customer = customerDao.getCustomer();
		return customer;
	}

	public Customer getIndividulaCustomer(Long id) {
		Customer customer = customerDao.getIndividulaCustomer(id);
		/*
		 * if (customer == null) { // ErrorMessage errorMessage = new
		 * ErrorMessage("No Record Found123"); // return
		 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage); // return new
		 * ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND); throw new
		 * Message("hi", "hi", "hi"); }
		 */
		return customer;
	}

	public int deleteCustomer(Long id) {
		return customerDao.deleteCustomer(id);
	}

	public int createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

}
