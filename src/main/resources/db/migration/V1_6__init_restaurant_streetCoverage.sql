create TABLE restaurant_streetCoverage
(
    restaurant_streetCoverage_id    SERIAL       NOT NULL,
    restaurant_id                   INT             NOT NULL,
    streetCoverage_id               INT             NOT NULL,
    PRIMARY KEY (restaurant_streetCoverage_id),
    CONSTRAINT fk_restaurant_streetCoverage_restaurant
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurant (restaurant_id),
    CONSTRAINT fk_restaurant_streetCoverage_streetCoverage
        FOREIGN KEY (streetCoverage_id)
            REFERENCES streetCoverage (streetCoverage_id)
);