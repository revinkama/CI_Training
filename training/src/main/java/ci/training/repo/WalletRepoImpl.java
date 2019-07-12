package ci.training.repo;

import java.util.HashSet;
import java.util.Set;

import ci.training.beans.Customer;

public class WalletRepoImpl implements WalletRepo{

	private Set<Customer> customers = new HashSet<Customer>();
	
	public WalletRepoImpl() {
		super();
	}
	
	public WalletRepoImpl(HashSet<Customer> cust) {
		super();
		this.customers = cust;
	}
	
	
	@Override
	public Customer save(Customer cust) {
		customers.add(cust);
		return cust;
	}
	
	

	@Override
	public Customer find(String phoneNo) {
		// TODO Auto-generated method stub
		for(Customer c: customers) {
			if(c.getPhoneNumber().equals(phoneNo)) {
				return c;
			}
		}
		return null;
	}
}
