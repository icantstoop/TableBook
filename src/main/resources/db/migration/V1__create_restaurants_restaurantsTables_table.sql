CREATE TABLE restaurants (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    description TEXT,
    opening_time TIME,
    closing_time TIME
);

CREATE TABLE restaurant_tables (
    id BIGSERIAL PRIMARY KEY,
    table_number int NOT NULL,
    capacity int NOT NULL,
    restaurant_id BIGINT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);