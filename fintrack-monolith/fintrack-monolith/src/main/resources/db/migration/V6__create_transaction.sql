CREATE TABLE transactions (
    id                    UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    statement_id          UUID            NOT NULL REFERENCES monthly_statements(id),
    bank_account_id       UUID            NOT NULL REFERENCES bank_accounts(id),
    member_id             UUID            REFERENCES members(id),
    recurring_bill_id     UUID            REFERENCES recurring_bills(id),
    description           VARCHAR(150)    NOT NULL,
    value                 DECIMAL(10,2)   NOT NULL,
    transaction_bill_type VARCHAR(20)     NOT NULL,
    classification        VARCHAR(20)     NOT NULL,
    created_at            TIMESTAMP       NOT NULL DEFAULT now()
);