package com.demowebshop.generic;

public class WaitNlp{
	public void wait_for_second(int time_in_second) {
		try {
			Thread.sleep(time_in_second*1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
