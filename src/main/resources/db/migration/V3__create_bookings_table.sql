CREATE TABLE bookings (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    table_id BIGINT NOT NULL,
    FOREIGN KEY (table_id) REFERENCES restaurant_tables(id),
    booking_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    guests_count int NOT NULL,
    status VARCHAR NOT NULL
);