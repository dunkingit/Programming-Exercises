DROP TABLE IF EXISTS amember, agroup, aevent, member_group, member_event;

CREATE TABLE amember (
    member_number serial,
	last_name varchar(50) NOT NULL,
    first_name varchar(50) NOT NULL,
	email_address varchar(65),
	phone_number BigInt, 
	dob date,
	reminder_email boolean,
    CONSTRAINT  member_number PRIMARY KEY(member_number)
);

CREATE TABLE agroup (
    group_number serial,
	group_name varchar(95),
	group_memeber_count int not null,
    CONSTRAINT group_number PRIMARY KEY(group_number)
);

Create table aevent(
	event_number serial,
	event_name varchar(95), 
	event_desc varchar(95), 
	start_time timestamp, 
	duration int NOT NULL,
	event_coordinator varchar(50),
	event_attendance int not null
);

CREATE table member_group(
	member_number int,
	group_number int,
	CONSTRAINT member_group PRIMARY KEY(member_number, group_number),
	CONSTRAINT member_number FOREIGN KEY (amember) REFERENCES amember(member_number),
	CONSTRAINT group_number FOREIGN KEY (agroup) REFERENCES agroup(group_number)
);

create table member_event(
	member_number int,
	event_number int,
	CONSTRAINT member_event PRIMARY KEY(member_number, event_number),
	CONSTRAINT member_number FOREIGN KEY (amember) REFERENCES amember(member_number),
	CONSTRAINT aevent FOREIGN KEY (aevent) REFERENCES aevent(event_number)
);


