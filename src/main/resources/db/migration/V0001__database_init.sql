CREATE TABLE injection_of_insulin (
	id serial NOT NULL,
	injection float NULL,
	user_id varchar NULL,
	created_at timestamp NULL
);

CREATE TABLE sugar_measurement (
	id serial NOT NULL,
	measurement numeric(3, 1) NULL,
	user_id varchar NULL,
	created_at timestamp NULL
);