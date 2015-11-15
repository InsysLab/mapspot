USE `mapeye`;

INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`) VALUES ('normal', '1', '1985-11-10', 'mpit@gmail.com', 'Mark Pit', NULL, '$2a$08$72khFRfkWsn3G2qmM4QSruL2ENz55Mpi4gryOHcGeLlRULdTRRjz2', '1', 'mpit');
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`) VALUES ('normal', '2', '1990-11-10', 'rabin@gmail.com', 'Rabindra Sah', NULL, '$2a$08$72khFRfkWsn3G2qmM4QSruL2ENz55Mpi4gryOHcGeLlRULdTRRjz2', '1', 'rabin');
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`) VALUES ('normal', '3', '1990-11-10', 'prabesh@gmail.com', 'Prabesh Manandhar', NULL, '$2a$08$72khFRfkWsn3G2qmM4QSruL2ENz55Mpi4gryOHcGeLlRULdTRRjz2', '1', 'prabesh');
INSERT INTO `mapeye`.`map` (`date_created`, `description`, `blocked`, `public`, `map_id`) VALUES ('2012-1-2', 'test', '0', '1', '1');
	
