BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS harvest;
DROP TABLE IF EXISTS transplant;
DROP TABLE IF EXISTS expiration;
DROP TABLE IF EXISTS crops;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

create table harvest(
        id serial,
        crop varchar(30) not null,
        direct_seed_to_harvest_time int not null,
        
        constraint pk_id primary key (id)
);

create table expiration(
        id serial primary key,
        crop varchar(30) not null,
        days_to_expire int
        );


create table transplant(
        id serial,
        crop varchar(30) not null,
        direct_seed_to_transplant_time int not null,
        transplant_to_harvest_time int not null,
        
        constraint pk1_id primary key (id)
);

create table crops(
        id serial,
        area varchar(3) not null,
        crop varchar(30) not null,
        planting_date date not null,

        constraint pk_crops_id primary key (id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
