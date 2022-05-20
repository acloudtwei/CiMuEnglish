# CiMuEnglish
### 基于 SpringBoot+Mybatis-Plus+SaToken+Layui的大学生考证辅助平台

### 开发工具

IntelliJ IDEA 2020.1

### 开发环境

| JDK | Maven| Mysql  | SpringBoot | Mybatis-Plus | SaToken| 
| :-------------: |:-------------:| :-------------:| :-------------:|:-------------:| :-------------:|
| 1.8  | 3.8.2 | 8.0.11| 2.5.6 | 3.4.3.4 | 1.28.0 | 

### 项目启动说明

1、启动前，请配置 application.properties和application.yml 中相关MySQL、邮箱的配置，其中我用的是QQ邮箱，当然你也可以用其他的邮箱！

2、登录地址**管理员账号密码：cimu cimu123456**：http://localhost:8080/myspace

3、普通用户登录是功能界面，管理员用户登录是后台界面！

### 其它说明

1、数据库有初中、高中、四级、六级等词汇，教师资格证有科一和科二的题库，普通话含有基本的题目和资料；其中用户表user存放的是管理员账号密码，密码已经使用加salt的MD5加密！

2、前端界面使用的是基本的三件套以及bootstrap、layui，后台使用的是LayuiMini模板，接口文档使用的是Swagger2。

### 页面截图
首页
![index.jpg](http://imgtu.aiyunkj.com/2022/05/20/b6210ccd82e2b.jpg)

登录页
![login.jpg](http://imgtu.aiyunkj.com/2022/05/20/b99a574353143.jpg)

背单词模块页面
![english.jpg](http://imgtu.aiyunkj.com/2022/05/20/ad22ef8e15851.jpg)

教师资格证模块页面
![teacher.jpg](http://imgtu.aiyunkj.com/2022/05/20/ec09a12470f65.jpg)

普通话模块页面
![mandarin.jpg](http://imgtu.aiyunkj.com/2022/05/20/db92b6ccbba95.jpg)

后台页面
![admin.jpg](http://imgtu.aiyunkj.com/2022/05/20/e76c2239af3f2.jpg)

### 开发者介绍

本项目是一门课程大作业，是由小组成员一起开发的！本人作为小组主要核心人员参与后端的开发以及部分界面的编码。

阿威导航站：https://www.rjfxkt.vip/
