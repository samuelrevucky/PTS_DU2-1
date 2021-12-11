DROP TABLE IF EXISTS stop;
DROP TABLE IF EXISTS line;
DROP TABLE IF EXISTS line_stop;
DROP TABLE IF EXISTS line_segment;

CREATE TABLE stop
(
    id   serial PRIMARY KEY NOT NULL,
    name VARCHAR(255)       NOT NULL
);

CREATE TABLE line
(
    id         serial PRIMARY KEY                                                                         NOT NULL,
    name       VARCHAR(255)                                                                               NOT NULL,
    first_stop INTEGER REFERENCES stop ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY IMMEDIATE NOT NULL
);

CREATE TABLE line_stop
(
    id      serial PRIMARY KEY                                                                         NOT NULL,
    stop_id INTEGER REFERENCES stop ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY IMMEDIATE NOT NULL,
    line_id INTEGER REFERENCES line ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY IMMEDIATE NOT NULL
);

CREATE TABLE line_segment
(
    id            serial PRIMARY KEY                                                                         NOT NULL,
    line_id       INTEGER REFERENCES line ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY IMMEDIATE NOT NULL,
    segment_index INTEGER                                                                                    NOT NULL,
    capacity      INTEGER                                                                                    NOT NULL,
    passengers    INTEGER                                                                                    NOT NULL,
    time_diff     INTEGER                                                                                    NOT NULL,
    UNIQUE (line_id, segment_index)
);


