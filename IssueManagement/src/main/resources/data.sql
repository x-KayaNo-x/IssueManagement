INSERT INTO issues (summary, description, username, priorityId) VALUES ('バグA', 'バグがあります', 'tom', 1);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('修正A', '修正箇所があります', 'tom', 2);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('バグB', 'バグがあります', 'tom', 1);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('機能要望B', '追加機能Bが欲しいです', 1, 3);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('バグC', 'バグがあります', 'tom', 1);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('買い物', '食材の補充が必要', 'bob', 1);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('買い物', '日用品が切れている','bob', 2);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('作業A', '作業をする', 'ken', 2);
INSERT INTO issues (summary, description, username, priorityId) VALUES ('作業B', '作業をする', 'ken', 1);

INSERT INTO priority (id, priority) VALUES (1, '高');
INSERT INTO priority (id, priority) VALUES (2, '中');
INSERT INTO priority (id, priority) VALUES (3, '低');

-- password --
INSERT INTO users (username, password, authority) VALUES ('tom', '$2a$08$OqGyRm3IudPT3rOC9HlvbuHDfdKZqBxXaghzU.pn5xHLt/oIITHSK', 'USER');
INSERT INTO users (username, password, authority) VALUES ('bob', '$2a$08$OqGyRm3IudPT3rOC9HlvbuHDfdKZqBxXaghzU.pn5xHLt/oIITHSK', 'USER');
INSERT INTO users (username, password, authority) VALUES ('ken', '$2a$08$OqGyRm3IudPT3rOC9HlvbuHDfdKZqBxXaghzU.pn5xHLt/oIITHSK', 'ADMIN');
