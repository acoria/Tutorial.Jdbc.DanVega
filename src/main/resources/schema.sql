DROP TABLE IF EXISTS animal;
CREATE TABLE animal (
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    habitat varchar(100) NOT NULL,
    PRIMARY KEY (id)
)