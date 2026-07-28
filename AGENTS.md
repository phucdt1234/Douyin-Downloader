# AGENTS.md

## Mục đích repository

Repository này chứa ứng dụng Android `Douyin Downloader`, package `com.yvii.douyindownloader`. Project được khôi phục từ APK cũ rồi tiếp tục phát triển bằng Kotlin và Jetpack Compose.

Mục tiêu chính:

- Phân tích link Douyin và tải video, ảnh, album nhiều ảnh, live photo và audio.
- Giữ riêng backend Douyin native dựa trên logic của `jiji262/douyin-downloader`.
- Cho phép tải video từ website khác bằng yt-dlp trong chế độ Video.
- Cho phép dùng cobalt API trong chế độ Extra.
- Lưu media vào thư mục mà Android Gallery nhận diện được.

## Nguồn code đang hoạt động

Gradle chỉ biên dịch các thư mục sau:

- `app/src/main/kotlin-clean/com/yvii/douyindownloader/`
- `app/src/main/res-clean/`
- `app/src/main/AndroidManifest.xml`

Các thư mục sau là mã và resource decompile từ APK cũ, chỉ dùng làm tài liệu tham khảo:

- `app/src/main/java/`
- `app/src/main/res/`

Không sửa mã decompile rồi kỳ vọng ứng dụng thay đổi. Nếu cần khôi phục hành vi cũ, đọc thư mục decompile để tham khảo, sau đó port thay đổi tối thiểu sang `kotlin-clean` hoặc `res-clean`.

## Vai trò các file chính

- `app/src/main/kotlin-clean/com/yvii/douyindownloader/MainActivity.kt`: UI Compose, nhận link share hoặc deep link, chọn mode, analyze, chọn media và cấu hình thư mục lưu.
- `app/src/main/kotlin-clean/com/yvii/douyindownloader/DownloaderCore.kt`: model, settings, điều phối analyze và download, yt-dlp, cobalt, HTTP download, chuyển định dạng ảnh và tách audio.
- `app/src/main/kotlin-clean/com/yvii/douyindownloader/JijiDouyinBackend.kt`: resolve link Douyin, lấy aweme payload, ký X-Bogus, parse video, gallery, live photo và music.
- `app/src/main/kotlin-clean/com/yvii/douyindownloader/Storage.kt`: lưu bằng MediaStore, SAF hoặc legacy storage.
- `app/build.gradle`: source set đang hoạt động, Android config và dependency.

## Bất biến bắt buộc

### Package và UI

- Giữ `namespace` và `applicationId` là `com.yvii.douyindownloader` trừ khi người dùng yêu cầu đổi rõ ràng.
- Giữ UI hiện tại. Không viết lại hoặc thay phong cách UI chỉ để sửa backend.
- Mọi thay đổi UI phải giữ khả năng nhận text share và link HTTP hoặc HTTPS từ intent.
- Không xóa mode Video hoặc Extra khi chỉ sửa mode Douyin.

### Backend Douyin

- Mode Douyin phải dùng parser native trong `JijiDouyinBackend.kt`.
- Không chuyển link Douyin sang yt-dlp hoặc cobalt để làm fallback.
- Logic backend phải bám theo hành vi hiện hành của `jiji262/douyin-downloader`; đây là bản port Kotlin, không phải dependency runtime.
- Trước khi ký URL, luôn loại bỏ chữ ký `X-Bogus` và `a_bogus` cũ rồi tạo chữ ký mới.
- Duy trì danh sách URL mirror theo thứ tự ưu tiên; một mirror lỗi phải thử mirror tiếp theo.
- File tải về có kích thước `0 B` là lỗi. Không lưu file rỗng vào MediaStore hoặc SAF.
- Không coi một bài một ảnh là live photo chỉ dựa trên số lượng ảnh. Cần tín hiệu payload hoặc heuristic đã được kiểm chứng.
- Live photo phải được biểu diễn thành cặp ảnh tĩnh và motion video. Khi người dùng chọn một live photo, tải cả hai phần nếu URL hợp lệ.
- Nếu payload chỉ trả audio-only MP4 trong `video.play_addr`, không được gắn nhãn file đó là motion video.
- Album phải giữ đủ ảnh, thứ tự ảnh, URL mirror và lựa chọn từng ảnh.
- Audio Douyin ưu tiên URL audio trực tiếp. Nếu chỉ có video chứa audio, tải video vào cache rồi tách track bằng Android `MediaExtractor` và `MediaMuxer` thành M4A.
- Không dùng yt-dlp cho fallback audio Douyin.
- Cookies là tùy chọn. Không ghi cookies, token hoặc header nhạy cảm vào log, source, fixture hay commit.
- Douyin có thể trả payload rỗng hoặc thay đổi schema. Parser phải fail với thông báo rõ ràng, không crash bằng null ngoài ý muốn.

### Storage

