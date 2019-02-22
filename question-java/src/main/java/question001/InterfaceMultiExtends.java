package question001;

/**
 * 接口多继承
 * @author Administrator
 *
 */
public class InterfaceMultiExtends {
	
	public static void main(String[] args) {
		//
	}
}

interface InterA {}

interface InterB {}

interface InterC extends InterA, InterB {} // 接口C可以同时继承接口A和接口B
