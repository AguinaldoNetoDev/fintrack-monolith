CREATE TABLE bank_accounts (
    id           UUID        PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id      UUID        NOT NULL REFERENCES users(id),
    name         VARCHAR(100) NOT NULL,
    account_type VARCHAR(20) NOT NULL
);