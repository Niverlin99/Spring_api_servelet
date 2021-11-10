package bankcustomerdetails.dao;

import java.util.List;

import bankcustomerdetails.bean.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomer();

	public Customer getIndividulaCustomer(Long id);

	public int deleteCustomer(Long id);

	public int createCustomer(Customer customer);

	public int updateCustomer(Customer customer);

}
