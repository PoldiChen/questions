package question052;

public final class Contacts { // 类用final修饰
	  
    private final String name; // 所有成员都用final修饰
    private final String mobile;  
      
    public Contacts(String name, String mobile) {  
        this.name = name;  
        this.mobile = mobile;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public String getMobile() {  
        return mobile;  
    }
    
} 
