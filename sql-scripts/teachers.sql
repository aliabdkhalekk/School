CREATE DATABASE IF NOT EXISTS `school_project`;
USE `school_project`;

-- Drop tables if they exist
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `teachers`;

-- Create teachers table
CREATE TABLE `teachers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) DEFAULT NULL,
  `last_name` VARCHAR(45) DEFAULT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create address table with a foreign key referencing teachers table
CREATE TABLE `address` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `street_name` VARCHAR(255) NOT NULL,
    `country` VARCHAR(255) NOT NULL,
    `government` VARCHAR(255) NOT NULL,
    `teacher_id` INT,
    FOREIGN KEY (`teacher_id`) REFERENCES `teachers`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Insert data into teachers table
INSERT INTO `teachers` (`id`, `first_name`, `last_name`,`age`) VALUES 
    (1, 'Ali', 'Ahmed',22),
    (2, 'Samer', 'Moastafa',35),
    (3, 'Moahmed', 'Abdalkhalek',43),
    (4, 'Magdy', 'Salem',34);

INSERT INTO `address` (`id`, `street_name`, `country`, `government`, `teacher_id`) VALUES 
    (1, 'nasrCity', 'Egypt', 'CairoGovernment', 1),
    (2, 'Obour', 'Egypt', 'CairoGovernment', 2),
    (3, 'Elolaya', 'Ksa', 'RiyadhGovernment', 3),
    (4, 'Malkfhad', 'Ksa', 'RiyadhGovernment', 4);

