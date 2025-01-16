create table if not exists masini (
                                      numarInmatriculare CHAR(10) PRIMARY KEY,
                                      marca VARCHAR(50),
                                      anulFabricatiei INT,
                                      culoarea VARCHAR(30),
                                      nrKm INT
                                  );

