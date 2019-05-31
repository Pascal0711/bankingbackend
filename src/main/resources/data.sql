INSERT INTO ADRESSE (id, STREET_NAME, street_number, POSTAL_CODE, city, country) VALUES
(199999999, 'Pflugfelderstraße', 68, 70439,'Stuttgart', 'Baden-Württemberg'),
(299999999, 'Kaiserstraße', 15, 60306, 'Frankfurt am Main', 'Hessen'),
(399999999, 'Leopoldstraße', 29, 80331, 'München', 'Bayern'),
(499999999, 'Untere Könungstraße', 31, 34123, 'Kassel', 'Hessen'),
(599999999, 'Lützowstraße', 5, 46236, 'Bottrop', 'Nordrhein-Westfalen'),
(699999999, 'Kennedy-Allee',14, 50423, 'Bonn', 'Nordrhein-Westfalen');

INSERT INTO CUSTOMER (id, ADRESSE_ID, CUSTOMER_LAST_NAME, CUSTOMER_PRE_NAME) VALUES
(199999999, 199999999, 'Schmitz', 'Franz-Josef'),
(299999999, 299999999, 'Schuster', 'Bettina'),
(399999999, 399999999, 'Erikson', 'Erik'),
(499999999, 499999999, 'Leonardo', 'Diovelli'),
(599999999, 599999999, 'Nagayaki', 'Kentaro'),	
(699999999, 699999999, 'Xhu', 'Shiu');

INSERT INTO ACCOUNT (ID, CUSTOMER_ID, BALANCE, IBAN, ACCOUNT_TYPE) VALUES
(199999999, 199999999, 14124.44, 'DE20500334964532098010', 'saving account'),
(299999999, 299999999, 3855.04, 'DE20500334962134322110', 'deposit account'),
(399999999, 399999999, -231.87, 'DE20500334963451657210', 'checking account'),
(499999999, 499999999, 13829.05, 'DE20500334968008101510', 'saving account'),
(599999999, 599999999, 99283.36, 'DE20500334967520290310', 'credit card account'),
(699999999, 699999999, 2837.37, 'DE20500334961350190910', 'deposit account');

