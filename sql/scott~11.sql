DROP TABLE ANSWER;
DROP TABLE QUESTION;

CREATE TABLE QUESTION(
    ID              NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    SUBJECT         NVARCHAR2(20),
    CONTENT         NVARCHAR2(1000),
    CREATE_DATE     DATE
);

CREATE TABLE ANSWER(
    ID              NUMBER(10)  GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    QUESTION_ID     NUMBER(10),
    CONTENT         NVARCHAR2(1000),
    CREATE_DATE     DATE,
    CONSTRAINT      fk_question     FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE        
);

SELECT * FROM QUESTION;
SELECT * FROM ANSWER;

