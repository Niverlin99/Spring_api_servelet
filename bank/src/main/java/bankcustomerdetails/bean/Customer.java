package bankcustomerdetails.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Size(min=1,max=5, message="id should not be empty")
	@NotNull
	private Long id;
	@Size(min=1,max=4, message="invalid name")
	private String name;
	private String account_number;
	private String mobile_number;
	private String account_type;
	private String account_status;
	
	
	
	@JsonCreator
	public Customer(@JsonProperty("id") Long id,@JsonProperty("name") String name,@JsonProperty("account_number") String account_number,@JsonProperty("mobile_number") String mobile_number,@JsonProperty("account_type") String account_type,
			@JsonProperty("account_status") String account_status) {
		super();
		this.id = id;
		this.name = name;
		this.account_number = account_number;
		this.mobile_number = mobile_number;
		this.account_type = account_type;
		this.account_status = account_status;
	}
	
	public Customer() {
		
	}

	
	//Getter &  Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}


	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Id:- " +getId());
		str.append("name:- " +getName());
		str.append("account_number:- " +getAccount_number());
		str.append("mobile_number:- " +getMobile_number());
		str.append("account_type:- " +getAccount_type());   
		str.append("account_status:- " +getAccount_status());
		return str.toString();
	}
	
}
