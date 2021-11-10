package bankcustomerdetails.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bankcustomerdetails.bean.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public List<Customer> getCustomer() {

		List<Customer> customer = null;

		try {
			customer = jdbcTemplate.query("SELECT * FROM customer",
					new BeanPropertyRowMapper<Customer>(Customer.class));
		} catch (DataAccessException e) {
			e.printStackTrace();

		}
		return customer;
	}

	// GET INDIVIDUAL CUSTOMER DETAILS USING ID

	public Customer getIndividulaCustomer(Long id) {
		Customer customer = null;
		try {
			customer = jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id=?", new Object[] { id },
					new BeanPropertyRowMapper<Customer>(Customer.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public int deleteCustomer(Long id) {
		int count = jdbcTemplate.update("DELETE from customer WHERE id = ?", new Object[] { id });
		return count;
	}

	public int createCustomer(Customer customer) {
		int count = jdbcTemplate.update(
				"INSERT INTO customer(id,name, account_number,mobile_number,account_type,account_status)VALUES(?,?,?,?,?,?)",
				new Object[] { customer.getId(), customer.getName(), customer.getAccount_number(),
						customer.getMobile_number(), customer.getAccount_type(), customer.getAccount_status() });
		return count;
	}

	public int updateCustomer(Customer customer) {
		int count = jdbcTemplate.update(
				"UPDATE customer SET name=? , account_number=? , mobile_number=?, account_type=?, account_status=? WHERE id = ?",
				new Object[] { customer.getName(), customer.getAccount_number(), customer.getMobile_number(),
						customer.getAccount_type(), customer.getAccount_status(), customer.getId() });
		return count;
	}

}
