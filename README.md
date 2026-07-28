# Douyin Downloader

Ứng dụng Android tải video, ảnh, album nhiều ảnh, live photo và audio từ Douyin. Downloader này dựa trên [`jiji262/douyin-downloader`](https://github.com/jiji262/douyin-downloader).


Chức năng chính:
- Tải video/image/live photo từ Douyin
- Tải video từ các nguồn khác bằng [yt-dlp](https://github.com/yt-dlp/yt-dlp) và [cobalt](https://github.com/imputnet/cobalt)

## Build

Yêu cầu JDK 17 và Android SDK 36.

```powershell
.\gradlew.bat :app:assembleDebug
```

APK debug nằm tại `app/build/outputs/apk/debug/app-debug.apk`.