- Thư mục mặc định là `DCIM/DouyinDownloader` trên bộ nhớ trong.
- Android 10 trở lên lưu qua MediaStore để Gallery nhận diện file.
- Thư mục tùy chỉnh dùng `ACTION_OPEN_DOCUMENT_TREE` và persist quyền URI.
- Khi ghi thất bại, xóa MediaStore row, SAF document hoặc file tạm chưa hoàn chỉnh.
- Không thêm `MANAGE_EXTERNAL_STORAGE`.
- Không thêm lại quyền đọc storage diện rộng nếu không có yêu cầu chức năng cụ thể.
- `WRITE_EXTERNAL_STORAGE` chỉ được giữ với `maxSdkVersion="28"` cho Android cũ.
- Audio vẫn lưu dưới `DCIM/DouyinDownloader` theo yêu cầu sản phẩm hiện tại.

### Mode Video và Extra

- Mode Video mới được dùng yt-dlp và FFmpeg.
- Mode Extra dùng cobalt API theo settings hiện tại.
- Không trộn settings, cookies hoặc progress state giữa các mode.
- Không cập nhật yt-dlp khi đang xử lý mode Douyin.

## Nguyên tắc sửa code

- Ưu tiên diff nhỏ nhất giải quyết đúng nguyên nhân.
- Không thêm abstraction, dependency, service hoặc module khi chưa cần.
- Dùng API Android hoặc Kotlin hiện có trước khi thêm thư viện.
- Không sửa thư mục decompile nếu thay đổi có thể thực hiện trong source đang hoạt động.
- Không commit APK, AAB, build output, cache Gradle, `.idea`, `local.properties`, log build hoặc signing key.
- Không commit dữ liệu Douyin thật nếu chứa cookies, token, device ID hoặc thông tin cá nhân.
- Giữ file text ở UTF-8. Sau khi sửa tiếng Việt hoặc tiếng Trung, kiểm tra không xuất hiện mojibake hoặc ký tự thay thế `U+FFFD`.
- Không đổi dependency hàng loạt trong một thay đổi backend không liên quan.
- Không sửa warning lint ngoài phạm vi nếu warning đó không chặn chức năng đang làm.

## Kiểm tra theo loại thay đổi

Khi sửa parser Douyin, kiểm tra tối thiểu:

- Video thường có một hoặc nhiều bitrate.
- Bài ảnh một ảnh.
- Album nhiều ảnh, gồm trường hợp số lượng lớn.
- Live photo có cờ `is_live_photo` rõ ràng.
- Live photo legacy không có cờ nhưng có payload motion hợp lệ.
- Payload có URL đã chứa `X-Bogus` hoặc `a_bogus`.
- Link music hoặc audio trực tiếp.
- Audio fallback tách từ video.
- Mirror đầu lỗi nhưng mirror sau hoạt động.
- HTTP thành công nhưng body rỗng.
- Title tiếng Trung đúng UTF-8 và title bị mojibake có thể được sửa an toàn.

Khi sửa storage, kiểm tra tối thiểu:

- MediaStore mặc định tạo file dưới `DCIM/DouyinDownloader`.
- Gallery nhận diện ảnh và video mới.
- SAF lưu được vào folder do người dùng chọn.
- Quyền SAF vẫn còn sau khi mở lại ứng dụng.
- File lỗi hoặc bị hủy không để lại file `0 B`.

Khi sửa UI, kiểm tra tối thiểu:

- Paste link và analyze.
- Nhận link từ Android share sheet.
- Nhận deep link HTTP hoặc HTTPS.
- Chuyển mode không giữ kết quả analyze sai mode.
- Chọn hoặc bỏ chọn ảnh và live photo.
- Mở settings, chọn folder và reset về folder mặc định.

## Lệnh build và kiểm tra

Chạy từ root repository bằng PowerShell:

```powershell
.\gradlew.bat :app:lintDebug :app:assembleDebug :app:assembleRelease
```

Cài debug APK lên thiết bị Vivo hoặc iQOO đang kết nối:

```powershell
adb install --no-streaming -r -d app\build\outputs\apk\debug\app-debug.apk
```

Một số thiết bị Vivo yêu cầu xác nhận popup cài đặt trên điện thoại. Kết quả hợp lệ của ADB là `Success`.

Nếu sửa parser, giữ và chạy self-check nhỏ trong `verifyParserContract()` hoặc một test tương đương. Test phải bao phủ dữ liệu video, gallery, live photo và URL ký lại.

## Điều kiện hoàn thành

Một thay đổi chỉ hoàn thành khi:

- Build phần bị ảnh hưởng thành công.
- Không có secret hoặc file sinh tự động trong `git status`.
- Chức năng Douyin liên quan được kiểm tra bằng payload đại diện.
- File tải thử có kích thước lớn hơn `0 B` và đúng MIME type.
- UI vẫn mở được, không crash và package vẫn là `com.yvii.douyindownloader`.
- Tài liệu được cập nhật nếu kiến trúc, mode, storage hoặc lệnh build thay đổi.
