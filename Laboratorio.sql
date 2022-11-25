CREATE DATABASE "Laboratorio"
    WITH
    OWNER = postgres
    TEMPLATE = template1
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = false;

CREATE SCHEMA Persona
CREATE SCHEMA Aula

CREATE TABLE Persona.Empleado
(
	RPE_Empleado BIGSERIAL NOT NULL,
	Nombre VARCHAR(100) NOT NULL,
	Domicilio VARCHAR(200) NOT NULL,
	Correo VARCHAR(200) NOT NULL,
	Celular VARCHAR(10) NOT NULL,
	EmpleadoDesde DATE NOT NULL,
	Antiguedad VARCHAR(20) NOT NULL,
	TipoEmpleado VARCHAR(40) NOT NULL,

	CONSTRAINT PK_EMPLEADO PRIMARY KEY (RPE_Empleado)
)

CREATE TABLE Persona.Colaborador
(
	RPE_Colaborador BIGSERIAL NOT NULL,
	Desc_act TEXT NOT NULL,
	Hrs_sem BIGINT NOT NULL,

	CONSTRAINT FK_COLABRADOR FOREIGN KEY (RPE_Colaborador)
		REFERENCES Persona.Empleado(RPE_Empleado)
		ON UPDATE CASCADE
		ON DELETE CASCADE			
)

CREATE TABLE Persona.Becario
(
	RPE_Becario BIGSERIAL NOT NULL,
	Fecha_nac DATE NOT NULL,
	Hrs_sem BIGINT NOT NULL,
	Generacion VARCHAR(10) NOT NULL,

	CONSTRAINT FK_BECARIO FOREIGN KEY (RPE_Becario)
			REFERENCES Persona.Empleado(RPE_Empleado)
			ON UPDATE CASCADE
			ON DELETE CASCADE
)

CREATE TABLE Persona.Responsable
(
	RPE_Responsable BIGSERIAL NOT NULL,	
	Grado VARCHAR(20) NOT NULL,
	Fecha_Inicio DATE NOT NULL,
	Fecha_Fin DATE NOT NULL,

	CONSTRAINT FK_RESPONSABLE FOREIGN KEY (RPE_Responsable)
			REFERENCES Persona.Empleado(RPE_Empleado)
			ON UPDATE CASCADE
			ON DELETE CASCADE
)

CREATE TABLE Persona.Alumno
(
	Clave_Unica BIGSERIAL NOT NULL,
	Nombre VARCHAR(40) NOT NULL,
	Generacion BIGINT NOT NULL,
	Carrera VARCHAR(20) NOT NULL,
	Adeudo BIGINT NOT NULL,

	CONSTRAINT PK_CLAVE PRIMARY KEY (Clave_Unica)
)

CREATE TABLE Aula.Equipo
(
	NumInv BIGSERIAL NOT NULL,
	Nombre VARCHAR(40) NOT NULL,
	Modelo VARCHAR(20) NOT NULL,
	Descripcion VARCHAR(100) NOT NULL,
	UbicacionEnLab VARCHAR(30) NOT NULL,
	Marca VARCHAR(20) NOT NULL,
	TipoEquipo VARCHAR(10) NOT NULL,

	CONSTRAINT PK_NUMINV PRIMARY KEY (NumInv)

)

CREATE TABLE Aula.Sancion
(
	id BIGSERIAL NOT NULL,
	Clave_Unica BIGINT NOT NULL,
	RPE_Empleado BIGINT NOT NULL,
	Descripcion VARCHAR(50) NOT NULL,
	Fecha DATE NOT NULL,
	F_liquidacion DATE NOT NULL,
	Monto BIGINT NOT NULL,

	CONSTRAINT FK_EMPLEADO FOREIGN KEY (RPE_Empleado)
			REFERENCES Persona.Empleado(RPE_Empleado),
	CONSTRAINT FK_CLAVE FOREIGN KEY (Clave_Unica)
			REFERENCES Persona.Alumno(Clave_Unica)
)

