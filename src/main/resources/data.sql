-- SET FOREIGN_KEY_CHECKS=0
INSERT INTO hotel (id, name, address, description, rating, active)
VALUES (UUID(), 'Hotel Sunrise', '123 Beach Blvd',
        'Nestled on the golden sands of the coastline, Hotel Sunrise offers breathtaking ocean views and the soothing sound of waves. Wake up to mesmerizing sunrises, enjoy fresh seafood at our beachfront restaurant, and unwind with a cocktail as the sun sets over the horizon.',
        4.5, true),

       (UUID(), 'Mountain View Resort', '456 Mountain Rd',
        'Perched amidst towering peaks, Mountain View Resort is a haven for nature lovers and adventure seekers. Breathe in the crisp mountain air, explore scenic hiking trails, and relax by the fireplace in our cozy lodge. An escape to tranquility awaits you.',
        4.8, true),

       (UUID(), 'Urban Hotel Central', '789 Downtown Ave',
        'Located in the vibrant heart of the city, Urban Hotel Central puts you just steps away from the best restaurants, shopping, and nightlife. With modern rooms, a rooftop bar, and easy access to cultural landmarks, it’s the perfect place for both business and leisure travelers.',
        4.3, true),

       (UUID(), 'Country Side Hotel', '101 Country Road',
        'Surrounded by rolling green fields and charming farmsteads, Country Side Hotel offers a peaceful retreat from the hustle and bustle of city life. Enjoy fresh organic breakfasts, long countryside walks, and the warm hospitality of a cozy, rustic setting.',
        4.7, true),

       (UUID(), 'Lakeside Inn', '234 Lake Rd',
        'Tucked away on the edge of a crystal-clear lake, Lakeside Inn is the ultimate getaway for nature lovers and fishing enthusiasts. Enjoy tranquil mornings on a kayak, evenings by the bonfire, and comfortable rooms that offer stunning water views.',
        4.9, true),

       (UUID(), 'Grand Heritage Hotel', '345 Royal Blvd',
        'Step into a world of timeless elegance at Grand Heritage Hotel, where history and luxury meet. Located in a historic district, this hotel features opulent decor, antique furnishings, and a grand ballroom. Indulge in gourmet dining and experience the charm of a bygone era.',
        4.6, true),

       (UUID(), 'Airport Gateway Hotel', '567 Airport Rd',
        'Designed for travelers on the go, Airport Gateway Hotel offers modern comfort just minutes from the airport. Enjoy soundproofed rooms, express check-in services, and a 24/7 café to make your journey seamless and stress-free.',
        4.2, true),

       (UUID(), 'Coastline Bungalow', '678 Coastal Rd',
        'A hidden paradise by the ocean, Coastline Bungalow offers private villas with panoramic sea views. Wake up to the gentle sea breeze, lounge on your private terrace, and soak in the tropical serenity of an idyllic beachfront escape.',
        4.4, true),

       (UUID(), 'Sky High Hotel', '890 Metropolitan St',
        'Rising above the city skyline, Sky High Hotel offers breathtaking panoramic views from every room. Experience luxury in the clouds with a rooftop infinity pool, world-class dining, and a sky lounge that lets you see the city from a whole new perspective.',
        4.8, true),

       (UUID(), 'Health Resort', '901 Wellness Blvd',
        'Immerse yourself in relaxation and rejuvenation at Health Resort. With holistic spa treatments, yoga retreats, and fresh organic cuisine, our wellness sanctuary is designed to nourish both body and mind. Escape the stress and embrace serenity.',
        4.7, true);



-- INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available)
-- VALUES
--     (UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 101, 100.00, TRUE),
-- (UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 102, 150.00, FALSE),
-- (UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 201, 200.00, TRUE),
-- (UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 301, 140.00, TRUE),
-- (UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 401, 120.00, FALSE),
-- (UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 501, 220.00, TRUE);

-- Rooms for Hotel Sunrise (15 стаи: номера 101-115)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 101, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 102, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 103, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 104, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SINGLE', 105, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 106, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 107, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 108, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 109, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'DOUBLE', 110, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SUITE', 111, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SUITE', 112, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SUITE', 113, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SUITE', 114, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Hotel Sunrise' LIMIT 1), 'SUITE', 115, 200.00, TRUE, FALSE);


-- Rooms for Mountain View Resort (15 стаи: номера 201-215)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SINGLE', 201, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SINGLE', 202, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SINGLE', 203, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SINGLE', 204, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SINGLE', 205, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'DOUBLE', 206, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'DOUBLE', 207, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'DOUBLE', 208, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'DOUBLE', 209, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'DOUBLE', 210, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 211, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 212, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 213, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 214, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Mountain View Resort' LIMIT 1), 'SUITE', 215, 200.00, TRUE, FALSE);


