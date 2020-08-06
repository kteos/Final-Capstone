begin transaction;

create table harvest(
        id serial,
        crop varchar(30) not null,
        direct_seed_to_harvest_time int not null,
        
        constraint pk_id primary key (id)
);
create table expiration(
        id serial primary key,
        days_to_expire int
        );

create table harvest_expiration(
                expiration_id int,
                harvest_id int,
                constraint fk_expiration_id foreign key (expiration_id) references expiration(id),
                constraint fk_harvest_id foreign key (harvest_id) references harvest(id)
);

insert into harvest values (default, 'corn', 90);

rollback;

--CREATE TABLE users (
--	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
--	username varchar(50) NOT NULL,
--	password_hash varchar(200) NOT NULL,
--	role varchar(50) NOT NULL,
--	CONSTRAINT PK_user PRIMARY KEY (user_id)
