create table user_project
(
    user_id    uuid not null
        constraint fk2o99abat0odrvgip56e11on8x
            references user_entity,
    project_id uuid not null
        constraint fkocfkr6u2yh3w1qmybs8vxuv1c
            references project_entity,
    constraint user_project_pkey
        primary key (user_id, project_id)
);
