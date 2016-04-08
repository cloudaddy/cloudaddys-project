DROP TABLE `reports`;

CREATE TABLE `reports` (
  `Id` mediumint unsigned NOT NULL auto_increment,
  `userId` mediumint,
  `name` varchar(255) default NULL,
  `attachment` blob 
  `deleted` VARCHAR(1),
  `supplier_company` VARCHAR(100),
  `created_on` VARCHAR(10),
  `created_of` VARCHAR(10),
   PRIMARY KEY (Id)
  
);


INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (1,1,"report_6"),(2,2,"report_6"),(3,3,"report_6"),(4,4,"report3"),(5,5,"report_5"),(6,6,"report_2"),(7,7,"report3"),(8,8,"report_2"),(9,9,"report_4"),(10,10,"report_5");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (11,11,"report_2"),(12,12,"report_10"),(13,13,"report_1"),(14,14,"report_8"),(15,15,"report_8"),(16,16,"report_8"),(17,17,"report_8"),(18,18,"report_7"),(19,19,"report_8"),(20,20,"report_8");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (21,21,"report_10"),(22,22,"report3"),(23,23,"report_1"),(24,24,"report_8"),(25,25,"report_5"),(26,26,"report_1"),(27,27,"report3"),(28,28,"report_5"),(29,29,"report3"),(30,30,"report_1");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (31,31,"report_10"),(32,32,"report3"),(33,33,"report_2"),(34,34,"report_10"),(35,35,"report_6"),(36,36,"report_9"),(37,37,"report_7"),(38,38,"report_2"),(39,39,"report_9"),(40,40,"report3");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (41,41,"report_10"),(42,42,"report_8"),(43,43,"report_1"),(44,44,"report_8"),(45,45,"report_8"),(46,46,"report3"),(47,47,"report_6"),(48,48,"report3"),(49,49,"report_5"),(50,50,"report_10");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (51,51,"report_10"),(52,52,"report_9"),(53,53,"report_5"),(54,54,"report_7"),(55,55,"report_6"),(56,56,"report_9"),(57,57,"report_7"),(58,58,"report_2"),(59,59,"report_5"),(60,60,"report_5");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (61,61,"report3"),(62,62,"report_5"),(63,63,"report_10"),(64,64,"report_5"),(65,65,"report_9"),(66,66,"report3"),(67,67,"report_8"),(68,68,"report_6"),(69,69,"report_5"),(70,70,"report_10");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (71,71,"report3"),(72,72,"report3"),(73,73,"report_7"),(74,74,"report_7"),(75,75,"report_8"),(76,76,"report_10"),(77,77,"report3"),(78,78,"report_6"),(79,79,"report_9"),(80,80,"report_4");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (81,81,"report_2"),(82,82,"report_2"),(83,83,"report_1"),(84,84,"report_8"),(85,85,"report_4"),(86,86,"report_5"),(87,87,"report_4"),(88,88,"report_9"),(89,89,"report_7"),(90,90,"report3");
INSERT INTO `reports` (`Id`,`userId`,`name`) VALUES (91,101,"report_1"),(92,101,"report_5"),(93,101,"report_1"),(94,101,"report_10"),(95,95,"report3"),(96,96,"report_5"),(97,97,"report_8"),(98,98,"report_9"),(99,99,"report_8"),(100,100,"report_8");
