package question005;

import java.util.Date;

public interface UrlShortener {
	
	/**
     * 设置产生短链接长度
     * @param length
     * @return
     */
    void setLength(int length);
 
    /**
     * 返回短链接长度
     * @return
     */
    int getLength();
 
    /**
     * 返回指定地址对应的短链接
     * @param url
     * @return
     */
    String get(String url);
 
    /**
     * 存储对应关系
     * @param url
     * @param shortUrl
     */
    void put(String url, String shortUrl);
    /**
     * 到库里查看是不是存在映射，如果不存在返回null
     * @param shortUrl
     * @return
     */
    String seek(String shortUrl);
 
    /**
     * 据地址产生短地址
     * @param url
     * @return
     */
    String generate(String url);
 
    /**
     * 根据地址和种子产生一个短地址
     * @param url
     * @param seed
     * @return
     */
    String generate(String url, int seed);
    /**
     * 清除指定URL的短链接信息
     * @param url
     */
    void clean(String url);
 
    /**
     * 清除指定时间以前没有使用的所有短链接
     * @param date
     */
    void clean(Date date);

}
