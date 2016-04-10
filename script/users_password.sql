
CREATE TABLE `users_password` (
  `id` mediumint(8) unsigned default NULL,
  `password` varchar(255),
  FOREIGN KEY (`id`) REFERENCES `users`(`id`)
);


INSERT INTO `users_password` (`id`,`password`) VALUES ("101","user");
