package bankcustomerdetails.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bankcustomerdetails.bean.Customer;
import bankcustomerdetails.errordetails.ErrorMessage;
import bankcustomerdetails.errordetails.Message;
import bankcustomerdetails.service.CustomerService;

/*@RestController annotation in order to simplify the creation of RESTful web services. 
It's a convenient annotation that combines @Controller and @ResponseBody,
*/

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	// GET ALL CUSTOMER DETAILS

	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Customer>> getCustomer() {

		HttpHeaders headers = new HttpHeaders();
		List<Customer> customer = customerservice.getCustomer();

		if (customer == null) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}

		headers.add("Number Of Records Found", String.valueOf(customer.size()));
		return new ResponseEntity<List<Customer>>(customer, headers, HttpStatus.OK);
	}

	// GET INDIVIDUAL CUSTOMER DETAILS

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getIndividulaCustomer(@PathVariable("id") Long id) {

		Customer customer = customerservice.getIndividulaCustomer(id);
		if (customer == null) {
			Message message = new Message("Record Not Found", "404", "Update soon");

			return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// DELETE CUSTOMER DETAILS

	@RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		Customer customer = customerservice.getIndividulaCustomer(id);
		if (customer == null) {
			Message message = new Message("Record Not Found", "404", "Update soon");

			return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
			// return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerservice.deleteCustomer(id);
		headers.add("Customer Deleted - ", String.valueOf(id));

		Message message = new Message("Record " + id + " Deleted Successfully", "200", "Update soon");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
		// return new ResponseEntity<Customer>(customer, headers,
		// HttpStatus.NO_CONTENT);
	}

	// ADD NEW CUSTOMER DETAILS

	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
		HttpHeaders headers = new HttpHeaders();
		if (customer == null) {
			Message message = new Message("Bad Request", "400", "Update soon");

			return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
			// return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		customerservice.createCustomer(customer);
		headers.add("Customer Created  - ", String.valueOf(customer.getId()));
		return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
	}

	// UPDATE CUSTOMER DETIALS

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody Customer customer) {
		HttpHeaders headers = new HttpHeaders();
		Customer isExist = customerservice.getIndividulaCustomer(id);
		if (isExist == null) {
			Message message = new Message("Record Not Found", "404", "Update soon");

			return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);

			// return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		} else if (customer == null) {

			Message message = new Message("Bad Request", "400", "Update soon");

			return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
			// return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		customerservice.updateCustomer(customer);
		headers.add("Employee Updated  - ", String.valueOf(id));
		return new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
	}

}
