--SET GLOBAL innodb_buffer_pool_size=1*1024*1024*1024; -- 1GB (for sonarQube)
--SET GLOBAL query_cache_size = 15*1024*1024; -- 15MB (for sonarQube)

CREATE DATABASE `school_management`;

USE school_management;

CREATE TABLE `admission_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `admission_number` varchar(45) NOT NULL,
  `admission_date` datetime NOT NULL,
  `fee_amount` decimal(10,0) NOT NULL DEFAULT '0',
  `payment_date` datetime NOT NULL,
  `remarks` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admission_number_UNIQUE` (`admission_number`),
  KEY `fk_admission_student-personal-detail_idx` (`student_id`),
  CONSTRAINT `fk_admission_student-personal-detail` FOREIGN KEY (`student_id`) REFERENCES `student_personal_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table stores admission details';

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`role_name`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='This table describes different types of user roles';

CREATE TABLE `section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `section_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table describes all available section names.';

CREATE TABLE `standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table stores all the available standard or class names.';

CREATE TABLE `student_personal_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `father_name` varchar(45) NOT NULL DEFAULT 'NA',
  `mother_name` varchar(45) NOT NULL DEFAULT 'NA',
  `guardian_name` varchar(45) NOT NULL DEFAULT 'NA',
  `gender` char(1) NOT NULL,
  `birth_date` datetime NOT NULL,
  `religion` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL DEFAULT 'Indian',
  `identification mark1` varchar(45) NOT NULL DEFAULT 'NA',
  `identification mark2` varchar(45) NOT NULL DEFAULT 'NA',
  `contact_number1` varchar(10) NOT NULL,
  `contact_number2` varchar(10) NOT NULL,
  `photo` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table stores student personal details';

CREATE TABLE `student_school_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard` int(11) NOT NULL,
  `section` int(11) NOT NULL,
  `roll_number` varchar(45) NOT NULL,
  `admission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_admission_idx` (`admission_id`),
  KEY `fk_student_standard_idx` (`standard`),
  KEY `fk_student_section_idx` (`section`),
  CONSTRAINT `fk_student_admission` FOREIGN KEY (`admission_id`) REFERENCES `admission_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_section` FOREIGN KEY (`section`) REFERENCES `section` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_standard` FOREIGN KEY (`standard`) REFERENCES `standard` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table stores student school details';

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_role_idx` (`role`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='This table stores a list of users';

