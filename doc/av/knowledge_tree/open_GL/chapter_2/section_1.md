### EGL 创建流程


- 得到默认的显示设备（就是窗口）-- eglGetDisplay
- 初始化默认显示设备 -- eglInitialize
- 设置显示设备属性
- 从系统中获取对应属性的配置 -- eglChooseConfig
- 创建 EglContext -- eglCreateContext
- 创建渲染的 Surface -- eglCreateWindowSurface
- 绑定 EglContext 和 Surface 到显示设备中 -- eglMakeCurrent
- 刷新数据，显示渲染场景
