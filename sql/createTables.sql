CREATE TABLE Answer
(
    id             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    likes          INTEGER DEFAULT 0 NOT NULL,
    dislikes       INTEGER DEFAULT 0 NOT NULL,
    acceptedAnswer INTEGER DEFAULT 0 NOT NULL,
    labels         TEXT,
    entryId        INTEGER NOT NULL
);

INSERT INTO Answer (id, likes, dislikes, acceptedAnswer, labels, entryId)
VALUES (1, 0, 0, 0, NULL, 4);

CREATE TABLE Entry
(
    id                 INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "text"             TEXT    NOT NULL,
    "user"             TEXT,
    creationDateTime   TEXT    NOT NULL,
    questionIdentifier TEXT
);


INSERT INTO Entry (id, "text", "user", creationDateTime, questionIdentifier)
VALUES (1, 'Some question text', 'Agris', '2021-10-24T10:34:15.784963', '0first'),
       (2, 'What is you favorite color?', 'Test', '2021-10-24T10:34:15.823909', '1second'),
       (3, 'What is the meaning of life?', 'Agris', '2021-10-24T10:34:15.823960', '2third'),
       (4, 'Some generic Test answer', 'OtherTest', '2021-10-24T10:58:52.184152', '1second'),
       (5, 'This did not answer anythign', 'Anonymous', '2021-10-24T11:58:52.184152', NULL);


CREATE TABLE Comments
(
    id               INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    answerIdentifier INTEGER,
    entryId          INTEGER NOT NULL
);

INSERT INTO Comments (id, answerIdentifier, entryId)
VALUES (1, 1, 5);

CREATE TABLE Question
(
    id      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    score   INTEGER DEFAULT 0,
    entryId INTEGER NOT NULL
);

INSERT INTO Question (id, score, entryId)
VALUES (1, 0, 1);