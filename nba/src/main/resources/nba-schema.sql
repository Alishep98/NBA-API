DROP TABLE IF EXISTS `nba` CASCADE;
CREATE TABLE `nba` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT, 
	`age` INTEGER CHECK (age<=45 AND age>=0), 
	`name` VARCHAR(255), 
	`ppg` INTEGER, 
	`rpg` INTEGER, 
	`apg` INTEGER
);