-- Rooms for Urban Hotel Central (15 стаи: номера 301-315)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SINGLE', 301, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SINGLE', 302, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SINGLE', 303, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SINGLE', 304, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SINGLE', 305, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 306, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 307, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 308, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 309, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'DOUBLE', 310, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SUITE', 311, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SUITE', 312, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SUITE', 313, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SUITE', 314, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Urban Hotel Central' LIMIT 1), 'SUITE', 315, 200.00, TRUE, FALSE);


-- Rooms for Country Side Hotel (15 стаи: номера 401-415)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SINGLE', 401, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SINGLE', 402, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SINGLE', 403, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SINGLE', 404, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SINGLE', 405, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'DOUBLE', 406, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'DOUBLE', 407, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'DOUBLE', 408, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'DOUBLE', 409, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'DOUBLE', 410, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 411, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 412, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 413, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 414, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Country Side Hotel' LIMIT 1), 'SUITE', 415, 200.00, TRUE, FALSE);


-- Rooms for Lakeside Inn (15 стаи: номера 501-515)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SINGLE', 501, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SINGLE', 502, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SINGLE', 503, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SINGLE', 504, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SINGLE', 505, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'DOUBLE', 506, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'DOUBLE', 507, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'DOUBLE', 508, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'DOUBLE', 509, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'DOUBLE', 510, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 511, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 512, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 513, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 514, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Lakeside Inn' LIMIT 1), 'SUITE', 515, 200.00, TRUE, FALSE);


-- Rooms for Grand Heritage Hotel (15 стаи: номера 601-615)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SINGLE', 601, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SINGLE', 602, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SINGLE', 603, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SINGLE', 604, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SINGLE', 605, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'DOUBLE', 606, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'DOUBLE', 607, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'DOUBLE', 608, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'DOUBLE', 609, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'DOUBLE', 610, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SUITE', 611, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SUITE', 612, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SUITE', 613, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SUITE', 614, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Grand Heritage Hotel' LIMIT 1), 'SUITE', 615, 200.00, TRUE, FALSE);


-- Rooms for Airport Gateway Hotel (15 стаи: номера 701-715)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SINGLE', 701, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SINGLE', 702, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SINGLE', 703, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SINGLE', 704, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SINGLE', 705, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'DOUBLE', 706, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'DOUBLE', 707, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'DOUBLE', 708, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'DOUBLE', 709, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'DOUBLE', 710, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SUITE', 711, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SUITE', 712, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SUITE', 713, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SUITE', 714, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Airport Gateway Hotel' LIMIT 1), 'SUITE', 715, 200.00, TRUE, FALSE);


-- Rooms for Coastline Bungalow (15 стаи: номера 801-815)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SINGLE', 801, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SINGLE', 802, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SINGLE', 803, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SINGLE', 804, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SINGLE', 805, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'DOUBLE', 806, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'DOUBLE', 807, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'DOUBLE', 808, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'DOUBLE', 809, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'DOUBLE', 810, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SUITE', 811, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SUITE', 812, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SUITE', 813, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SUITE', 814, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Coastline Bungalow' LIMIT 1), 'SUITE', 815, 200.00, TRUE, FALSE);


-- Rooms for Sky High Hotel (15 стаи: номера 901-915)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SINGLE', 901, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SINGLE', 902, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SINGLE', 903, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SINGLE', 904, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SINGLE', 905, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'DOUBLE', 906, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'DOUBLE', 907, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'DOUBLE', 908, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'DOUBLE', 909, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'DOUBLE', 910, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SUITE', 911, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SUITE', 912, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SUITE', 913, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SUITE', 914, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Sky High Hotel' LIMIT 1), 'SUITE', 915, 200.00, TRUE, FALSE);


-- Rooms for Health Resort (15 стаи: номера 1001-1015)
INSERT INTO room (id, hotel_id, room_type, room_number, price_per_night, available, reserved)
VALUES (UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SINGLE', 1001, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SINGLE', 1002, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SINGLE', 1003, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SINGLE', 1004, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SINGLE', 1005, 100.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'DOUBLE', 1006, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'DOUBLE', 1007, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'DOUBLE', 1008, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'DOUBLE', 1009, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'DOUBLE', 1010, 150.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SUITE', 1011, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SUITE', 1012, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SUITE', 1013, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SUITE', 1014, 200.00, TRUE, FALSE),
(UUID(), (SELECT id FROM hotel WHERE name = 'Health Resort' LIMIT 1), 'SUITE', 1015, 200.00, TRUE, FALSE);
