INSERT INTO category (description) VALUES ('Developer Class 1');
INSERT INTO category (description) VALUES ('Developer Class 2');
INSERT INTO category (description) VALUES ('Developer Class 3');
INSERT INTO category (description) VALUES ('QA');
INSERT INTO category (description) VALUES ('Service & Admin');
INSERT INTO category (description) VALUES ('MES Support');
INSERT INTO category (description) VALUES ('BSAS, DBAS & PM');
INSERT INTO location (description) VALUES ('Plant A');
INSERT INTO location (description) VALUES ('Plant B');
INSERT INTO location (description) VALUES ('Plant C');
INSERT INTO location (description) VALUES ('Plant D');
INSERT INTO location (description) VALUES ('Plant E');
INSERT INTO location (description) VALUES ('UTEC');
INSERT INTO supervisor (first_name, last_name) VALUES ('Carlos','Zamora');
INSERT INTO supervisor (first_name, last_name) VALUES ('Enrique','Barberi');
INSERT INTO supervisor (first_name, last_name) VALUES ('Mireya','Rodriguez');
INSERT INTO supervisor (first_name, last_name) VALUES ('Lorena','Rodriguez');
INSERT INTO supervisor (first_name, last_name) VALUES ('Ricardo','Mejia');
INSERT INTO supervisor (first_name, last_name) VALUES ('Daniel','Soto');
INSERT INTO supervisor (first_name, last_name) VALUES ('Oscar','Lecea');
INSERT INTO bu (description) VALUES ('IT Shared');
INSERT INTO bu (description) VALUES ('A');
INSERT INTO bu (description) VALUES ('B');
INSERT INTO bu (description) VALUES ('Finance SS');
INSERT INTO bu (description) VALUES ('C');
INSERT INTO bu (description) VALUES ('D');
INSERT INTO bu (description) VALUES ('E');
INSERT INTO bu (description) VALUES ('UTEC');
INSERT INTO employee (email, first_name, last_name, middle_name, ssn, bu_id, category_id, location_id, supervisor_id)
       VALUES ('angelamelo@utc.com.mx', 'Angela', 'Melo', 'Erica', '0569874566', 1, 1, 1, 1);
INSERT INTO employee (email, first_name, last_name, middle_name, ssn, bu_id, category_id, location_id, supervisor_id)
       VALUES ('angrybirds@utc.com.mx', 'Ricardo', 'Treviso', 'Roque', '0588874566', 2, 3, 4, 2);
INSERT INTO employee (email, first_name, last_name, middle_name, ssn, bu_id, category_id, location_id, supervisor_id)
       VALUES ('arroyoolmo@utc.com.mx', 'Surish', 'Singh', 'Erlich', '0592874566', 3, 2, 1, 2);