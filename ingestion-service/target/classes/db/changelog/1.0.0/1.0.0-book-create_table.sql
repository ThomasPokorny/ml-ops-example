CREATE TABLE public.BOOK
(
    ID     UUID        NOT NULL PRIMARY KEY,
    TITLE  TEXT        NOT NULL,
    AUTHOR TEXT        NOT NULL,
    ISBN   VARCHAR(50) NOT NULL
);