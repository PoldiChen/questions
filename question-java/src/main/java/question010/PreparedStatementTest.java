package question010;

public class PreparedStatementTest {
	
	public static void main(String[] args) {
		String name = "chen"; // chen#'  #��������ݱ�ע�͵�
		String password = "123456"; // ' or '1'='1
		String sql = "select * from users where name = '"+name+"' and password = '"+password+"'";
		System.out.println(sql);
	}

}
