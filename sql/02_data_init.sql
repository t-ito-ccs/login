
CREATE EXTENSION pgcrypto;

CREATE TABLE account (
id VARCHAR(20) NOT NULL
, password TEXT
, PRIMARY KEY(id)
, UNIQUE (id));

INSERT INTO account VALUES('test01', crypt('test01', gen_salt('bf')));
INSERT INTO account VALUES('test02', crypt('test02', gen_salt('bf')));
