package org.example.proxypattern;

import java.util.HashMap;
import java.util.Map;

public class ProxyDownloader implements Downloader{

    private Map<String, Video> videos = new HashMap<String, Video>();
    private YoutubeDownloader youtubeDownloader = new YoutubeDownloader();

    @Override
    public Video download(String url) {

        if(videos.containsKey(url)) {
            return videos.get(url);
        }

        Video video = youtubeDownloader.download(url);
        videos.put(url, video);
        return video;
    }
}
