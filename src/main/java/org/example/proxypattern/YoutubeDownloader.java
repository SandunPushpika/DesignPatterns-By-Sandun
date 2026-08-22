package org.example.proxypattern;

public class YoutubeDownloader implements Downloader {
    @Override
    public Video download(String url) {
        System.out.println("Downloading video....");
        return new Video(url);
    }
}
