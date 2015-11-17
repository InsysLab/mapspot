USE `mapeye`;

INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('User', '1', '1985-11-10', 'mpit@gmail.com', 'Mark Pit', NULL, '$2a$10$bQy//HhgkYommB4ondNcXudCsW5cPYDfZ5fcZBozlPHvL24VcP6Fe', 'ROLE_USER', 'mpit', true);
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('User', '2', '1990-11-10', 'rabin@gmail.com', 'Rabindra Sah', NULL, '$2a$10$bQy//HhgkYommB4ondNcXudCsW5cPYDfZ5fcZBozlPHvL24VcP6Fe', 'ROLE_USER', 'rabin', true);
INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('admin', '3', '1990-11-10', 'prabesh@gmail.com', 'Prabesh Manandhar', NULL, '$2a$10$bQy//HhgkYommB4ondNcXudCsW5cPYDfZ5fcZBozlPHvL24VcP6Fe', 'ROLE_ADMIN', 'prabesh', true);

INSERT INTO `person` (`user_type`, `id`, `birth_date`, `email`, `name`, `photo`, `password`, `role`, `username`, `enabled`) VALUES ('admin', '4', '1990-11-10', 'admin@gmail.com', 'Admin User', NULL, '$2a$10$tOmRXiMn9sXQ/qxKmfKSguogBhmZ7z7hjXceGaam/FaSFGZIxe4yi', 'ROLE_ADMIN', 'admin', true);

