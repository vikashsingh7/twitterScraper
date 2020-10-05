CREATE TABLE `twitterapp`.`tweets` (
  `id` BIGINT NOT NULL,
  `id_str` VARCHAR(45) NULL,
  `tweet_text` VARCHAR(280) NULL,
  `tweet_link` VARCHAR(45) NULL,
  `user_id` BIGINT NULL,
  `user_id_str` VARCHAR(45) NULL,
  `created_at` VARCHAR(60) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  
  CREATE TABLE `twitterappuser`.`user` (
  `user_id` BIGINT NOT NULL,
  `user_id_str` VARCHAR(45) NULL,
  `user_name` VARCHAR(45) NULL,
  `user_screen_name` VARCHAR(20) NULL,
  `location` VARCHAR(20) NULL,
  `description` VARCHAR(60) NULL,
  `url` VARCHAR(20) NULL,
  `followers_count` INT NULL,
  `friends_count` INT NULL,
  `verified_status` VARCHAR(6) NULL,
  `statuses_count` INT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE);
  
  
  