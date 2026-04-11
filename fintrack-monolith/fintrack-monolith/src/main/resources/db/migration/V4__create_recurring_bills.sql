CREATE TABLE recurring_bills (
     id                UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
     user_id           UUID            NOT NULL REFERENCES users(id),
     bank_account_id   UUID            NOT NULL REFERENCES bank_accounts(id),
     member_id         UUID            REFERENCES members(id),
     description       VARCHAR(150)    NOT NULL,
     reference_value   DECIMAL(10,2),
     recurring_bill_type         VARCHAR(20)     NOT NULL,
     active            BOOLEAN         NOT NULL DEFAULT true
);