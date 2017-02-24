package algorithm.search.facade.impl;

public abstract class BaseFacadeImpl {
	protected boolean checkParam() {
		return true;
	}
	
	public  boolean checkBusiness() {
		checkParam();
		return true;
	}

}
