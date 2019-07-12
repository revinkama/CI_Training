package ci.training.repo;

import ci.training.beans.Customer;

public interface WalletRepo {

	public Customer save(Customer c);
	public Customer find(String phoneNumber);


}
