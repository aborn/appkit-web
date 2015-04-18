appkit-web
========

## 中文介绍
appkit-web是一个SpringMVC项目，它采用了最新的Spring版本(4.1.1.RELEASE)。  
该项目采用注释的方式解决权限问题，在用户点击提交的时候采用HandlerInterceptorAdapter进行拦截。[English Intro](README.md)

## 框架介绍
该项目采用了以下框架:  
 1. [Spring](https://spring.io/) 4 MVC (Version: 4.1.1.RELEASE).    
 2. [Freemarker](http://freemarker.org/) 模板引擎 (Version: 2.3.20).  
 3. [Bootstrap](http://getbootstrap.com/) 前端展示(Version: 3.3.2).  
 4. [jQuery](https://jquery.com/) 最流行的js库(Version: 2.1.3).    
 5. [Font Awesome](http://fortawesome.github.io/Font-Awesome/) 前端符号库(Version: 4.3.0).  
 5. [Mybatis](https://mybatis.github.io/mybatis-3/) 与数据库的链接层 (Version: 3.2.8).  

## 数据库
MySQL

## Java版本要求
Java 6+

## 安装
修改数据库配置文件 classpath:config/spring/appcontext-mybatis.xml   
为你自己的数据库参数。

## 部署
采用如下命令创建一个示例的数据库表格  
```
CREATE TABLE `appkit_demo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(11) DEFAULT NULL COMMENT 'user name',
  `address` varchar(30) DEFAULT NULL COMMENT 'user adress',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='appkit-web demo database';
```

## 项目启动时间
2015-03-15

## 最近更新时间
2015-04-18
