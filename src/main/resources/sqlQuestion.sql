CREATE TABLE IF NOT EXISTS user(
  userId serial PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  superName VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS account(
  accountId serial PRIMARY KEY,
  account INTEGER NOT NULL,
  userId INTEGER REFERENCES user(userId)
);