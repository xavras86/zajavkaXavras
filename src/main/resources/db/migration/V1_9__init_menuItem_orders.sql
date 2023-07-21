create TABLE menuItem_orders
(
    menuItem_orders_id          SERIAL          NOT NULL,
    quantity                    INT             NOT NULL,
    menuItem_id                 INT             NOT NULL,
    orders_id                    INT            NOT NULL,
    PRIMARY KEY (menuItem_id),
    CONSTRAINT fk_menuItem_orders_menuItem
        FOREIGN KEY (menuItem_id)
            REFERENCES menuItem (menuItem_id),
    CONSTRAINT fk_menuItem_orders_orders
        FOREIGN KEY (orders_id)
            REFERENCES orders (orders_id)
);