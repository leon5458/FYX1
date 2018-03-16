# FYX1
## 第一次提交  
### 按钮  
按钮实现主要有中间弹框底部弹框,以及轮滑弹框  
其中时间选择选择,城市选择器 以及底部轮滑弹框使用PicerView, 中间弹框以及底部使用NiceDialog,以及自定义的Toast  
### PicerView使用: <br>
引入: compile 'com.contrarywind:Android-PickerView:3.2.7'  

![PickerView](https://github.com/leon5458/FYX1/blob/master/img/PicerView.gif)  

### NiceDialog 使用引入:   
compile 'com.github.Othershe:NiceDialog:1.1.4'   

![NiceDialog](https://github.com/leon5458/FYX1/blob/master/img/NiceDialog.gif)    

布局如有不一样的地方可以自定义修改,中间弹框内容多的添加滚动即可   
弹框可以用BottomPopWindow ,AlertDialog ,都写好放在utils下面,其他的就没写了.    

### 进度条使用:   
这个需要修改就导入了stepview库,使用时候图片,进度方向修改即可   

![StepView](https://github.com/leon5458/FYX1/blob/master/img/StepView.gif)   

### 信息输入框:   
在View里面PswText导入 即可    
![PswText](https://github.com/leon5458/FYX1/blob/master/img/Information.gif)  

### 更换理由:   
使用CheckBox前面的图片可以自定义修改   
![CheckBox](https://github.com/leon5458/FYX1/blob/master/img/Change.gif)  


### 标签:   
可以用FlexboxLayout这个个人感觉很适合   
使用的时候导入: compile 'com.google.android:flexbox:0.2.6'   

![label](https://github.com/leon5458/FYX1/blob/master/img/label.gif)     


### 城市定位  
定位使用的WaveSideBar,城市json是以前用过的,如感觉不合适可以在修改  

![bar](https://github.com/leon5458/FYX1/blob/master/img/city.gif)       


全部gif图片显示在img中可以查看效果图   

### 日历:   
日历导入的是一个calendarview库,日历可以伸缩,在CalendarView里面如有需要可以取消注释
日历下的时间是用recyclerview做的,适配器自己简单的写了一个项目中使用不一样适合,详情
可以参看代码 下面是效果图  
![calendar](https://github.com/leon5458/FYX1/blob/master/img/calendar.gif) 

### 画廊效果: 
 画廊的使用自定义的clipviewpager文件都放在view文件下面的clipPage里面,使用的时候
 复制过去即可,下面是效果图
![gallery](https://github.com/leon5458/FYX1/blob/master/img/Gallery.gif)  
### 加载效果:  
这个使用的自定义的progressDialog 修改颜色  
下面是效果图  
![pro](https://github.com/leon5458/FYX1/blob/master/img/progress.gif)   

### 对号绘制:          
绘制是自定义view ,RightMark 放在view文件夹里面  
下面是效果图  
![mark](https://github.com/leon5458/FYX1/blob/master/img/right.gif)  

### 侧滑栏:  
侧滑栏使用系统自带的Drawablelayout 效果图如下  
![mark](https://github.com/leon5458/FYX1/blob/master/img/drawable.gif)  

### 弹框修改后的效果    
![bomb](https://github.com/leon5458/FYX1/blob/master/img/all.gif)
   
  
   
  
    
   
  
 
  
  


  

  

  







