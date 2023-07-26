create TABLE menu_item_orders
(
    menuItem_orders_id          SERIAL          NOT NULL,
    quantity                    INT             NOT NULL,
    menuItem_id                 INT             NOT NULL,
    orders_id                    INT            NOT NULL,
    PRIMARY KEY (menuItem_id),
    CONSTRAINT fk_menu_item_orders_menu_item
        FOREIGN KEY (menuItem_id)
            REFERENCES menu_item (menuItem_id),
    CONSTRAINT fk_menu_item_orders_orders
        FOREIGN KEY (orders_id)
            REFERENCES orders (orders_id)
);