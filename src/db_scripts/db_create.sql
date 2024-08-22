--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-08-22 11:11:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 32996)
-- Name: banka; Type: TABLE; Schema: schema_bank; Owner: postgres
--

CREATE TABLE schema_bank.banka (
    pib bigint NOT NULL,
    naziv character varying,
    adresa character varying,
    kurs_evro double precision,
    kurs_dolar double precision,
    kurs_evro_dolar double precision
);


ALTER TABLE schema_bank.banka OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 32989)
-- Name: klijent; Type: TABLE; Schema: schema_bank; Owner: postgres
--

CREATE TABLE schema_bank.klijent (
    ime_prezime character varying,
    adresa character varying,
    jmbg bigint NOT NULL
);


ALTER TABLE schema_bank.klijent OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33038)
-- Name: racun; Type: TABLE; Schema: schema_bank; Owner: postgres
--

CREATE TABLE schema_bank.racun (
    tip_racuna bigint NOT NULL,
    jmbg bigint NOT NULL,
    pib bigint NOT NULL,
    iznos double precision,
    broj_racuna character varying NOT NULL
);


ALTER TABLE schema_bank.racun OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33031)
-- Name: tip_racuna; Type: TABLE; Schema: schema_bank; Owner: postgres
--

CREATE TABLE schema_bank.tip_racuna (
    id bigint NOT NULL,
    ime character varying
);


ALTER TABLE schema_bank.tip_racuna OWNER TO postgres;

--
-- TOC entry 4703 (class 2606 OID 33061)
-- Name: racun broj_racuna; Type: CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.racun
    ADD CONSTRAINT broj_racuna UNIQUE (broj_racuna);


--
-- TOC entry 4705 (class 2606 OID 33042)
-- Name: racun idr; Type: CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.racun
    ADD CONSTRAINT idr PRIMARY KEY (jmbg, pib, tip_racuna);


--
-- TOC entry 4697 (class 2606 OID 32995)
-- Name: klijent jmbg; Type: CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.klijent
    ADD CONSTRAINT jmbg PRIMARY KEY (jmbg);


--
-- TOC entry 4699 (class 2606 OID 33002)
-- Name: banka pib; Type: CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.banka
    ADD CONSTRAINT pib PRIMARY KEY (pib);


--
-- TOC entry 4701 (class 2606 OID 33035)
-- Name: tip_racuna tip_racuna_pkey; Type: CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.tip_racuna
    ADD CONSTRAINT tip_racuna_pkey PRIMARY KEY (id);


--
-- TOC entry 4706 (class 2606 OID 33053)
-- Name: racun banka; Type: FK CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.racun
    ADD CONSTRAINT banka FOREIGN KEY (pib) REFERENCES schema_bank.banka(pib);


--
-- TOC entry 4707 (class 2606 OID 33048)
-- Name: racun klijent; Type: FK CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.racun
    ADD CONSTRAINT klijent FOREIGN KEY (jmbg) REFERENCES schema_bank.klijent(jmbg);


--
-- TOC entry 4708 (class 2606 OID 33043)
-- Name: racun tip_racuna; Type: FK CONSTRAINT; Schema: schema_bank; Owner: postgres
--

ALTER TABLE ONLY schema_bank.racun
    ADD CONSTRAINT tip_racuna FOREIGN KEY (tip_racuna) REFERENCES schema_bank.tip_racuna(id);


-- Completed on 2024-08-22 11:11:55

--
-- PostgreSQL database dump complete
--
