INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Motherboards', 'PC motherboards and accessories');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Processors', 'CPU processors for desktops and laptops');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Memory (RAM)', 'Computer RAM modules');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Storage', 'Hard drives, SSDs, and other storage devices');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Graphics Cards', 'GPUs and video cards for gaming and professional use');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Power Supplies', 'Power supply units for computers');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Cooling Systems', 'CPU coolers, fans, and liquid cooling systems');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Cases', 'PC cases and enclosures');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Monitors', 'Computer monitors and display screens');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Keyboards', 'Mechanical and membrane keyboards');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Mice', 'Computer mice and pointing devices');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Networking', 'Routers, modems, and network adapters');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Printers', 'Printers and printing supplies');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Laptops', 'Portable computers and accessories');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Software', 'Operating systems and software applications');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Speakers', 'Computer speakers and audio systems');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Headphones', 'Headsets and earphones for computers');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'Webcams', 'Webcams and video conferencing equipment');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'External Storage', 'External hard drives and SSDs');
INSERT INTO category (id, name, description) VALUES (nextval('category_seq'), 'USB Devices', 'USB drives, hubs, and accessories');


INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'ASUS ROG Strix Z590-E', 'High-performance gaming motherboard with Intel Z590 chipset', 50, 299.99, (SELECT id FROM category WHERE name = 'Motherboards'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Intel Core i9-11900K', '8-core, 16-thread CPU with up to 5.3 GHz clock speed', 100, 529.99, (SELECT id FROM category WHERE name = 'Processors'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Corsair Vengeance LPX 16GB', '16GB (2x8GB) DDR4 RAM, 3200MHz', 200, 89.99, (SELECT id FROM category WHERE name = 'Memory (RAM)'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Samsung 970 EVO Plus 1TB', '1TB NVMe M.2 SSD for fast data storage', 150, 149.99, (SELECT id FROM category WHERE name = 'Storage'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'NVIDIA GeForce RTX 3080', 'High-end gaming graphics card with 10GB GDDR6X memory', 30, 899.99, (SELECT id FROM category WHERE name = 'Graphics Cards'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Corsair RM850x', '850W fully modular power supply, 80+ Gold certified', 120, 129.99, (SELECT id FROM category WHERE name = 'Power Supplies'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Cooler Master Hyper 212', 'Air cooler with a 120mm PWM fan', 180, 39.99, (SELECT id FROM category WHERE name = 'Cooling Systems'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'NZXT H510', 'Mid-tower ATX case with tempered glass side panel', 90, 74.99, (SELECT id FROM category WHERE name = 'Cases'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Dell UltraSharp U2720Q', '27-inch 4K UHD monitor with USB-C connectivity', 60, 579.99, (SELECT id FROM category WHERE name = 'Monitors'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Logitech G Pro X', 'Mechanical gaming keyboard with GX Blue switches', 200, 129.99, (SELECT id FROM category WHERE name = 'Keyboards'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Razer DeathAdder V2', 'Ergonomic gaming mouse with optical sensor', 300, 49.99, (SELECT id FROM category WHERE name = 'Mice'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Netgear Nighthawk AX12', 'WiFi 6 router with up to 10.8Gbps speed', 80, 399.99, (SELECT id FROM category WHERE name = 'Networking'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'HP OfficeJet Pro 9025e', 'All-in-one wireless printer with smart features', 70, 229.99, (SELECT id FROM category WHERE name = 'Printers'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Apple MacBook Pro 16-inch', 'High-performance laptop with M1 Pro chip', 40, 2499.99, (SELECT id FROM category WHERE name = 'Laptops'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Microsoft Office 2021', 'Home & Business software suite', 500, 249.99, (SELECT id FROM category WHERE name = 'Software'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Logitech Z623', '2.1 speaker system with THX certification', 110, 149.99, (SELECT id FROM category WHERE name = 'Speakers'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'SteelSeries Arctis 7', 'Wireless gaming headset with surround sound', 150, 149.99, (SELECT id FROM category WHERE name = 'Headphones'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'Logitech C920', 'Full HD 1080p webcam with stereo audio', 250, 69.99, (SELECT id FROM category WHERE name = 'Webcams'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'WD My Passport 4TB', 'Portable external hard drive with USB 3.0', 200, 99.99, (SELECT id FROM category WHERE name = 'External Storage'));

INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (nextval('product_seq'), 'SanDisk Ultra 128GB', 'USB 3.0 flash drive with 100MB/s read speed', 400, 19.99, (SELECT id FROM category WHERE name = 'USB Devices'));


