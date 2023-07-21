create TABLE menuItem
(
    menuItem_id         SERIAL          NOT NULL,
    name                VARCHAR(32)     NOT NULL,
    price               NUMERIC(8, 2)   NOT NULL,
    category            VARCHAR(32)     NOT NULL,
    description         TEXT            NOT NULL,
    restaurant_id       INT             NOT NULL,
    PRIMARY KEY (menuItem_id),
    CONSTRAINT fk_menuItem_restaurant
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurant (restaurant_id)
);