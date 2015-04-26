if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARGO') and o.name = 'FK_CARGO_REFERENCE_FUNCIONA')
alter table CARGO
   drop constraint FK_CARGO_REFERENCE_FUNCIONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLIENTEREVENDEDOR') and o.name = 'FK_CLIENTER_REFERENCE_NOTAFISC')
alter table CLIENTEREVENDEDOR
   drop constraint FK_CLIENTER_REFERENCE_NOTAFISC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('FUNCIONARIO') and o.name = 'FK_FUNCIONA_REFERENCE_CARGO')
alter table FUNCIONARIO
   drop constraint FK_FUNCIONA_REFERENCE_CARGO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('NOTAFISCAL') and o.name = 'FK_NOTAFISC_REFERENCE_PRODUTO')
alter table NOTAFISCAL
   drop constraint FK_NOTAFISC_REFERENCE_PRODUTO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('NOTAFISCAL') and o.name = 'FK_NOTAFISC_REFERENCE_FUNCIONA')
alter table NOTAFISCAL
   drop constraint FK_NOTAFISC_REFERENCE_FUNCIONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SAIDADEPRODUTOS') and o.name = 'FK_SAIDADEP_REFERENCE_PRODUTO')
alter table SAIDADEPRODUTOS
   drop constraint FK_SAIDADEP_REFERENCE_PRODUTO
go

alter table CARGO
   drop constraint PK_CARGO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARGO')
            and   type = 'U')
   drop table CARGO
go

alter table CLIENTEREVENDEDOR
   drop constraint PK_CLIENTEREVENDEDOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLIENTEREVENDEDOR')
            and   type = 'U')
   drop table CLIENTEREVENDEDOR
go

alter table FUNCIONARIO
   drop constraint PK_FUNCIONARIO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FUNCIONARIO')
            and   type = 'U')
   drop table FUNCIONARIO
go

alter table NOTAFISCAL
   drop constraint PK_NOTAFISCAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('NOTAFISCAL')
            and   type = 'U')
   drop table NOTAFISCAL
go

alter table PRODUTO
   drop constraint PK_PRODUTO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRODUTO')
            and   type = 'U')
   drop table PRODUTO
go

alter table SAIDADEPRODUTOS
   drop constraint PK_SAIDADEPRODUTOS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SAIDADEPRODUTOS')
            and   type = 'U')
   drop table SAIDADEPRODUTOS
go

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO (
   COD_CARGO            int                  identity,
   NOME_CARGO           varchar(50)          null,
   SALARIO_CARGO        numeric(6,2)         null
)
go

alter table CARGO
   add constraint PK_CARGO primary key (COD_CARGO)
go

/*==============================================================*/
/* Table: CLIENTEREVENDEDOR                                     */
/*==============================================================*/
create table CLIENTEREVENDEDOR (
   COD_CLIENTE          int                  identity,
   NOTA_CLIENTE         int                  null,
   NOME_CLIENTE         varchar(50)          null,
   EMPRESA_CLIENTE      varchar(60)          null,
   DATACADASTRO_CLIENTE datetime             null,
   VALORVENDIDO_CLIENTE numeric(8,2)         null
)
go

alter table CLIENTEREVENDEDOR
   add constraint PK_CLIENTEREVENDEDOR primary key (COD_CLIENTE)
go

/*==============================================================*/
/* Table: FUNCIONARIO                                           */
/*==============================================================*/
create table FUNCIONARIO (
   NOME_FUNC            varchar(60)          null,
   COD_FUNC             int                  identity,
   CARGO_FUNC           int                  null,
   CPF_FUNC             varchar(11)          null,
   RG_FUNC              varchar(9)           null,
   TEL_FUNC             numeric(10)          null,
   CEL_FUNC             numeric(11)          null,
   FOTO_FUNC            char(10)             null
)
go

alter table FUNCIONARIO
   add constraint PK_FUNCIONARIO primary key (COD_FUNC)
go

/*==============================================================*/
/* Table: NOTAFISCAL                                            */
/*==============================================================*/
create table NOTAFISCAL (
   COD_NOTA             int                  identity,
   PRODUTOS_NOTA        int                  null,
   FUNC_NOTA            int                  null,
   CLIENT_NOTA          varchar(50)          null,
   DATA_NOTA            datetime             null,
   PRECOTOTAL_NOTA      numeric(6,2)         null,
   DESCONTO_NOTA        numeric(4,2)         null
)
go

alter table NOTAFISCAL
   add constraint PK_NOTAFISCAL primary key (COD_NOTA)
go

/*==============================================================*/
/* Table: PRODUTO                                               */
/*==============================================================*/
create table PRODUTO (
   COD_PRODUTO          int                  identity,
   PRECOCOMPRA_PRODUTO  numeric(6,2)         null,
   PRECOVENDA_PRODUTO   numeric(6,2)         null,
   NOME_PRODUTO         char(10)             null,
   MARCA_FORN_PRODUTO   varchar(50)          null,
   QUANTIDADE_PRODUTO   int                  null
)
go

alter table PRODUTO
   add constraint PK_PRODUTO primary key (COD_PRODUTO)
go

/*==============================================================*/
/* Table: SAIDADEPRODUTOS                                       */
/*==============================================================*/
create table SAIDADEPRODUTOS (
   MES_SAIDA            numeric              not null,
   PRODUTOS_SAIDA       int                  null,
   QUANT_SAIDA          int                  null,
   VALTOTAL_SAIDA       numeric(7,2)         null
)
go

alter table SAIDADEPRODUTOS
   add constraint PK_SAIDADEPRODUTOS primary key (MES_SAIDA)
go

alter table CARGO
   add constraint FK_CARGO_REFERENCE_FUNCIONA foreign key ()
      references FUNCIONARIO (COD_FUNC)
go

alter table CLIENTEREVENDEDOR
   add constraint FK_CLIENTER_REFERENCE_NOTAFISC foreign key (NOTA_CLIENTE)
      references NOTAFISCAL (COD_NOTA)
go

alter table FUNCIONARIO
   add constraint FK_FUNCIONA_REFERENCE_CARGO foreign key (CARGO_FUNC)
      references CARGO (COD_CARGO)
go

alter table NOTAFISCAL
   add constraint FK_NOTAFISC_REFERENCE_PRODUTO foreign key (PRODUTOS_NOTA)
      references PRODUTO (COD_PRODUTO)
go

alter table NOTAFISCAL
   add constraint FK_NOTAFISC_REFERENCE_FUNCIONA foreign key (FUNC_NOTA)
      references FUNCIONARIO (COD_FUNC)
go

alter table SAIDADEPRODUTOS
   add constraint FK_SAIDADEP_REFERENCE_PRODUTO foreign key (PRODUTOS_SAIDA)
      references PRODUTO (COD_PRODUTO)
go
