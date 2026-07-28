# Douyin Downloader

Ứng dụng Android tải video, ảnh, album nhiều ảnh, live photo và audio từ Douyin. Chế độ Douyin dùng parser native dựa trên [`jiji262/douyin-downloader`](https://github.com/jiji262/douyin-downloader), không dùng yt-dlp làm fallback.

- Package: `com.yvii.douyindownloader`
- Mặc định lưu vào `Internal storage/DCIM/DouyinDownloader`
- Có thể chọn thư mục khác bằng Android Storage Access Framework
- Chế độ Video dùng yt-dlp; chế độ Extra dùng cobalt API

## Build

Yêu cầu JDK 17 và Android SDK 36.

```powershell
.\gradlew.bat :app:assembleDebug
```

APK debug nằm tại `app/build/outputs/apk/debug/app-debug.apk`.
