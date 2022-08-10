INSERT INTO tb_link(shortened_link, original_link, deleted_at) VALUES ('goo22gle.com', 'link.com4id' , false);
INSERT INTO tb_link(shortened_link, original_link, deleted_at) VALUES ('goo33gle.com', 'link.comvdid', false);
INSERT INTO tb_link(shortened_link, original_link, deleted_at) VALUES ('goo44gle.com', 'link.comvrid', false);
INSERT INTO tb_link(shortened_link, original_link, deleted_at) VALUES ('googffle.com', 'link.comviad', false);

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
