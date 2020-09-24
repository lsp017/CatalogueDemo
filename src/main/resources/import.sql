insert  into products(id,name,currency,value,quantity,version) values (101,'Black Shirt','EUR','12.00',1,1);
insert  into products(id,name,currency,value,quantity,version) values (102,'Red Shirt','EUR','132.00',11,1);
insert  into products(id,name,currency,value,quantity,version) values (103,'Green Shirt','EUR','152.00',10,1);
insert  into products(id,name,currency,value,quantity,version) values (104,'Black Hat','EUR','32.00',12,1);
--insert  into products(id,name,currency,value,quantity,version) values (105,'Brown Hat','EUR','19.00',17,1);
--insert  into products(id,name,currency,value,quantity,version) values (106,'White Hat','EUR','132.00',1,1);
--insert  into products(id,name,currency,value,quantity,version) values (107,'Yellow Shorts','EUR','332.00',12,1);
--insert  into products(id,name,currency,value,quantity,version) values (108,'Black Shorts','EUR','198.00',17,1);
--insert  into products(id,name,currency,value,quantity,version) values (109,'Pink Shorts','EUR','162.00',1,1);
insert  into products(id,name,currency,value,quantity,version) values (110,'Blue Shorts','EUR','169.00',1,1);

insert  into products(id,name,currency,value,quantity,version) values (111,'Formal Black Shirt','EUR','799.00',1,1);
insert  into products(id,name,currency,value,quantity,version) values (112,'Formal White Shirt','EUR','899.00',11,1);
insert  into products(id,name,currency,value,quantity,version) values (113,'Casual Denim Shirt','EUR','152.00',10,1);
insert  into products(id,name,currency,value,quantity,version) values (114,'Orange Skirt','EUR','999.00',12,1);
--insert  into products(id,name,currency,value,quantity,version) values (115,'Polo T-Shirt','EUR','500.00',17,1);
--insert  into products(id,name,currency,value,quantity,version) values (116,'Blue Jeans','EUR','132.00',1,1);
insert  into products(id,name,currency,value,quantity,version) values (117,'Denim Jacket','EUR','332.00',12,1);
insert  into products(id,name,currency,value,quantity,version) values (118,'Formal Trousers','EUR','198.00',17,1);
--insert  into products(id,name,currency,value,quantity,version) values (119,'Little Black Dress','EUR','899.00',1,1);
--insert  into products(id,name,currency,value,quantity,version) values (120,'Pink Gown','EUR','650.00',1,1);

insert into categories (name, id) values ('Mens Wear',1001);
insert into categories (name, id) values ('Womens Wear',1002);
insert into categories (name, id) values ('Top Wear',1003);

insert into products_categories(product_id,category_id) values (101,1001);
insert into products_categories(product_id,category_id) values (101,1003);
insert into products_categories(product_id,category_id) values (102,1001);
insert into products_categories(product_id,category_id) values (102,1003);
insert into products_categories(product_id,categoyr_id) values (103,1001);
insert into products_categories(product_id,categoyr_id) values (103,1003);
insert into products_categories(product_id,category_id) values (104,1001);
--insert into products_categories(product_id,category_id) values (105,1001);
--insert into products_categories(product_id,category_id) values (106,1001);
--insert into products_categories(product_id,category_id) values (107,1001);
--insert into products_categories(product_id,category_id) values (108,1001);
--insert into products_categories(product_id,category_id) values (109,1001);
insert into products_categories(product_id,category_id) values (110,1001);

insert into products_categories(product_id,category_id) values (111,1002);
insert into products_categories(product_id,category_id) values (111,1003);
insert into products_categories(product_id,category_id) values (112,1002);
insert into products_categories(product_id,category_id) values (112,1003);
insert into products_categories(product_id,category_id) values (113,1002);
insert into products_categories(product_id,category_id) values (113,1003);
insert into products_categories(product_id,category_id) values (114,1002);
--insert into products_categories(product_id,category_id) values (115,1002);
--insert into products_categories(product_id,category_id) values (115,1003);
--insert into products_categories(product_id,category_id) values (116,1002);
insert into products_categories(product_id,category_id) values (117,1002);
insert into products_categories(product_id,category_id) values (117,1003);
insert into products_categories(product_id,category_id) values (118,1002);
--insert into products_categories(product_id,category_id) values (119,1002);
--insert into products_categories(product_id,category_id) values (120,1002);
