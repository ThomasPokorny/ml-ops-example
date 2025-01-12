CREATE TABLE consumption_data (
          id SERIAL PRIMARY KEY,
          date_time TIMESTAMP NOT NULL,
          device VARCHAR(255) NOT NULL,
          value DOUBLE PRECISION NOT NULL,
          metadata JSONB
);
