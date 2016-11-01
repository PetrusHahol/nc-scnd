drop table flight;
drop table brigade;
drop table pilot;
drop table navigator;
drop table stewardess;
drop table radioman;
drop table information;
drop table gregorian_calendar;


CREATE TABLE Gregorian_calendar(
  id SERIAL NOT NULL PRIMARY KEY,
  year integer,
  mount integer,
  day integer,
  hour integer,
  minute integer,
  second integer
);

CREATE TABLE Information(
  id SERIAL NOT NULL PRIMARY KEY,
  age INT NOT NULL,
  height INT NOT NULL,
  experience INT NOT NULL,
  passport_data varchar
  );

CREATE TABLE Pilot(
  id SERIAL NOT NULL PRIMARY KEY,
  mileage INT NOT NULL,
  id_information INT NOT NULL,
  FOREIGN KEY(id_information) REFERENCES information(id)
);



CREATE TABLE Radioman(
  id SERIAL NOT NULL PRIMARY KEY,
  count_foreign INT NOT NULL,
  id_information INT NOT NULL,
  FOREIGN KEY(id_information) REFERENCES information(id)
);

CREATE TABLE Stewardess(
  id SERIAL NOT NULL PRIMARY KEY,
  length_waist INT NOT NULL,
  id_information INT NOT NULL,
  FOREIGN KEY(id_information) REFERENCES information(id)
);

CREATE TABLE Navigator(
  id SERIAL NOT NULL PRIMARY KEY,
  category Varchar,
  id_information INT NOT NULL,
  FOREIGN KEY(id_information) REFERENCES information(id)
);


CREATE TABLE Brigade(
  id SERIAL NOT NULL PRIMARY KEY,
  id_first_pilot INT NOT NULL,
  id_second_pilot INT NOT NULL,
  id_navigator INT NOT NULL,
  id_radioman INT NOT NULL,
  id_stewardess INT NOT NULL,
  FOREIGN KEY(id_first_pilot) REFERENCES pilot(id),
  FOREIGN KEY(id_second_pilot) REFERENCES pilot(id),
  FOREIGN KEY(id_navigator) REFERENCES navigator(id),
  FOREIGN KEY(id_radioman) REFERENCES radioman(id),
  FOREIGN KEY(id_stewardess) REFERENCES stewardess(id)
);
CREATE TABLE Flight(
  id SERIAL NOT NULL PRIMARY KEY,
  id_calendar INT NOT NULL,
  id_brigade INT,
  FOREIGN KEY(id_calendar) REFERENCES gregorian_calendar(id),
  FOREIGN KEY(id_brigade) REFERENCES brigade(id)
);
