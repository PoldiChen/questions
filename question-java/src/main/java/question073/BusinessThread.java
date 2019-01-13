package question092;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessThread implements Runnable {
	
	private static final String TIME_PATTERN = "yyyy/MM/dd HH:mm:ss";
	
	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
	
	@Override
	public void run() {
//		SimpleDateFormat sdf = getSdfNew();
//		SimpleDateFormat sdf = getSdfThreadLocal();
		SimpleDateFormat sdf = getSdfNotSafe();
		Date now = new Date();
		String time = sdf.format(now);
		System.out.println(time);
		String timestr = "2017/09/02 10:00:00";
		try {
			Date date = sdf.parse(timestr);
			System.out.println(date.toLocaleString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ��sdf����ThreadLocal�ֲ߳̾������У������ͻ
	private static SimpleDateFormat getSdfThreadLocal() {
		SimpleDateFormat sdf = threadLocal.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat(TIME_PATTERN);
			threadLocal.set(sdf);
		}
		return sdf;
	}
	
	// ֱ��ʹ�������sdf������̹߳������ͻ
	private static SimpleDateFormat getSdfNotSafe() {
		return sdf;
	}
	
	// ÿ�ζ�����newһ�����൱���̵߳ľֲ������������ͻ
	private static SimpleDateFormat getSdfNew() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf;
	}

}
