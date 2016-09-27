
CREATE TABLE City(
        idCity    Varchar (10),
        cityName  Varchar (50),
        longitude Float,
        latitude  Float ,
        rainDay   Int ,
        sunDay    Int,		
		hottestDay	Float,
		coldestDay	Float,
		amplitudeMax	Float,
		amplitudeMin	Float,
        countryName VARCHAR(50) ,
		
        PRIMARY KEY (idCity )
);




CREATE TABLE WeatherData(
		dateDay		  DateTime,     
        temperature   Float ,
        pressure      Float unsigned ,
        windSpeed     Float unsigned,
		windDirection VARCHAR(5) ,	
        rainfall      Float unsigned ,
        clouds        Int ,
        snow          Int ,
        idImg         Blob,
		
		PRIMARY KEY (dateDay)
);



CREATE TABLE Preview(
		id	Int,
		iconeTemps Blob,
		temperature Float,
		windDirection VARCHAR(5),
		windSpeed Float,
		PRIMARY KEY (id)
);


