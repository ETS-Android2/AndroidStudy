# AndroidStudy

> Android系统学习的笔记!系统但并非详细！图片并不能直接上传到文档中，如需了解详情请访问：**[https://www.emperinter.info/2020/10/03/android-study/](https://www.emperinter.info/2020/10/03/android-study/)**

# 参考视频

> 可惜没有网络,json,xml等等的教程！还有没有6教程这个有点懵圈，自己在B站上找到出处也是没有的，而且B站有多几个教程！

学习的主要来源：
- [YouTube（不全） | https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull](https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull)

- [B站（较全） | https://www.bilibili.com/video/BV1Rt411e76H?p=36](https://www.bilibili.com/video/BV1Rt411e76H?p=36)

# util | 工具类

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

> ### 开源库：XRecyclerView:addHeadView,addFootView,下拉刷新，上拉加载；

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

> ##### 参考：[最全面总结 Android WebView与 JS 的交互方式](https://www.emperinter.info/2020/06/07/android-webview-js/)

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

## Activity 的生命周期

> LifeCycleActivity.java

![](index_files/952c8280-7b08-4a22-9a19-61736cc564a1.jpg)

## Activity的跳转和数据传递

> package: jump

- 显式跳转和隐式跳转

- Activity之间的数据传递

- startActivitForResult:启动Activity,结束后返回结果

### 显式跳转

```java
             //显式跳转 1
//                Intent intent = new Intent(AActivity.this,BActivity.class);
//                startActivity(intent);
//
 //显式跳转 2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

 //显式跳转 3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"info.emperinter.AndroidStudy.jump.BActivity");
//                startActivity(intent);

 //显式跳转 4  Intent intent = new Intent();
  intent.setComponent(new ComponentName(AActivity.this,"info.emperinter.AndroidStudy.jump.BActivity"));
  startActivity(intent);
```

### intent

> 摄像头、打电话、邮件等等很多与intent有关


### Activity 数据传递

```java
startActivityForResult();//回调数据
```

### Activity 的4种启动模式(launchMod)

> 在AndroidManifest.xml中修改！

```xml
<activity android:name=".jump.AActivity"
          android:label="A"
          android:launchMode="standard"/>
```

> 代码中的taskid:判断是否为同一栈，hash:判断是否为同一实例；

#### Activity的android:launchMode属性

- standard: 标准模式，默认 | 每启动一个Activity都会创建一个新的实例。


> Activity是由任务栈管理的，每启动一个Activity，就会被放入栈中，按返回键，就会从栈顶移除一个Activity


- singleTop: Task栈顶复用模式

> 当要启动的目标Activity已经位于栈顶时，不会创建新的实例，会复用栈顶的Activity，并且其onNewIntent()方法会被调用；如果目标Activity不在栈顶，则跟standard一样创建新的实例。

- singleTask: Task栈内复用模式

> 在**同一个任务栈**中，如果要启动的目标Activity已经在**栈中(不一定在栈中)**，则会复用该Activity，并调用其onNewIntent()方法，并且该Activity上面的Activity会被**清除**；如果栈中没有，则创建新的实例。

> 以上两个在同一个栈复用

- singleInstance: 全局单例模式

> 全局复用，不管哪个Task栈，只要存在目标Activity，就复用。每个Activity占有一个新的Task栈。

> 可为多个栈。

- 任务栈名称：
```xml
android:taskAffinity="A"
```

------------



# Fragment  | 该教程已过时，方法已被弃用2020-10-02 10:40:14 星期五

> ** 用于实现同一个Activity不同布局的切换！eg:小米运动国际版首页的切换！**

- Fragment有自己的生命周期
- 依赖于Activity
- Fragment通过getActivit()可以获取所在的Activity；Activity通过FragmenManager的findFragmentById()或findFragmentByTag()获取Fragment
- Fragment和Activity是多对多的关系


## 用到的文件
- ContainerActivity.java
- Afragement.java

### 注意

```java
//getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
  getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
```

**getFragmentManager()与getSupportFragmentManager():**

- 相同：

```
/**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
```

就是说通过上述两种方法获得的FragmentManager是Activity中所包含Fragment的FragmentManager。

- 不同：
getFragmentManager():是Activity中和V4包的Fragment中的方法
getSupportFragmentManager():是FragmentActivity中的方法

### 问题

- Fragment中getActivity()为null的问题
- 向Fragment传递参数


## Fragment回退栈

```java
//按返回键不直接跳到上一个Activity，回退栈
getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
```


## Fragment和Activity通信

> 常用两种方法：接口以及自定义类实现


# 必须深刻理解的Android事件处理！

> ** 当用户在应用界面上执行各种操作时，应用程序需要为用户的动作提供响应，这种响应的过程就是事件处理！**

## 基于监听的事件处理机制

### 监听三要素
- Event Source（事件源）
- Event(事件)
- Event Listener(事件监听器，与事件对应)

### 实现监听事件的方法 | EventActivity.java
- 通过内部类实现
- 通过匿名内部类实现（eg:new clicklister）
- 通过事件源所在类实现
- 通过外部类实现  | 不常用 (eg:MyClickListener.java)
- 布局文件中的onClick属性（针对点击事件！）

### 给同一事件源添加多个同种类型事件监听器会怎样？

Answer：**系统会响应最后一个监听器**，布局和其它都添加时，布局被认为是最新监听的，所以不会执行！


## 基于回调的事件处理机制 | EVENT.java | widget/MyButton.java

### 回调机制与监听机制的区别
- 回调机制的事件源和监听绑定在一起

### 基于回调的事件传播

> 先从控件本身回调，后向Activity回调！由内部向外部回调！

----

> ## 监听优先于回调！

## 源码剖析，了解View的事件分发

> 一个控件的触摸事件都是从dispatchTouchEvent往下分发的;入口方法！

- dispatchTouchEvent -> setOnTouchListener->onTouchEvent；

- onClick/onLongClick 来自onTouchEvent的处理；



## Handler消息处理

### 主要用途

- 未来某时做某事
- 线程间通信

# 数据存储

## SharedPreferences 轻量级存储存储

### 方法

- Xml文件，Key-Value形式

- SharedPreferences | 读数据

- SharedPreferences.Editor | 写数据

```java
mEditor.apply();//提交数据,先修改内存值,后台存储 | 异步存储,优先考虑
//mEditor.commit();//提交数据,同步存储
```

### 文件目录

- /data/data/<applicationId>（非包名）/shared_prefsd

> 真机要Root权限才能看到


## Android 存储概念

### 内部存储

### 外部存储


- 公有目录

获取数据：

```java
Environment.getExternalStoragePublicDirectory(int type)
```

- 私有目录

## File内部存储

> 利用Java的I/O流

### FileOutputStream FileInputStream


## File外部存储

- 权限

> 23以上(6.0),动态申请权限

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

```java
//动态请求存储权限
ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);<
```

插卡手机
```xml
<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
```


> 模拟器上运行不了？但真机可运行!

------------
> 以下教程在B站


# 广播

- 动态和静态
- 有序和无序

## LocalBroadcastManager{动态注册}

> 不一定要用广播实现，也可用OnActivityResult/StartActivityForResult实现！

# 补间动画和属性动画

## 补间动画
> 并未真正改变位置，视觉欺骗！

## 属性动画 | ObjectAnimaActivity

- ValueAnimator

- ObjectAnimator.ofFloat()
  translationX translationY alpha rotation rotationX...


# 附

## 如何分析错误日志？

- Logcat

- Error

> 看视频！

## 按压水波纹效果

- button

```
<Button
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:elevation="8dp"
  android:background="@drawable/bg_water"
  android:text="按压水波纹 未消除"
  android:foreground="?selectableItemBackground"
  android:gravity="center_horizontal"
  android:textColor="@color/colorWhite"
  android:textSize="18sp"
  android:textAllCaps="false"
  android:padding="10dp"
  />

<Button
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:elevation="8dp"
  android:background="@drawable/bg_water"
  android:text="按压水波纹 | 消除方框阴影"
  android:gravity="center_horizontal"
  android:textColor="@color/colorWhite"
  android:textSize="18sp"
  android:textAllCaps="false"
  android:padding="10dp"
  android:layout_marginTop="10dp"
  />
```

- bg_water

```xml
<?xml version="1.0" encoding="utf-8"?>
<ripple xmlns:android="http://schemas.android.com/apk/res/android"
  android:color="#22000000">
 <item android:drawable="@drawable/bg_btn2"></item>
</ripple>
```

- bg_btn2

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="rectangle">
 <solid  android:color="#ff9900" />

 <corners  android:radius="50dp"/>
</shape>
```

# 最后

> 这个教程仅限入门教程，有许多高深的东西需要时间的积累才能掌握。同时技术在不断更新，我们只有保持一颗学习的态度才能持续走下去！
