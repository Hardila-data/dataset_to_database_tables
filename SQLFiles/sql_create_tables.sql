-- -------------------------------------------
-- Table publisher 
-- -------------------------------------------

CREATE TABLE public.publisher
(
    "id_publisher" integer NOT NULL,
    "id_publisher_platform_fk" integer,
    "year" character varying(100),
    PRIMARY KEY ("id_publisher")
);

-- -------------------------------------------
-- Table publisher_platform
-- -------------------------------------------
CREATE TABLE public.publisher_platform
(

	"id_publisher_platform" integer NOT NULL,
	"publisher" character varying,
	"platform" character varying,
	PRIMARY KEY ("id_publisher_platform")

);
-- -------------------------------------------
-- Table game
-- -------------------------------------------
CREATE TABLE public.game
(
	"id_game" integer NOT NULL,
	"name_game" character varying,
	"genre" character varying,
	"id_publisher_fk" integer,
	PRIMARY KEY ("id_game"),	
	CONSTRAINT "id_publisher_fk"
	    FOREIGN KEY ("id_publisher_fk")
	 	REFERENCES public.publisher ("id_publisher")
		ON UPDATE CASCADE
		ON DELETE CASCADE
		NOT VALID
);


-- -----------------------------------------------
-- Table sales
-- -----------------------------------------------
CREATE TABLE public.sale
(
	"id_sale" integer NOT NULL,
	"NA_Sales" double precision,
	"EU_Sales" double precision,
	"JP_Sales" double precision,
	"Other_Sales" double precision,
	"Global_Sales" double precision,
	PRIMARY KEY ("id_sale")	
);


-- -----------------------------------------------
-- Table game_sales
-- -----------------------------------------------

CREATE TABLE public.game_sales(
	"id_game_sales" integer NOT NULL,
	"id_game_fk" integer,
	"id_publisher_fk" integer,
	id_sales_fk integer,
	PRIMARY KEY ("id_game_sales"),
	CONSTRAINT "id_game_fk"
		FOREIGN KEY ("id_game_fk")
		REFERENCES public.game ("id_game")
		ON UPDATE CASCADE
		ON DELETE CASCADE
		NOT VALID,
	CONSTRAINT "id_publisher_fk"
		FOREIGN KEY ("id_publisher_fk")
		REFERENCES public.publisher (id_publisher)
		ON UPDATE CASCADE
		ON DELETE CASCADE
		NOT VALID,
	CONSTRAINT "id_sales_fk" 
		FOREIGN KEY ("id_sales_fk")
		REFERENCES public.sale (id_sale)
		ON UPDATE CASCADE
		ON DELETE CASCADE
		NOT VALID
	
);



