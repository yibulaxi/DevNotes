## Meterial Design

[官方组件库](https://github.com/material-components/material-components-android)

可以使用 [MDC 库](https://github.com/material-components/material-components-android) 实现 Meterial Theming

318 / 5000



## Color attributes

Material Design 提供了 12 个颜色的“插槽”，它们构成了应用程序的整体调色板。 其中每一个都有一个设计术语（例如“Primary”）以及可以在你的应用程序主题中覆盖的相应颜色属性（例如 colorPrimary）。 浅色主题和深色主题都有默认的“基线”值。 



```
属性：		   						来源
colorPrimary					AppCompat
colorPrimaryVariant		MDC
colorOnPrimary 				MDC
colorSecondary				MDC
colorSecondaryVariant MDC
colorOnSecondary			MDC
colorSurface					MDC
colorOnSurface				MDC
androidLcolorBackground	Platform
colorError						AppCompat
colorOnError					MDC

```



### Picking Colors

- colorPrimary 和 colorSecondary 代表品牌的颜色
- colorPrimaryVariant 和 colorSecondaryVariant 是品牌颜色的较浅或较深的色调
- colorSurface 用于材料的“薄片”（如卡片和底片）
- android:colorBackground 是你的应用程序的窗口背景颜色
- colorError 顾名思义，用于错误和警告
- 各种“开启”颜色（colorOnPrimary、colorOnSecondary、colorOnSurface 等）用于为显示在其他颜色之上的前景内容（例如文本和图标）着色。 它们需要满足可访问性要求，并与它们显示的颜色有足够的对比度。



## Color tools

- [Material color tool](https://material.io/resources/color/#!/) : 获取主色和辅助色的浅色/深色变体以及适当的“开”色。 预览这些在示例屏幕中的外观。
- [Material palette generator](https://material.io/design/color/the-color-system.html): 生成一种颜色的完整色调调色板（阴影 50 - 900）。 获取有关互补色、类似色和三元色的建议。

## Things to consider



### 额外的颜色插槽

---

你的的设计系统可能需要在 Material Theming 指定的 12 个之外的其他颜色槽。 值得庆幸的是，通过声明颜色属性，这在 Android 上相对容易做到：

<!-- In res/values/attrs.xml -->
<attr name="colorCustom" format="color" />

<!-- In res/values/themes.xml -->
<style name="Theme.App" parent="Theme.MaterialComponents.*">
    ...
    <item name="colorCustom">@color/...</item>
</style>



## Color resources

颜色值定义为 <color> 资源。 对于自定义颜色，我们推荐两种方法来帮助分离关注点，并为应用中的颜色主题值创建单一的真实来源：





## Overriding colors in an app theme

