# Douyin Downloader

Android app for downloading video, image and live photo from Douyin (Tiktok China). This app is based on [`jiji262/douyin-downloader`](https://github.com/jiji262/douyin-downloader).

[Vietnamese README](https://github.com/phucdt1234/Douyin-Downloader/blob/main/README_vn.md)

Main feature:
- Download video/image/live photo from Douyin
- Download video or others from other sources (Tiktok, XHS, Facebook,...) using [yt-dlp](https://github.com/yt-dlp/yt-dlp) and [cobalt](https://github.com/imputnet/cobalt)
  + Note: for Cobalt you will need to add your own cobalt instances and API key
## Build

Required JDK 17 and Android SDK 36.

```powershell
.\gradlew.bat :app:assembleDebug
```


