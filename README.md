# W_Start

面向 Android 10 及以上的独立微信入口。点击应用图标会直接打开当前用户下的官方微信（`com.tencent.mm`），不经过网页或应用页面，不需要联网权限。W_Start 不会替换微信原图标，也不依赖桌面快捷方式。

## 换成自己的图标

当前图标是浅奶油色底的橘猫。要换图，替换 `app/src/main/res/drawable-nodpi/ic_launcher_foreground.png`。建议用 432 × 432 像素的透明画布，把主体放在中央约 264 × 264 像素范围内，留出边距给系统裁切。背景色在 `app/src/main/res/values/colors.xml` 中设置。修改后重新构建、安装。

## 用 GitHub Actions 构建

1. 将整个项目提交到 GitHub 仓库根目录，包含隐藏的 `.github` 目录和 `gradle/wrapper/gradle-wrapper.jar`。
2. 推送后，在仓库 **Actions → Android debug build** 查看构建，也可点 **Run workflow** 手动触发。
3. 构建成功后，在该次运行的 **Artifacts** 下载 `W_Start-debug`，解压并安装 `app-debug.apk`。产物保留 14 天。

无需在本地安装 JDK 或 Android SDK。构建使用 GitHub runner 的调试签名，每次构建的签名可能不同。如果新包不能覆盖安装，先卸载 **W_Start** 再安装，不要卸载微信。
