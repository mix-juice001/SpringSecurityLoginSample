INSERT INTO loginuser.users (login_id, password) VALUES
  ('user', '$2a$10$2K6q3ryhiwKs4WnDz6mjjOCWq/Tn4uuDhM1kZyGdjTTM9J7UC0GOO'),
  ('user1', '$2a$10$5loWIeiozrv3RLdlFSd3mOCKfLfGLHAwG6hg6te2NVuTQ5M18DyQK'),
  ('user2', '$2a$10$BZjuFGNAVfY5idQpsFYHVu2em61lJ93yB2GxdYBgIN76QTHyKPdf2');


INSERT INTO users VALUES ('user', 'password', TRUE);
INSERT INTO authorities VALUES ('user', 'ROLE_USER');