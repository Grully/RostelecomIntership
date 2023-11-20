CREATE TABLE groups
(
    id SERIAL PRIMARY KEY,
    studyPlan character varying(30)[]

);

CREATE TABLE students

(
    id SERIAL PRIMARY KEY,
    lastName CHARACTER VARYING(30),
    firstName CHARACTER VARYING(30),
    age INTEGER,
    group_id SERIAL REFERENCES groups(id)
);

CREATE TABLE performance

(
    id SERIAL REFERENCES students(id),
    physics INTEGER,
    mathematics INTEGER,
    russian INTEGER,
    literature INTEGER,
    geometry INTEGER,
    informatics INTEGER
);







