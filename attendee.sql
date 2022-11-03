-- Names in SQL must begin with a letter (a-z) or underscore (_).
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling.

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS attendee CASCADE;
CREATE SCHEMA attendee;
SET search_path TO attendee;

--

CREATE TABLE attendee
(
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    phone INTEGER(8) PRIMARY KEY,
    passwordHash VARCHAR(200) NOT NULL,
    passwordSalt BYTEA NOT NULL,
    gender CHAR CHECK (gender='M' OR gender='K') NOT NULL,
);

--