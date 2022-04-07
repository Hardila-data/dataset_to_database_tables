DELETE FROM public.publisher;
DELETE FROM public.game;
DELETE FROM public.sale;
DELETE FROM public.game_sales;
DELETE FROM public.publisher_platform;



--INSERT Publisher_platform
INSERT INTO public.publisher_platform(
	id_publisher_platform, Publisher, Platform)
	  VALUES (320,'Nintendo', 'Wii'),
	  	(321,'Nintendo', 'NES'),
	  	(322,'Nintendo', 'GB'),
	  	(323,'Nintendo', 'DS');


--INSERT Publisher
INSERT INTO public.publisher(
 id_publisher, id_publisher_platform_fk, year)
 VALUES (220,320, 2006.0),
 	(221,321, 1985.0),
 	(222,320, 2008.0),
 	(223,320, 2009.0);

-- INSERT GAME
INSERT INTO public.game(
	id_game, name_game, genre, id_publisher_fk)
	VALUES 	(440, 'Wii Sports', 'Sports', 220),
		(449, 'Super Mario Bros.', 'Platform', 221),
		(456, 'Mario Kart Wii', 'Racing', 222),
		(468, 'Wii Sports Resort', 'Sports', 223);


-- INSERT SALE
INSERT INTO public.sale(
	id_sale, "NA_Sales", "EU_Sales", "JP_Sales", "Other_Sales", "Global_Sales")
	values 	(620,41.49,29.02,3.77,8.46,82.74),
	 	(621,29.08,3.58,6.81,0.77,40.24),
	 	(622,15.85,12.88,3.79,3.31,35.82),
	 	(623,15.75,11.01,3.28,2.96,33.0);


-- INSERT GAME_SALES
INSERT INTO public.game_sales(
	id_game_sales, id_game_fk, id_publisher_fk, id_sales_fk)
	VALUES 	(160,440,220,620),
		(161,449,221,621),
	 	(162,456,222,622),
		(163,468,223,623);