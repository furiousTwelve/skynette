CREATE DATABASE meteoSkynette;
CREATE TABLE City(
        idCity    Varchar (10) NOT NULL ,
        cityName  Varchar (50) NOT NULL ,
        longitude Float NOT NULL ,
        latitude  Float NOT NULL ,
        rainDay   Int NOT NULL ,
		imgRain		Blob DEFAULT LOAD_FILE('./icon_weather/wind.png'),
        sunDay    Int NOT NULL ,
		imgSun		Blob DEFAULT LOAD_FILE('./icon_weather/sun.png') ,
		hottestDay	Float NOT NULL,
		coldestDay	Float NOT NULL,
		amplitudeMax	Float NOT NULL,
		amplitudeMin	Float NOT NULL,
        countryName VARCHAR(50) NOT NULL ,
		
        PRIMARY KEY (idCity )
);




CREATE TABLE WeatherData(
		dateDay		  DateTime NOT NULL,     
        temperature   Float ,
        pressure      Float unsigned NOT NULL ,
        windSpeed     Float unsigned NOT NULL,
		windDirection VARCHAR(5) ,	
        rainfall      Float unsigned ,
        clouds        Int ,
        snow          Int ,
        idImg         Blob NOT NULL ,
		imgWind		Blob DEFAULT LOAD_FILE('./icon_weather/rain-1.png') ,
		PRIMARY KEY (dateDay)
);



CREATE TABLE Preview(
		id	Int NOT NULL,
		iconeTemps Blob NOT NULL,
		temperature Float NOT NULL,
		windDirection VARCHAR(5) NOT NULL,
		windSpeed Float NOT NULL,
		PRIMARY KEY (id)
);


