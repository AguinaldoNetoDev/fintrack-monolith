CREATE TABLE monthly_statements (
    id          UUID        PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id     UUID        NOT NULL REFERENCES users(id),
    reference   VARCHAR(7)  NOT NULL,
    status      VARCHAR(10) NOT NULL DEFAULT 'OPEN',
    created_at  TIMESTAMP   NOT NULL DEFAULT now(),
    CONSTRAINT uq_user_reference UNIQUE (user_id, reference)
);