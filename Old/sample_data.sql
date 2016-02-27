INSERT INTO user (id, name)
    VALUES (1, 'john');

INSERT INTO user (id, name)
    VALUES (2, 'someone');

/*
 * comment
 */
-- single line comment
    
--INSERT INTO user_sector (user_id, sector_id) VALUES (1, 3);
--INSERT INTO user_sector (user_id, sector_id) VALUES (2, 4);


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
INSERT INTO sector (id, name, parent_sector_id) VALUES (46, 'Plastic processing technology',43);

INSERT INTO sector (id, name, parent_sector_id) VALUES (47, 'Blowing',46);
INSERT INTO sector (id, name, parent_sector_id) VALUES (48, 'Moulding',46);
INSERT INTO sector (id, name, parent_sector_id) VALUES (49, 'Plastics welding and processing',46);

INSERT INTO sector (id, name, parent_sector_id) VALUES (50, 'Plastic profiles',43);

INSERT INTO sector (id, name, parent_sector_id) VALUES (51, 'Printing',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (52, 'Advertising',51);
INSERT INTO sector (id, name, parent_sector_id) VALUES (53, 'Book/Periodicals printing',51);
INSERT INTO sector (id, name, parent_sector_id) VALUES (54, 'Labelling and packaging printing',51);

INSERT INTO sector (id, name, parent_sector_id) VALUES (55, 'Textile and Clothing',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (56, 'Clothing',55);
INSERT INTO sector (id, name, parent_sector_id) VALUES (57, 'Textile',55);

INSERT INTO sector (id, name, parent_sector_id) VALUES (58, 'Wood',1);

INSERT INTO sector (id, name, parent_sector_id) VALUES (59, 'Other (Wood)',58);
INSERT INTO sector (id, name, parent_sector_id) VALUES (60, 'Wooden building materials',58);
INSERT INTO sector (id, name, parent_sector_id) VALUES (61, 'Wooden houses',58);

INSERT INTO sector (id, name) VALUES (62, 'Other');

INSERT INTO sector (id, name, parent_sector_id) VALUES (63, 'Creative industries',62);
INSERT INTO sector (id, name, parent_sector_id) VALUES (64, 'Energy technology',62);
INSERT INTO sector (id, name, parent_sector_id) VALUES (65, 'Environment',62);

INSERT INTO sector (id, name) VALUES (66, 'Service');

INSERT INTO sector (id, name, parent_sector_id) VALUES (67, 'Business services', 62);
INSERT INTO sector (id, name, parent_sector_id) VALUES (68, 'Engineering', 62);
INSERT INTO sector (id, name, parent_sector_id) VALUES (69, 'Information Technology and Telecommunications', 62);

INSERT INTO sector (id, name, parent_sector_id) VALUES (70, 'Data processing\, Web portals\, E-marketing', 69);
INSERT INTO sector (id, name, parent_sector_id) VALUES (71, 'Programming\, Consultancy', 69);
INSERT INTO sector (id, name, parent_sector_id) VALUES (72, 'Software\, Hardware', 69);
INSERT INTO sector (id, name, parent_sector_id) VALUES (73, 'Telecommunications', 69);

INSERT INTO sector (id, name, parent_sector_id) VALUES (74, 'Tourism', 66);
INSERT INTO sector (id, name, parent_sector_id) VALUES (75, 'Translation services', 66);
INSERT INTO sector (id, name, parent_sector_id) VALUES (76, 'Transport and Logistics', 66);

INSERT INTO sector (id, name, parent_sector_id) VALUES (77, 'Air', 76);
INSERT INTO sector (id, name, parent_sector_id) VALUES (78, 'Rail', 76);
INSERT INTO sector (id, name, parent_sector_id) VALUES (79, 'Road', 76);
INSERT INTO sector (id, name, parent_sector_id) VALUES (80, 'Water', 76);