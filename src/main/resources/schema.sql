CREATE TABLE animal (
    id integer identity NOT NULL,
    name varchar(50) NOT NULL,
    habitat varchar(100) NOT NULL,
    CONSTRAINT pk_animal_id PRIMARY KEY (id)
);