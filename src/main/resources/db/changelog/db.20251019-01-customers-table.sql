CREATE TABLE customers
(
    id                    BINARY(16)  NOT NULL,
    created_at            TIMESTAMP    NOT NULL,
    updated_at            TIMESTAMP    NOT NULL,
    identification_number VARCHAR(32)  NOT NULL,
    first_name            VARCHAR(128) NOT NULL,
    last_name             VARCHAR(128) NOT NULL,
    email                 VARCHAR(256),
    phone_number          VARCHAR(32),
    PRIMARY KEY (id)
);