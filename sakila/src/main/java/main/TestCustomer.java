package main;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import controller.CustomerController;
import model.Country;
import model.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		CustomerController test = new CustomerController();
/*
		test.letturaCustomer();

		System.out.println("  ");

		test.trovaNome("Mary");

		System.out.println("   ");

		Customer mod = new Customer();
		mod.setCustomer_id(56);
		mod.setFirst_name("Giovanna");
		test.modificaNome(mod);

		System.out.println(" ");
		Customer inser = new Customer();
		inser.setCustomer_id(600);
		inser.setStore_id(2);
		inser.setFirst_name("Michela");
		inser.setLast_name("Morgi");
		inser.setEmail("mic@hotmail.it");
		inser.setAddress_id(606);
		inser.setCreate_date("2020-06-24 18:32:45");
		inser.setLast_update("2020-06-24 18:32:45");
		List<Customer> cust = new ArrayList<Customer>();
		cust.add(inser);
		test.insert(cust);

		System.out.println("  ");

		test.trovaDaId(600);

		System.out.println("   ");
		test.tutteInfoCustomer();

		System.out.println("  ");
		test.tutteInfoCustomer2("Angola");
*/
		
		 System.out.println("   ");
		
		 Customer canc =new Customer(); 
		 canc.setCustomer_id(600); 
		 test.cancella(canc);
		

	}

}
