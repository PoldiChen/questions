package question010;

import java.util.Date;

public interface UrlShortener {
	
	/**
     * ���ò��������ӳ���
     * @param length
     * @return
     */
    void setLength(int length);
 
    /**
     * ���ض����ӳ���
     * @return
     */
    int getLength();
 
    /**
     * ����ָ����ַ��Ӧ�Ķ�����
     * @param url
     * @return
     */
    String get(String url);
 
    /**
     * �洢��Ӧ��ϵ
     * @param url
     * @param shortUrl
     */
    void put(String url, String shortUrl);
    /**
     * ������鿴�ǲ��Ǵ���ӳ�䣬��������ڷ���null
     * @param shortUrl
     * @return
     */
    String seek(String shortUrl);
 
    /**
     * �ݵ�ַ�����̵�ַ
     * @param url
     * @return
     */
    String generate(String url);
 
    /**
     * ���ݵ�ַ�����Ӳ���һ���̵�ַ
     * @param url
     * @param seed
     * @return
     */
    String generate(String url, int seed);
    /**
     * ���ָ��URL�Ķ�������Ϣ
     * @param url
     */
    void clean(String url);
 
    /**
     * ���ָ��ʱ����ǰû��ʹ�õ����ж�����
     * @param date
     */
    void clean(Date date);

}
