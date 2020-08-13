BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS harvest;
DROP TABLE IF EXISTS transplant;
DROP TABLE IF EXISTS expiration;
DROP TABLE IF EXISTS crops;
DROP TABLE IF EXISTS harvest_info;
DROP TABLE IF EXISTS wasteinfo;
DROP TABLE IF EXISTS lossinfo;



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
create table sales(
        id serial primary key,
        product varchar(35),
        amount decimal(15,2),
        howSold varchar(40)
        );

create table harvest_info(
        id serial primary key,
        area_identifier int,
        crop varchar(35),
        count_ int,
        weight_ int
        );

create table crops(
        id serial,
        area varchar(3) not null,
        crop varchar(30) not null,
        planting_date date not null,

        constraint pk_crops_id primary key (id)
);
create table wasteinfo(
        id serial primary key,
        crop varchar(35),
        reason varchar(40)
        );

create table lossinfo(
        id serial primary key,
        crop varchar(35),
        loss_reason varchar(40)
        );

        DROP TABLE IF EXISTS users_harvest;
create table users_harvest(
        user_id int,
        harvest_id int,
        primary key (user_id, harvest_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_harvest_id foreign key (harvest_id) references harvest(id)
        
        );

        Drop Table if Exists users_expiration;

        create table users_expiration(
        user_id int,
        expiration_id int,
        primary key (user_id, expiration_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_expiration_id foreign key (expiration_id) references expiration(id)
        
        );

        drop table if exists users_transplant;


        create table users_transplant(
        user_id int,
        transplant_id int,
        primary key (user_id, transplant_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_transplant_id foreign key (transplant_id) references transplant(id)
        
        );

        Drop Table If exists users_sale;


        create table users_sale(
        user_id int,
        sale_id int,
        primary key (user_id, sale_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_sale_id foreign key (sale_id) references sales(id)
        );

        Drop table if exists users_waste;



      create table users_waste(
        user_id int,
        waste_id int,
        primary key (user_id, waste_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_waste_id foreign key (waste_id) references wasteinfo(id)
        );

Drop table if exists users_harvestinfo;

 create table users_harvestinfo(
        user_id int,
        harvestinfo_id int,
        primary key (user_id, harvestinfo_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_harvesinfo_id foreign key (harvestinfo_id) references harvest_info(id)
        );


Drop table if exists users_loss;

 create table users_loss(
        user_id int,
        loss_id int,
        primary key (user_id, loss_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_harvesinfo_id foreign key (loss_id) references lossinfo(id)
        );


        drop table if exists users_crop;

         create table users_crop(
        user_id int,
        crop_id int,
        primary key (user_id, crop_id),
        constraint fk_user_id foreign key (user_id) references users(user_id),
        constraint fk_harvesinfo_id foreign key (crop_id) references crops(id)
        );
        


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
