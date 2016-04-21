appkit-web
========
[![Build Status](https://travis-ci.org/aborn/appkit-web.svg?branch=master)](https://travis-ci.org/aborn/appkit-web)  

## Introduction
The appkit-web is an spring mvc arch project, which use tha latest spring (4.1.1.RELEASE) technology.     
And use annotation as the authority policy when post submit. [Chinese Intro, 中文介绍.](doc/README_CN.md)

## Framework
The JavaEE web project uses following frameworks:  
 1. [Spring](https://spring.io/) 4 MVC (Version: 4.1.1.RELEASE).    
 2. [Freemarker](http://freemarker.org/) template engine (Version: 2.3.20).  
 3. [Semantic-UI](http://semantic-ui.com/) (Version: 2.1.4).  
 4. [jQuery](https://jquery.com/) (Version: 2.1.3).    
 5. [Font Awesome](http://fortawesome.github.io/Font-Awesome/) (Version: 4.3.0).  
 5. [Mybatis](https://mybatis.github.io/mybatis-3/) as database connection layer (Version: 3.2.8).  

## Database
MySQL

## Java
Java 6+

## Install
Firstly modify file classpath:config/spring/appcontext-mybatis.xml with your own database configuration.

## Deploy
Create a demo table in your database as follows
```
CREATE TABLE `appkit_demo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(11) DEFAULT NULL COMMENT 'user name',
  `address` varchar(30) DEFAULT NULL COMMENT 'user adress',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='appkit-web demo database';
```

## Web demo
Please visit demo [http://appkit.popkit.org](http://appkit.popkit.org)

## Create date
2015-03-15

## Update
2016-04-21
