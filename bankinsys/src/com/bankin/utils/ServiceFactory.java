package com.bankin.utils;

public class ServiceFactory {
	
	public static Service buildService(int serviceFlag){
		//Flags: 1 for check balance;
		//		 2 for internal transfer;
		//		 3 for external transfer;
		//		 4 for Pretransferchecker;
		Service sv;
		if(serviceFlag == 1){
			sv = new CheckBalance();
		}else if(serviceFlag == 2){
			sv = new InternalTransfer();
		}else if(serviceFlag == 3){
			sv = new ExternalTransfer();
		}else if(serviceFlag == 4){
			sv = new PretransferChecker2();
		}
		else{
			sv = null;
		}
		return  sv;
	}

}
