package com.testproject;

import org.testng.annotations.Test;

/*
 Test to search a product and share to self account in amazon.in
 Author: Simon Nicholas */


	public class ShareProductNew {
		
		LoginShare loginShare = new LoginShare();
		
		@Test
		public void ShareProuctList() throws Exception{			
			
			loginShare.login();
			loginShare.Share("Bose");
			
		   }

	}
	
	

