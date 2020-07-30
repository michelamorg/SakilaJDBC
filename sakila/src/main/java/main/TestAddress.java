package main;

import java.util.ArrayList;
import java.util.List;

import controller.AddressController;
import model.Address;
import model.Customer;

public class TestAddress {

	public static void main(String[] args) {
		AddressController test = new AddressController();
		/*
		test.letturaAddress();

		System.out.println("  ");

		test.trovaByNome("28 MySQL Boulevard");

		System.out.println("   ");

		Address mod = new Address();
		mod.setAddress("via elevata 13bis");
		mod.setAddress_id(30);
		test.modificaAddress(mod);

		System.out.println("  ");

		Address inser = new Address();
		inser.setAddress_id(606);
		inser.setAddress("Paolo");
		inser.setAddress2(null);
		inser.setDistrict("paper");
		inser.setCity_id(601);
		inser.setPostal_code("113");
		inser.setPhone("9786876");
		List<Address> addr = new ArrayList<Address>();
		addr.add(inser);
		test.inserAddress(addr);

		System.out.println(" ");

		test.trovaById(606);

		System.out.println("   ");

		test.joinAddress();

		*/
		
		 System.out.println("  ");
		
		 Address canc=new Address(); 
		 canc.setAddress_id(606);
		 test.cancellaAddress(canc);
		 
		

	}

}
