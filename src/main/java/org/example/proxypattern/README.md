# Proxy Pattern

## What is the Proxy Pattern?

The **Proxy Pattern** is a structural design pattern where a **proxy object acts as a substitute or representative for another object**.

Instead of the client directly communicating with the real object, it communicates with the proxy.

The proxy can then:

* Control access to the real object
* Add extra functionality
* Cache results
* Perform logging
* Handle security checks
* Delay expensive operations

---

# Real-World Scenario: YouTube Video Downloader

Imagine an application that downloads YouTube videos.

Downloading a video can be an expensive operation because it requires:

1. Connecting to YouTube
2. Downloading the video
3. Processing the video

If the same video is requested multiple times, downloading it again would be unnecessary.

Instead, we can introduce a **Proxy Downloader** that acts as a cache.

```text
Client
  ↓
ProxyDownloader
  ↓
Is video already downloaded?
  ↓
 ┌───────────────┐
 │               │
Yes             No
 │               │
 ↓               ↓
Return       YoutubeDownloader
cached           ↓
video         Download
                  ↓
             Save in cache
```

---

# 1. Video Class

The `Video` class represents the downloaded video.

```java
public class Video {

    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
```

---

# 2. Downloader Interface

The interface defines what the client expects from a downloader.

```java
public interface Downloader {

    Video download(String url);
}
```

Both the real downloader and the proxy will implement this interface.

---

# 3. Real Object — YouTubeDownloader

`YoutubeDownloader` performs the actual expensive operation.

```java
public class YoutubeDownloader implements Downloader {

    @Override
    public Video download(String url) {

        System.out.println("Downloading video from YouTube...");

        return new Video("YouTube Video");
    }
}
```

This is the **real object** that the proxy represents.

---

# 4. Proxy — ProxyDownloader

The `ProxyDownloader` implements the same interface as the real downloader.

It maintains a cache of previously downloaded videos.

```java
import java.util.HashMap;
import java.util.Map;

public class ProxyDownloader implements Downloader {

    private YoutubeDownloader youtubeDownloader;
    private Map<String, Video> cache = new HashMap<>();

    public ProxyDownloader() {
        youtubeDownloader = new YoutubeDownloader();
    }

    @Override
    public Video download(String url) {

        if (cache.containsKey(url)) {

            System.out.println("Returning video from cache...");

            return cache.get(url);
        }

        Video video = youtubeDownloader.download(url);

        cache.put(url, video);

        return video;
    }
}
```

The proxy checks the cache before contacting the real downloader.

---

# 5. Main Class

The client communicates with the **Proxy**, not directly with `YoutubeDownloader`.

```java
public class Main {

    public static void main(String[] args) {

        Downloader downloader = new ProxyDownloader();

        Video video1 = downloader.download(
            "https://youtube.com/video1"
        );

        Video video2 = downloader.download(
            "https://youtube.com/video1"
        );
    }
}
```

Output:

```text
Downloading video from YouTube...
Returning video from cache...
```

The first request downloads the video.

The second request doesn't download it again because the proxy already has it in its cache.

---

# How It Works

The structure looks like this:

```text
              Downloader
              Interface
                 ↑
        ┌────────┴────────┐
        │                 │
        │                 │
YoutubeDownloader   ProxyDownloader
    (Real Object)       (Proxy)
                            │
                            ↓
                         Cache
                            │
                            ↓
                    YoutubeDownloader
```

The client only knows about the `Downloader` interface:

```java
Downloader downloader = new ProxyDownloader();
```

It doesn't need to know whether it is communicating directly with the real downloader or with the proxy.

---

# Why Use a Proxy Here?

Without a proxy:

```text
Client
  ↓
YoutubeDownloader
  ↓
Download
```

Every request causes a new download.

With the proxy:

```text
Client
  ↓
ProxyDownloader
  ↓
Check Cache
  ↓
 ┌─────────────┐
 │             │
Found        Not Found
 │             │
 ↓             ↓
Return      Download
Cache       from YouTube
              ↓
           Save Cache
```

This prevents unnecessary downloads and improves performance.

---

# Key Idea

> **A Proxy provides a controlled way to access another object while keeping the same interface.**

In this example:

* `Downloader` → Common interface
* `YoutubeDownloader` → Real object
* `ProxyDownloader` → Proxy
* `Map<String, Video>` → Cache
* `Main` → Client

The important part is that the **client doesn't need to know about the proxy's internal caching logic**.

---

# Proxy vs Flyweight

The two patterns can look similar because both can involve sharing or reusing objects, but their purposes are different.

### Proxy

> **Controls access to another object.**

In this example, the proxy controls access to `YoutubeDownloader` and adds caching.

### Flyweight

> **Reduces memory usage by sharing common state between many objects.**

For example, multiple `Tree` objects share the same `TreeType`.

So remember:

```text
Proxy     → Controls access / adds behavior
Flyweight → Shares common state / saves memory
```
