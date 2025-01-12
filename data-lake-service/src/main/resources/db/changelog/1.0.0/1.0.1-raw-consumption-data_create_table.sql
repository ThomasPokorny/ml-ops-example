CREATE TABLE raw_consumption_dat (
          id SERIAL PRIMARY KEY,
          data JSONB,
          date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
