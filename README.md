# AndroidStudy
> Android系统学习的笔记!系统但并非详细！

# 参考视频
学习的主要来源[YouTube | https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull](https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull)

# 布局

## LinearLayout
## GridLayout

# Button,View等

Button 继承自 TextView
EditText 继承自 TextView​

## ImageView

### scaleType

| 值  |  含义  |
| :------------: | :------------: |
| fitXY  | 撑满控件，宽高比可能发生改变  |
| fitCenter  | 保持宽高缩放，直至能够完全显示  |
|centerCrop| 保持宽高比缩放，直至完全覆盖控件，剪裁显示|

### 网络图片 | 第三方库

## ListView | Grid View

> Adapter 写法

## ScrollView

> 只能有一个子元素

### 分类

- 垂直滚动： ScrollView

- 水平滚动: HorizontalScrollView


## RecyclerView（使用较多）

> 灵活实现大数据集的展示，视图的复用管理比Listview更好，能够显示列表、网格、瀑布流等形式，且不同的ViewHoler能够实现item多元化的功能；

## LinearRecyclerView

- 分隔线；
- 点击事件；

> # 开源库：XRecyclerView:addHeadView,addFootView,下拉刷新，上拉加载；

## WebView

### 加载

- 网络
```java
webview.loadUrl("https://www.emperinter.info")
```

- 本地
```java
webview.loadUrl("file:///adnroid_asset/test.html")
```
- 直接加载html代码
```
webview.load.Data();  //容易出现乱码
webview.loadDataWithBaseURL();  //后者编码更好
```

### 网页的前后进
- 判断能否返回上一级
```java
webview.canGoBack()
```

- 返回
```java
webview.goBack()
```

- 能否去前进？
```java
webview.canGoForward()
```

- 能否前进或返回？
```java
webview.canGoBackOrForward(int steps)
```

- steps>0 前进，steps<0 后退  step布
```java
webview.goBackOrForward(int steps)
```

### 返回键

- 按下返回键，默认是退出当前Activity，如果是WebView内容页面后退

```java
@Override
public boolean onKeyDown(int kecode,KeyEvent event){
    if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGOBack()){
        webView.goBack();
        return true;  //其它不要处理了！
    }
    return super.onKeyDown(keyCode,event);
}
```

### 执行JS代码

> # 参考：[最全面总结 Android WebView与 JS 的交互方式](https://www.emperinter.info/2020/06/07/android-webview-js/)

## UI组件弹出组件

### Toast
- 消息提示组件
- 设置显示的位置
- 自定义显示内容（例如：添加一个图片）
- 简单封装

- 多次点击，后面把前面给抵消掉，以最后一个为准
> 包装过的Toast

## AlertDialog | 对话框

- 默认样式
- 单选样式
- 多选样式
- 自定义样式

# ProgressBar & ProgressDialog

## 定义自己的样式 | 其它布局也类似

- activity_progress.xml

```xml
<!-- 定义自己的样式 -->
  <ProgressBar
  android:id="@+id/pb6"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  style="@style/MyProgressBar"
  android:layout_marginTop="10dp"/>
```

- styles.xml

```xml
<style name="MyProgressBar">
 <item name="android:indeterminateDrawable">@drawable/load_progress</item>
</style>
```

## 自定义DiaLog

- CustomDialog.java
> 没有采用builder,这里采用的方式可以一直.setTitle().setMessage()模式，返回值不为void而为CustomDialog模式

### 设置屏幕宽度

```java
//设置宽度
WindowManager m = getWindow().getWindowManager();
Display d = m.getDefaultDisplay();
WindowManager.LayoutParams p = getWindow().getAttributes();
Point size = new Point();
d.getSize(size);
p.width = (int)(size.x * 0.8); //设置display的宽度为当前手机屏幕的宽度
getWindow().setAttributes(p);
```

### 自定义按压效果
- selector

## Pop-up Window

- .9图

# 不可不会的Activity和Fragment

> Fragment: 碎片化，依赖于Activity，一个Activity可有多个Fragment!

## Activity的创建三部曲
- 新建类继承Activity或其子类
- 在AndroidManfiest中声明（可不要）
- 创建layout并在Activity的onCreate中设置（可不要）

eg:TestActivity

- 标题改变

```xml
adnroid:label="Test"
```

![](index_files/cde66b09-5c25-4594-81f5-05bf12e74e16.png)
![](index_files/95e8938b-08f8-4d75-8e5f-e589a6e05b71.jpg)

- 取消标题栏

![](index_files/a9ad83b6-9e3c-47be-853a-9d66d1345cbd.png)

```xml
<activity android:name=".MainActivity"
  android:theme="@style/AppTheme.NoActionBar">
 <intent-filter> <action android:name="android.intent.action.MAIN" />
 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter></activity>
```
![](index_files/28562a8f-6675-497d-9cb1-c6b4fbc4025e.png)

- 全局无标题

```xml
<application
  android:allowBackup="true"
  android:icon="@mipmap/ic_launcher"
  android:label="@string/app_name"
  android:roundIcon="@mipmap/ic_launcher_round"
  android:supportsRtl="true"
  android:theme="@style/AppTheme.NoActionBar"
  >
	...

</application>
```

![](index_files/270a1fbb-cc46-40ab-a217-7897e0f1742e.png)

- 竖屏显示

> 默认自动切换！

![](index_files/bf058cea-40a3-4e5e-be55-47769169cada.png)


```xml
<activity android:name=".MainActivity"
  android:theme="@style/AppTheme.NoActionBar"
  android:screenOrientation="portrait">
 <intent-filter> <action android:name="android.intent.action.MAIN" />
 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter></activity>
```
- 水平显示

```xml
android:screenOrientation="landscape"
```


- 启动模式

```xml
android:launchMode="standard"
```

- 设为默认的启动

```xml
<intent-filter>
 <action android:name="android.intent.action.MAIN" />
 <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```