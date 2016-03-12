CREATE TABLE users (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` vacahr(50),
  `display_name` varchar(50) ,
  `password` varchar(50) ,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into users values (1,'zhy20090912@gmail.com','haiyang','zhy'),(2,'1644881502qq.com','shuaili','wsl');


