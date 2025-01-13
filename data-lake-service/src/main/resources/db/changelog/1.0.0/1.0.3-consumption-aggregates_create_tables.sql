CREATE TABLE daily_consumption_data (
      id SERIAL PRIMARY KEY,
      device VARCHAR(255) NOT NULL,
      date DATE NOT NULL,
      value DOUBLE PRECISION NOT NULL DEFAULT 0
);

CREATE TABLE weekly_consumption_data (
    id SERIAL PRIMARY KEY,
    device VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    value DOUBLE PRECISION NOT NULL DEFAULT 0
);

CREATE TABLE monthly_consumption_data (
     id SERIAL PRIMARY KEY,
     device VARCHAR(255) NOT NULL,
     date DATE NOT NULL,
     value DOUBLE PRECISION NOT NULL DEFAULT 0
);
