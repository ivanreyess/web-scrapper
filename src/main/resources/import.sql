INSERT INTO db_web_scrapping.authorities ( authority) VALUES ('USER');
INSERT INTO db_web_scrapping.authorities ( authority) VALUES ('ADMIN');

INSERT INTO db_web_scrapping.users (account_non_expired, account_non_locked, birthdate, credentials_non_expired, enabled, email_address, first_name, last_name, password, username) VALUES (true, true, '2023-11-09', true, true,  'user@mail.com', 'user', 'user', '$2a$10$09cJbVQpz7nkgkpeHeC1Ou0OPv/qns.I0iiYjnbfP55YQGv8qbQZq', 'user@mail.com');
INSERT INTO db_web_scrapping.users (account_non_expired, account_non_locked, birthdate, credentials_non_expired, enabled, email_address, first_name, last_name, password, username) VALUES (true, true, '2023-11-09', true, true,  'admin@mail.com', 'admin', 'admin', '$2a$10$IWDpgkqlYZC2AmefCWIFY.oEalH0IpnCtWZhbZBw9G9MNoGN.BYfG', 'admin@mail.com');
INSERT INTO db_web_scrapping.users (account_non_expired, account_non_locked, birthdate, credentials_non_expired, enabled, email_address, first_name, last_name, password, username) VALUES (true, true, '2023-11-09', true, true,  'user2@mail.com', 'user2', 'user2', '$2a$10$09cJbVQpz7nkgkpeHeC1Ou0OPv/qns.I0iiYjnbfP55YQGv8qbQZq', 'user2@mail.com');

INSERT INTO db_web_scrapping.users_authorities (authorities_id, users_id) VALUES (1, 1);
INSERT INTO db_web_scrapping.users_authorities (authorities_id, users_id) VALUES (2, 2);
INSERT INTO db_web_scrapping.users_authorities (authorities_id, users_id) VALUES (1, 2);
