
CREATE TABLE `users_password` (
  `id` mediumint(8) unsigned default NULL,
  `password` varchar(255),
  `enabled` TINYINT(1) default 1,
  FOREIGN KEY (`id`) REFERENCES `users`(`id`)
);


INSERT INTO `users_password` (`id`,`password`) VALUES ("101","$2a$10$C4LCJHz/UWNncgyxM/crqOCPCd5Rk0vP.MEIe7iOwOSNGfvzl11/y", 1);


create table `authorities` ( `username` varchar(50) not null,`authority` varchar(50) not null);

INSERT INTO `authorities` (`username`,`authority`) values ("user","USER");
