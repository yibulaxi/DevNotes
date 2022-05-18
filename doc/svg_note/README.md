## SVG 

### 简介

- 使用 XML 描述的矢量文件
- W3C标准
- 浏览器支持情况
  - IE 9+
  - Chrome 33.0+
  - FireFox 28.0+
  - Safari 7.0+
- 基于数学的描述



### 使用方式

- 浏览器直接打开
- 在 HTML 中使用 <img> 标签引用
- 直接在 HTML 中使用 SVG 标签
- 作为 CSS 背景

#### HTM 中使用 <img> 标签

```html
<!DOCTYPE html>
<html>
    <head>
        <title>使用 svg</title>
    </head>

    <body>
        <h1>Hello SVG</h1>

        <p>
            <img src="../Downloads/icons/icon_smile.svg"> 原始大小
        </p>
        <p>
            <img src="../Downloads/icons/icon_smile.svg" width="40" height="40"> 40 x 40
        </p>
        <p>
            <img src="../Downloads/icons/icon_smile.svg" width="400" height="400"> 400 x 400
        </p>
    </body>
</html>
```

---



- [1.2 基本图形和属性](1.2.md)

- [1.3 基本操作 API](1.3.md)
- [1.4 SVG 编辑器](1.4.md)

### svg 坐标系统

- [2.1 SVG 视野的概念](2.1.md)
- [2.2 分组](2.2.md)
- [2.3  坐标系统](2.3.md)
- [2.4 四个坐标系](2.4.md)
- [2.5 坐标变换]()

