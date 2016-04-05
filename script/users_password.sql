DROP TABLE `users_password`;

CREATE TABLE `users_password` (
  `id` mediumint(8) unsigned default NULL,
  `password` varchar(255),
  FOREIGN KEY (`id`) REFERENCES `users`(`id`)
);
