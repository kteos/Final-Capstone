drop table if exists harvest ;

begin transaction;
select * from harvest;
create table harvest(
        id serial,
        crop varchar(30) not null,
        direct_seed_to_harvest_time int not null,
        
        constraint pk_id primary key (id)
);

create table crops(
        id serial,
        area varchar(3) not null,
        crop varchar(30) not null,
        planting_date date not null,

        constraint pk_crops_id primary key (id)
);

insert into crops values (default, 'A4', 'corn', '2020-07-14');

insert into harvest values (default, 'corn', 90);

select * from harvest;

rollback transaction;

--CREATE TABLE users (
--	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
--	username varchar(50) NOT NULL,
--	password_hash varchar(200) NOT NULL,
--	role varchar(50) NOT NULL,
--	CONSTRAINT PK_user PRIMARY KEY (user_id)

INSERT INTO harvest (id, crop, direct_seed_to_harvest_time) VALUES (default, ?, ?) returning id;
INSERT INTO crops (id, area, crop, planting_date) VALUES (default, ?, ?, ?);
update crops set area = ?, planting_date = ? where crop = ?;
SELECT id, area, crop, planting_date FROM crops where crop = ?;

update crops set area = ?, crop = ?, planting_date = ? where id = ?;
