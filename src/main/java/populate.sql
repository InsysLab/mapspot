USE `mapeye`;

INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('normal', '1', '1985-11-10', 'mpit@gmail.com', 'Mark Pit', NULL, 'pass', 'ROLE_USER', 'mpit', true);
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('normal', '2', '1990-11-10', 'rabin@gmail.com', 'Rabindra Sah', NULL, 'pass', 'ROLE_USER', 'rabin', true);
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('admin', '3', '1990-11-10', 'prabesh@gmail.com', 'Prabesh Manandhar', NULL, 'pass', 'ROLE_ADMIN', 'prabesh', true);

INSERT INTO `mapeye`.`map` (`date_created`, `description`, `blocked`, `public`, `map_id`) VALUES ('2012-1-2', 'test', '0', '1', '1');
	
