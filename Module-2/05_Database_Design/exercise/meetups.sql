DROP TABLE IF EXISTS amember, agroup, aevent, member_group, member_event;

CREATE TABLE amember (
    member_number serial PRIMARY KEY,
    last_name varchar(50) NOT NULL,
    first_name varchar(50) NOT NULL,
    email_address varchar(65),
    phone_number bigint,
    dob date,
    reminder_email boolean
);

CREATE TABLE agroup (
    group_number serial PRIMARY KEY,
    group_name varchar(95) UNIQUE NOT NULL,
    group_member_count int NOT NULL DEFAULT 0
);

CREATE TABLE aevent (
    event_number serial PRIMARY KEY,
    event_name varchar(95) NOT NULL,
    event_desc varchar(95),
    start_time timestamp NOT NULL,
    duration int CHECK (duration >= 30) NOT NULL,
    group_number int,
    CONSTRAINT fk_group FOREIGN KEY (group_number) REFERENCES agroup(group_number)
);

CREATE TABLE member_group (
    member_number int,
    group_number int,
    PRIMARY KEY (member_number, group_number),
    CONSTRAINT fk_member_membergroup FOREIGN KEY (member_number) REFERENCES amember(member_number),
    CONSTRAINT fk_group_membergroup FOREIGN KEY (group_number) REFERENCES agroup(group_number)
);

CREATE TABLE member_event (
    member_number int,
    event_number int,
    PRIMARY KEY (member_number, event_number),
    CONSTRAINT fk_member_memberevent FOREIGN KEY (member_number) REFERENCES amember(member_number),
    CONSTRAINT fk_event_memberevent FOREIGN KEY (event_number) REFERENCES aevent(event_number)
);


