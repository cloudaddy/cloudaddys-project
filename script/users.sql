CREATE TABLE `users` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(100) default NULL,
  `address` varchar(255) default NULL,
  `city` varchar(255),
  `state` varchar(50) default NULL,
  `country` varchar(100) default NULL,
  `last_modified` varchar(255),
  `created_on` varchar(255),
  `zip` varchar(10) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;
