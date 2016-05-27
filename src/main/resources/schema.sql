DROP SCHEMA IF EXISTS loginuser;
CREATE SCHEMA loginuser;

DROP TABLE IF EXISTS loginuser.users;
CREATE TABLE loginuser.users (
  user_id INT AUTO_INCREMENT,
  login_id VARCHAR(256) UNIQUE ,
  password VARCHAR(256)
);

CREATE TABLE loginuser.authorities (
  user_id INT,
  authority VARCHAR(256),
  FOREIGN KEY (user_id) REFERENCES loginuser.users(user_id)
);


-- DROP TABLE IF EXISTS users;
-- CREATE TABLE users (
--   username VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
--   password VARCHAR_IGNORECASE(50) NOT NULL,
--   enabled  BOOLEAN                NOT NULL
-- );
--
-- DROP TABLE IF EXISTS authorities;
-- CREATE TABLE authorities (
--   username  VARCHAR_IGNORECASE(50) NOT NULL,
--   authority VARCHAR_IGNORECASE(50) NOT NULL,
--   CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
-- );
-- CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);