CREATE TABLE Aula.Prestamo
(
	Id_Prestamo BIGSERIAL NOT NULL,
	NumInv BIGINT NOT NULL,
	Clave_Unica BIGINT NOT NULL,
	RPE_Empleado BIGINT NOT NULL,
	FechaEntrega DATE NOT NULL,
	FechaPrestamo DATE NOT NULL,

	CONSTRAINT PK_IDPRESTAMO PRIMARY KEY (Id_Prestamo),

	CONSTRAINT FK_NUMINV FOREIGN KEY(NumInv)
		REFERENCES Aula.Equipo(NumInv),
	CONSTRAINT FK_CL FOREIGN KEY(Clave_Unica)
		REFERENCES Persona.Alumno(Clave_Unica),
	CONSTRAINT FK_EMPLE FOREIGN KEY(RPE_Empleado)
		REFERENCES Persona.Empleado(RPE_Empleado)
)

CREATE TABLE Aula.BitacoraEntrega
(
	Id_Prestamo BIGSERIAL NOT NULL,
	RPE_Empleado BIGINT NOT NULL,
	Fecha_Entrega DATE NOT NULL,

	CONSTRAINT FK_IDPRESTAMO FOREIGN KEY (Id_Prestamo)
		REFERENCES Aula.Prestamo (Id_Prestamo)
)

CREATE TABLE Aula.Materia
(
	ClaveMateria BIGSERIAL,
	Nombre VARCHAR(100) NOT NULL,
	Nivel BIGINT NOT NULL,
	
	CONSTRAINT PK_CLAVEMATERIA PRIMARY KEY (ClaveMateria)	
)

--Usuarios*****************************************************************************************************************************
CREATE USER Responsable WITH PASSWORD 'responsable';
CREATE USER Becario WITH PASSWORD 'becario';
CREATE USER Colaborador WITH PASSWORD 'colaborador';
 
--Acceso a esquemas
GRANT USAGE ON SCHEMA persona TO Responsable;
GRANT USAGE ON SCHEMA persona TO Becario;
GRANT USAGE ON SCHEMA persona TO Colaborador;

GRANT USAGE ON SCHEMA Aula TO Responsable;
GRANT USAGE ON SCHEMA Aula TO Becario;
GRANT USAGE ON SCHEMA Aula TO Colaborador;


--Permisos por tablas
--Responsable
GRANT INSERT, SELECT, UPDATE, DELETE ON persona.empleado TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON persona.responsable TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON persona.colaborador TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON persona.becario TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON persona.alumno TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Equipo TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Asistencia TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Materia TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Sancion TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Prestamo TO Responsable;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.BitacoraEntrega TO Responsable;

--Becario
GRANT SELECT ON persona.empleado TO Becario;
GRANT SELECT ON persona.responsable TO Becario;
GRANT SELECT ON persona.colaborador TO Becario;
GRANT SELECT ON persona.becario TO Becario;
GRANT SELECT ON persona.alumno TO Becario;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Equipo TO Becario;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Asistencia TO Becario;
GRANT SELECT ON Aula.Materia TO Becario;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Sancion TO Becario;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.Prestamo TO Becario;
GRANT INSERT, SELECT, UPDATE, DELETE ON Aula.BitacoraEntrega TO Becario;

--Colaborador
GRANT SELECT ON persona.empleado TO Colaborador;
GRANT SELECT ON persona.responsable TO Colaborador;
GRANT SELECT ON persona.colaborador TO Colaborador;
GRANT SELECT ON persona.becario TO Colaborador;
GRANT SELECT ON persona.alumno TO Colaborador;
GRANT SELECT ON Aula.Equipo TO Colaborador;
GRANT SELECT ON Aula.Asistencia TO Colaborador;
GRANT SELECT ON Aula.Materia TO Colaborador;
GRANT SELECT ON Aula.Sancion TO Colaborador;
GRANT SELECT ON Aula.Prestamo TO Colaborador;
GRANT SELECT ON Aula.BitacoraEntrega TO Colaborador;

--Use en caso de emergencia[Si no se puede borrar un usuario]
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA persona FROM Becario;
REVOKE ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA persona FROM Becario;
REVOKE ALL PRIVILEGES ON SCHEMA persona FROM Becario;
REVOKE ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA aula FROM Becario;
DROP USER Becario;