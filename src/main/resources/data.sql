-- url encriptado: https://bcrypt-generator.com/
INSERT INTO `USERS` (`id`, `name`, `username`, `email`, `password`) VALUES
  (1, 'pepesan', 'pepesan', 'pepesan@gmail.com', '{bcrypt}$2a$12$9w59VWZTWkgKqk1Z3VIzROFl17Go0QS6YsaaTDuqVLYymQ8kN5h3y'),
                    -- password: password
  (2, 'admin',   'admin',   'admin@gmail.com',   '{bcrypt}$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu');
  -- password: admin
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO `users_roles` VALUES (2,1),(1,2);