package question016;

/**
 * 目标类，实现了代理接口
 * @author Administrator
 *
 */
public class RealTarget implements ProxyInter {

	@Override
	public void action() {
		System.out.println("call the real function");
	}

}
