
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `username` varchar(50) NOT NULL,
   `enabled` bit(1) NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rolle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
);

INSERT INTO `tbl_user` (`username`,`fullname`,`rolle`,password, enabled)
values ('user','Hersteller','USER','$2a$10$OiXOEDV4bV7gxTPNlg3pZOq/H8jmlnCS7DdDcVXSDdvfax/7pWbVa',TRUE);