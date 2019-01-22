package question136;

public class Resource {
	
	public String userName = "aaa";
	public String password = "bbb";
	
	public synchronized void setResource(String userName, String password) {
		try {
			this.userName = userName;
			Thread.sleep(3000);
			this.password = password;
			System.out.println("setResource");
			System.out.println("thread:" + Thread.currentThread().getName());
			System.out.println("userName:" + userName);
			System.out.println("password:" + password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getResource() {
		System.out.println("getResource");
		System.out.println("userName:" + this.userName);
		System.out.println("password:" + this.password);
	}

}
