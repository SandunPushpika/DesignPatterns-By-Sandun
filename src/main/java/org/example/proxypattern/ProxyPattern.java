package org.example.proxypattern;

public class ProxyPattern {
    public static void main(String[] args) {
        Downloader downloader = new ProxyDownloader();

        Video v = downloader.download("http://www.baidu.com");
        System.out.println(v.getTitle());
        System.out.println();

        Video v2 = downloader.download("http://www.baidu.com");
        System.out.println(v2.getTitle());
        System.out.println();

        Video v3 = downloader.download("http://www.baidu.coms");
        System.out.println(v3.getTitle());
    }
}
