package question010;

public class PreparedStatementTest {
	
	public static void main(String[] args) {
		String name = "chen"; // chen#'  #后面的内容被注释掉
		String password = "123456"; // ' or '1'='1
		String sql = "select * from users where name = '"+name+"' and password = '"+password+"'";
		System.out.println(sql);
	}

}
