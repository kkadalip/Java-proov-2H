INSERT INTO user (id, name)
    VALUES (1, 'john');

INSERT INTO user (id, name)
    VALUES (2, 'someone');

/*
 * comment
 */
-- single line comment
    
INSERT INTO user_sector (user_id, sector_id) VALUES (1, 1);
INSERT INTO user_sector (user_id, sector_id) VALUES (2, 2);


INSERT INTO sector (id, name) VALUES (1, 'Manufacturing');

INSERT INTO sector (id, name, parent_sector_id) VALUES (2, 'Construction materials',1);
INSERT INTO sector (id, name, parent_sector_id) VALUES (3, 'Electronics and Optics',1);
INSERT INTO sector (id, name, parent_sector_id) VALUES (4, 'Food and Beverage',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (5, 'Bakery & confectionery products',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (6, 'Beverages',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (7, 'Fish \& fish products',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (8, 'Meat \& meat products',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (9, 'Milk \& dairy products',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (10, 'Other',4);
INSERT INTO sector (id, name, parent_sector_id) VALUES (11, 'Sweets & snack food',4);

INSERT INTO sector (id, name, parent_sector_id) VALUES (12, 'Furniture',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (13, 'Bathroom/sauna',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (14, 'Bedroom',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (15, 'Children''s room',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (16, 'Kitchen',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (18, 'Living room',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (19, 'Office',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (20, 'Other (Furniture)',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (21, 'Outdoor',12);
INSERT INTO sector (id, name, parent_sector_id) VALUES (22, 'Project furniture',12);

INSERT INTO sector (id, name, parent_sector_id) VALUES (23, 'Machinery',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (24, 'Machinery components',23);
INSERT INTO sector (id, name, parent_sector_id) VALUES (25, 'Machinery equipment/tools',23);
INSERT INTO sector (id, name, parent_sector_id) VALUES (26, 'Manufacture of machinery',23);

INSERT INTO sector (id, name, parent_sector_id) VALUES (27, 'Maritime',23);

INSERT INTO sector (id, name, parent_sector_id) VALUES (28, 'Aluminium and steel workboats',27);
INSERT INTO sector (id, name, parent_sector_id) VALUES (29, 'Boat/Yacht building',27);
INSERT INTO sector (id, name, parent_sector_id) VALUES (30, 'Ship repair and conversion',27);

INSERT INTO sector (id, name, parent_sector_id) VALUES (31, 'Metal structures',23);
INSERT INTO sector (id, name, parent_sector_id) VALUES (32, 'Other',23);
INSERT INTO sector (id, name, parent_sector_id) VALUES (33, 'Repair and maintenance service',23);

INSERT INTO sector (id, name, parent_sector_id) VALUES (34, 'Metalworking',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (35, 'Construction of metal structures',34);
INSERT INTO sector (id, name, parent_sector_id) VALUES (36, 'Houses and buildings',34);
INSERT INTO sector (id, name, parent_sector_id) VALUES (37, 'Metal products',34);
INSERT INTO sector (id, name, parent_sector_id) VALUES (38, 'Metal works',34);

INSERT INTO sector (id, name, parent_sector_id) VALUES (39, 'CNC-machining',38);
INSERT INTO sector (id, name, parent_sector_id) VALUES (40, 'Forgings, Fasteners',38);
INSERT INTO sector (id, name, parent_sector_id) VALUES (41, 'Gas\, Plasma\, Laser cutting',38);
INSERT INTO sector (id, name, parent_sector_id) VALUES (42, 'MIG\, TIG\, Aluminium welding',38);

INSERT INTO sector (id, name, parent_sector_id) VALUES (43, 'Plastic and Rubber',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (44, 'Packaging',43);
INSERT INTO sector (id, name, parent_sector_id) VALUES (45, 'Plastic goods',43);
INSERT INTO sector (id, name, parent_sector_id) VALUES (45, 'Plastic processing technology',43);

INSERT INTO sector (id, name, parent_sector_id) VALUES (46, 'Blowing',45);
INSERT INTO sector (id, name, parent_sector_id) VALUES (47, 'Moulding',45);
INSERT INTO sector (id, name, parent_sector_id) VALUES (48, 'Plastics welding and processing',45);

INSERT INTO sector (id, name, parent_sector_id) VALUES (49, 'Plastic profiles',43);

INSERT INTO sector (id, name, parent_sector_id) VALUES (50, 'Printing',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (51, 'Advertising',50);
INSERT INTO sector (id, name, parent_sector_id) VALUES (52, 'Book/Periodicals printing',50);
INSERT INTO sector (id, name, parent_sector_id) VALUES (53, 'Labelling and packaging printing',50);

INSERT INTO sector (id, name, parent_sector_id) VALUES (54, 'Textile and Clothing',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (55, 'Clothing',54);
INSERT INTO sector (id, name, parent_sector_id) VALUES (56, 'Textile',54);

INSERT INTO sector (id, name, parent_sector_id) VALUES (57, 'Wood',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (58, 'Other (Wood)',57);
INSERT INTO sector (id, name, parent_sector_id) VALUES (59, 'Wooden building materials',57);
INSERT INTO sector (id, name, parent_sector_id) VALUES (60, 'Wooden houses',57);

INSERT INTO sector (id, name) VALUES (61, 'Other');

INSERT INTO sector (id, name, parent_sector_id) VALUES (62, 'Creative industries',61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (63, 'Energy technology',61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (64, 'Environment',61);

INSERT INTO sector (id, name) VALUES (61, 'Service');

INSERT INTO sector (id, name, parent_sector_id) VALUES (62, 'Business services', 61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (63, 'Engineering', 61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (64, 'Information Technology and Telecommunications', 61);

INSERT INTO sector (id, name, parent_sector_id) VALUES (65, 'Data processing\, Web portals\, E-marketing', 64);
INSERT INTO sector (id, name, parent_sector_id) VALUES (66, 'Programming\, Consultancy', 64);
INSERT INTO sector (id, name, parent_sector_id) VALUES (67, 'Software\, Hardware', 64);
INSERT INTO sector (id, name, parent_sector_id) VALUES (68, 'Telecommunications', 64);

INSERT INTO sector (id, name, parent_sector_id) VALUES (69, 'Tourism', 61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (70, 'Translation services', 61);
INSERT INTO sector (id, name, parent_sector_id) VALUES (71, 'Transport and Logistics', 61);

INSERT INTO sector (id, name, parent_sector_id) VALUES (72, 'Air', 71);
INSERT INTO sector (id, name, parent_sector_id) VALUES (73, 'Rail', 71);
INSERT INTO sector (id, name, parent_sector_id) VALUES (74, 'Road', 71);
INSERT INTO sector (id, name, parent_sector_id) VALUES (75, 'Water', 71);