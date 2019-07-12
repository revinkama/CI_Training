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
		// TODO Auto-generated method stu
		customers.add(cust);
		return cust;
	}
	
	

	@Override
	public Customer find(String phoneNo) {
		// TODO Auto-generated method stub
		for(Customer c: customers) {
			if(c.getPhoneNumber() == phoneNo) {
				return c;
			}
		}
		return null;
	}
}
