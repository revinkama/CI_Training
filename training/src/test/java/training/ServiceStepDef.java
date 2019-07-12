package training;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepoImpl;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceStepDef {

	private WalletServiceImpl wallServ;
	private Customer cust;
	private String name;
	private String pNum;
	private BigDecimal amount;
	
	
	@Given("^I want to create a wallet$")
	public void i_want_to_create_a_wallet() throws Exception {
	   wallServ = new WalletServiceImpl(new WalletRepoImpl());
	}
	

	@When("^I create account as \"([^\"]*)\", (\\d+), (\\d+)$")
	public void i_create_account_as(String Name, String Phone, BigDecimal Amount) throws Exception {
	    name = Name;
	    pNum = Phone;
	    amount = Amount;
	    cust = wallServ.createWallet(name, pNum, amount);
	    System.out.println("Is cust null ?"+(cust==null));
	}
	

	@Then("^I Should Get an account with details \"([^\"]*)\", (\\d+), (\\d+)$")
	public void i_Should_Get_an_account_with_details(String Name, String Phone, BigDecimal Amount) throws Exception {
	    assertThat(cust.getName()).isEqualTo(Name);
	    assertThat(cust.getPhoneNumber()).isEqualTo(Phone);
	    assertThat(cust.getWallet().getBalance()).isEqualTo(Amount);
	}
}
