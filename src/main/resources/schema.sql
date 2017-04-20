DROP TABLE IF EXISTS character;
CREATE TABLE character (
  id      BIGINT,
  NAME    VARCHAR(255),
  species VARCHAR(255),
  age     INTEGER,
  STATUS  VARCHAR(255),
  PRIMARY KEY (id)
);
