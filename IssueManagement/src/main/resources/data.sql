INSERT INTO issues (summary, description, userId, priorityId) VALUES ('バグA', 'バグがあります', 1, 1);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('修正A', '修正箇所があります', 1, 2);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('バグB', 'バグがあります', 1, 1);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('機能要望B', '追加機能Bが欲しいです', 1, 3);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('バグC', 'バグがあります', 1, 1);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('買い物', '食材の補充が必要', 2, 1);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('買い物', '日用品が切れている', 2, 2);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('作業A', '作業をする', 3, 2);
INSERT INTO issues (summary, description, userId, priorityId) VALUES ('作業B', '作業をする', 1, 1);

INSERT INTO priority (id, priority) VALUES (1, '高');
INSERT INTO priority (id, priority) VALUES (2, '中');
INSERT INTO priority (id, priority) VALUES (3, '低');

INSERT INTO users (id, username, password, authority) VALUES (1, 'tom', 'password', 'USER');
INSERT INTO users (id, username, password, authority) VALUES (2, 'bob', 'password', 'USER');
INSERT INTO users (id, username, password, authority) VALUES (3, 'ken', 'password', 'USER');
