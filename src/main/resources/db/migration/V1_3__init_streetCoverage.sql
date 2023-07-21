create TABLE streetCoverage
(
    streetCoverage_id   SERIAL      NOT NULL,
    city                VARCHAR(32) NOT NULL,
    street              VARCHAR(64) NOT NULL,
    PRIMARY KEY (streetCoverage_id)
);
