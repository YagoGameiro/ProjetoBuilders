CREATE TABLE CLIENTES(
      ID                  NUMBER NOT NULL ENABLE PRIMARY KEY,
      NAME                VARCHAR2(50) NOT NULL ENABLE,
      EMAIL               VARCHAR2(50),
      BIRTH_DATE          DATE NOT NULL ENABLE,
      CREATED_DATE        DATE DEFAULT SYSDATE
 );

CREATE SEQUENCE  "CLIENTES_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

--GRANT SELECT CLIENTES TO owners;
--grant select, update, insert, delete on CLIENTES to owners;

comment on column CLIENTES.CREATED_DATE
     IS 'Data de inserção na tabela';
comment on column CLIENTES.CREATED_DATE
     IS 'Data de nascimento do cliente';
     
     SELECT * FROM CLIENTES;
     
     DELETE FROM CLIENTES;