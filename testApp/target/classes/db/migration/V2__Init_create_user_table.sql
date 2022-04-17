create table user_entity
(
    id           uuid         not null
        constraint user_entity_pkey
            primary key,
    created_time timestamp,
    updated_time timestamp,
    full_name    varchar(255) not null,
    login_name   varchar(255) not null
        constraint uk_i2338v2dgg5dipdringm785n
            unique,
    password     varchar(255) not null
);
