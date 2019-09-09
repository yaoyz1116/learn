package control.impl;

import nfcapi.DemoService;

public class DemoServiceImpl implements DemoService{
	
	private int count = 1;

	@Override
	public String helloDubbo() {
		return "time:"+System.currentTimeMillis()+";  count:"+count;
	}

}
