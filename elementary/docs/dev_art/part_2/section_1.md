## ViewRoot 和 DecorView

- View 三大流程: 测量、布局、绘制
- 常见的回调方法: 构造方法、onAttach()、onVisibilityChange()、onDetach()

---
### ViewRoot

- ViewRoot 对应 ViewRootImpl 类，是连接 WindowManager 和 DecorView 的纽带；View 的三大流程通过 ViewRoot 完成；
- 绘制流程从 performTraversals 方法开始；经过 measure、layout、draw 最终将 View 绘制出来
- measure 过程决定了 view 的宽和高，完成以后通过 getMeasureWidth()/getMeasureHeight() 获取宽高
- layout 过程决定了 View 4 个顶点的坐标和实际的 View 宽高。顶点通过 getLeft()/getTop()/getRight()/getBottom() 获取；实际宽高通过 getWidth()/getHeight() 获取
- draw 过程决定了 View 的显示，只有 draw 方法完成以后，view 才会显示在屏幕上

### DecorView

- 是顶级 view，是一个 FrameLayout，里面一般是一个上下布局的 LinearLayout：titleBar + ContentView
- onCreate() 方法中，设置布局 setContentView(R.layout.xxx) 就是设置的 ContentView，这个内容 view 的 id是：android.R.id.content
- 获取 content 和我们设置的 view:
    ```java
    // 获取 content
    ViewGroup content = (ViewGroup)findViewById(android.R.id.content);
    // 获取设置的 view
    View myView = content.getChildAt(0)
    ```



