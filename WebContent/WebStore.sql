-- ------------------------------------------------------------------------------
-- - DROP TABLE IF EXISTS ALL TABLE
-- ------------------------------------------------------------------------------

DROP TABLE IF EXISTS T_Users        CASCADE;
DROP TABLE IF EXISTS T_Admins       CASCADE;
DROP TABLE IF EXISTS T_Playlists    CASCADE;
DROP TABLE IF EXISTS T_Videos       CASCADE;
DROP TABLE IF EXISTS T_TOP          CASCADE;



-- -----------------------------------------------------------------------------
-- - T_Users creation
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
    IdUser              SERIAL              PRIMARY KEY,
    LoginUser           varchar(100)        NOT NULL UNIQUE,
    PasswordUser        varchar(256)        NOT NULL,
    BirthDate           Date                NOT NULL,
    Name                varchar(100)        NOT NULL,
    LastName            varchar(100)        NOT NULL,
    Email               varchar(100)        NOT NULL,
    ConnectionNumber    int                 DEFAULT 0
);

--                              Login          Password                                                            Birth Date    Name              Last Name   Email  Connexion number
INSERT INTO T_Users VALUES (0, 'Pepito'     , '496c0456fa019e0586dcea780bf016b07e636cd78c0853ea6b714140720284c0', '2000-05-26', 'Etienne'       , 'Saimond' , 'a@b.c',0);
INSERT INTO T_Users VALUES (1, 'Bond'       , '8f8fd9ecdd4abade9e242bbe78dfce031a19b5ae23e5f5fa609a3f17fd17ad0e', '1520-08-12', 'James'         , 'Bond'    , 'a@b.c',0);
INSERT INTO T_Users VALUES (2, 'JeanMiDu13' , 'c78d17d0c3e00343838f63995bfc7d25c139f9f4711dd83d702f8a4dc9e18590', '1986-11-02', 'Jean Michel'   , 'dutrèze' , 'a@b.c',0);
INSERT INTO T_Users VALUES (3, 'DylanDu13'  , '5bb11d78f87108b4a8d017e30fc9596cd7ed60c4fda9af0dd2def72385b5781f', '1981-02-28', 'Dylan'         , 'dutrèze' , 'a@b.c',0);

SELECT * FROM T_Users;



-- -----------------------------------------------------------------------------
-- - T_Admins creation
-- -----------------------------------------------------------------------------

CREATE TABLE T_Admins (
    IdAdmin             SERIAL              PRIMARY KEY,
    IdUserAdmin         int                 NOT NULL,
    RightsAdmin         varchar(10)         NOT NULL,
    FOREIGN KEY(IdUserAdmin) 
        REFERENCES T_Users(IdUser)
);

INSERT INTO T_Admins (IdUserAdmin, RightsAdmin) VALUES ( 1, '-RWX------' );
INSERT INTO T_Admins (IdUserAdmin, RightsAdmin) VALUES ( 3, '-RWK------' );

SELECT * FROM T_Admins;



-- -----------------------------------------------------------------------------
-- - T_Playlist creation
-- -----------------------------------------------------------------------------

CREATE TABLE T_Playlists (
    IdPlaylist          SERIAL              PRIMARY KEY,
    IdUserPlaylist      BIGINT              NOT NULL,
    UrlPlaylist         varchar(1000)       NOT NULL,
    LastSync            DATE,
    FOREIGN KEY(IdUserPlaylist)             
        REFERENCES T_Users(IdUser)
);

INSERT INTO T_Playlists VALUES ( 1, 1,'https://www.youtube.com/playlist?list=PLgqBnY3oUQsm2XNX_mufcdCrHIrEp8vHy' );
    
SELECT * FROM T_Playlists;



-- -----------------------------------------------------------------------------
-- - T_Videos creation
-- -----------------------------------------------------------------------------
-- YouTube Id exemple : bf0RmLljVXI
CREATE TABLE T_Videos (
    IdVideo             SERIAL          PRIMARY KEY,
    YoutubeIdVideo      varchar(11)     NOT NULL,
    IdPlaylistVideo     BIGINT          NOT NULL,
    UrlVideo            varchar(1000)   NOT NULL,
    CountDl             integer         NOT NULL,
    FOREIGN KEY(IdPlaylistVideo) 
        REFERENCES T_Playlists(IdPlaylist)
);

-- -----------------------------------------------------------------------------
-- - T_Top creation
-- -----------------------------------------------------------------------------

CREATE TABLE T_Top (
    IdTop               integer         NOT NULL,
    IdVideo             BIGINT          PRIMARY KEY,
    UrlVideo            varchar(1000)   NOT NULL,
    CountDl             BIGINT         NOT NULL,
)

