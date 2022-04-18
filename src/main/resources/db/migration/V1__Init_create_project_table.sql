create table project_entity
(
    id           uuid         not null
        constraint project_pkey
            primary key,
    created_time timestamp,
    updated_time timestamp,
    name         varchar(255) not null
        constraint uk_3k75vvu7mevyvvb5may5lj8k7
            unique,
    status       smallint     not null
);