Insert into schema_bank.tip_racuna(id,ime) VALUES (1, 'rsd');
Insert into schema_bank.tip_racuna(id,ime) VALUES (2, 'eur');
Insert into schema_bank.tip_racuna(id,ime) VALUES (3, 'usd');


Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (1, 'Kusanović and Sons', 'Kruševačka 5', '50', '69', '4');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (2, 'Gleđa, Drešević and Zipalović', 'Šumatovačka 632', '88', '82', '6');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (3, 'Ađanski - Vukelja', 'Ruzveltova 3', '81', '46', '5');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (4, 'Bocić - Ulemek', 'Oblakovska 4', '30', '03', '9');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (5, 'Ištoković - Kristić', '2. sokače 60', '49', '73', '6');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (6, 'Bivolarević, Kalendić and Sandalj', 'Dositejeva 5', '14', '57', '1');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (7, 'Kurnoga Inc', 'Ubska 251', '84', '94', '6');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (8, 'Balašević Group', 'Rankeova 9', '56', '39', '2');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (9, 'Vračar - Tatomirov', 'Emila Zole 3', '89', '30', '7');
Insert Into schema_bank.banka (pib, naziv, adresa, kurs_evro, kurs_dolar, kurs_evro_dolar) Values (10, 'Žirović Inc', 'Senjanina Ive 42', '21', '26', '8');

Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (1, 'Ognjen Radinović', 'Marije Bursać 463');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (2, 'Branimir Guzina', 'Majke Jevrosime 38');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (3, 'Gligorije Krasić', 'Kosovska 2');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (4, 'Vesna Martinac', 'Ušće 8');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (5, 'Leposava Vulčević', 'Lazara Savatića 78');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (6, 'Dušan Lučar', 'Džona Kenedija 1');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (7, 'Sara Velaja', 'Bose Milićević 224');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (8, 'Neda Alaković', 'Prote Mateje 64');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (9, 'Zora Ilin', 'Lipovačka 5');
Insert Into schema_bank.klijent (jmbg, ime_prezime, adresa) Values (10, 'Goran Kordulup-Kurilić', 'Deligradska 281');

Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('1', '4', '1', 1986.33,'123456' );
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('6', '4', '2', 7623.46, '234567');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('4', '8', '3', 8871.69, '345676');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('1', '4', '2', 745.49, '209385');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('3', '5', '1', 5403.56, '298566');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('9', '1', '1', 8384.36, '124513');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('7', '3', '2', 3386.17, '938641');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('9', '7', '2', 1462.86, '198353');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('7', '8', '3', 2863.82, '197365');
Insert Into schema_bank.racun (jmbg, pib, tip_racuna, iznos, broj_racuna) Values ('1', '1', '2', 615.18, '986546');
