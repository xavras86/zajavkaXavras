CREATE TABLE food_ordering_user
(
    user_id   SERIAL        NOT NULL,
    user_name VARCHAR(32)   NOT NULL,
    email     VARCHAR(32)   NOT NULL,
    password  VARCHAR(128)  NOT NULL,
    active    BOOLEAN       NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE food_ordering_role
(
    role_id SERIAL      NOT NULL,
    role    VARCHAR(20) NOT NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE food_ordering_user_role
(
    user_id   INT      NOT NULL,
    role_id   INT      NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_food_ordering_user_role_user
        FOREIGN KEY (user_id)
            REFERENCES food_ordering_user (user_id),
    CONSTRAINT fk_food_ordering_user_role_role
        FOREIGN KEY (role_id)
            REFERENCES food_ordering_role (role_id)
);