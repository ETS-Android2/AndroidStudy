# AndroidStudy
> Android系统学习的笔记!系统但并非详细！

# 参考视频
学习的主要来源[YouTube | https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull](https://www.youtube.com/watch?v=sehxt5wbsgM&list=PLoDvOw64tSYsWvlxk9aIDOGPVrFQeHull)


Button 继承自 TextView
EditText 继承自 TextView​


# ImageView

## scaleType

| 值  |  含义  |
| :------------: | :------------: |
| fitXY  | 撑满控件，宽高比可能发生改变  |
| fitCenter  | 保持宽高缩放，直至能够完全显示  |
|centerCrop| 保持宽高比缩放，直至完全覆盖控件，剪裁显示|

## 网络图片 | 第三方库

[https://github.com/bumptech/glide](https://github.com/bumptech/glide)

# ListView | Grid View

> Adapter 写法

# ScrollView

> 只能有一个子元素

## 分类

- 垂直滚动： ScrollView

- 水平滚动: HorizontalScrollView


# RecyclerView（使用较多）

> 灵活实现大数据集的展示，视图的复用管理比Listview更好，能够显示列表、网格、瀑布流等形式，且不同的ViewHoler能够实现item多元化的功能；

## LinearRecyclerView

- 分隔线；
- 点击事件；

## 开源库：XRecyclerView

> addHeadView,addFootView,下拉刷新，上拉加载;

[https://github.com/XRecyclerView/XRecyclerView](https://github.com/XRecyclerView/XRecyclerView)
