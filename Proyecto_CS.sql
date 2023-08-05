-- CreaciÃ³n de la Tabla Actividades del modulo Alcaide
Drop Table actividades;
CREATE TABLE actividades (
    id_actividad          VARCHAR2(5 BYTE),
    nombre_actividad      VARCHAR2(255 BYTE),
    descripcion_actividad VARCHAR2(255 BYTE),
    fecha_hora_actividad  VARCHAR2(19 BYTE)
);

-- Crear el stored procedure para insertar una actividad
CREATE OR REPLACE PROCEDURE sp_insertar_actividad (
    p_nombre_actividad      IN VARCHAR2,
    p_descripcion_actividad IN VARCHAR2
) IS
    v_id_actividad         VARCHAR2(5);
    v_max_id_actividad     VARCHAR2(5);
    v_fecha_hora_actividad VARCHAR2(19);
BEGIN
    -- Obtener el ID mÃ¡ximo actual
    SELECT
        MAX(id_actividad)
    INTO v_max_id_actividad
    FROM
        actividades;

    -- Generar el nuevo ID de la actividad con el formato deseado
    IF v_max_id_actividad IS NULL THEN
        v_id_actividad := '#A001';
    ELSE
        v_id_actividad := '#A'
                          || lpad(TO_NUMBER(substr(v_max_id_actividad, 3)) + 1, 3, '0');
    END IF;

    -- Generar la fecha y hora actual en el formato deseado
    v_fecha_hora_actividad := to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS');

    -- Insertar la nueva fila en la tabla
    INSERT INTO actividades (
        id_actividad,
        nombre_actividad,
        descripcion_actividad,
        fecha_hora_actividad
    ) VALUES (
        v_id_actividad,
        p_nombre_actividad,
        p_descripcion_actividad,
        v_fecha_hora_actividad
    );

    -- Ordenar los registros por ID_ACTIVIDAD
    COMMIT;
END;
/

-- Crear el stored procedure para editar una actividad
CREATE OR REPLACE PROCEDURE sp_editar_actividad (
    p_id_actividad          IN VARCHAR2,
    p_nombre_actividad      IN VARCHAR2,
    p_descripcion_actividad IN VARCHAR2
) IS
BEGIN
    -- Actualizar los datos de la actividad
    UPDATE actividades
    SET
        nombre_actividad = p_nombre_actividad,
        descripcion_actividad = p_descripcion_actividad
    WHERE
        id_actividad = p_id_actividad;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE sp_eliminar_actividad(
    p_id_actividad IN VARCHAR2
)
IS
    TYPE actividad_type IS TABLE OF Actividades%ROWTYPE;
    v_actividades actividad_type;
BEGIN
    -- Eliminar la actividad seleccionada
    DELETE FROM Actividades WHERE ID_ACTIVIDAD = p_id_actividad;

    -- Obtener la lista de actividades restantes en orden ascendente
    SELECT *
    BULK COLLECT INTO v_actividades
    FROM Actividades
    ORDER BY ID_ACTIVIDAD ASC;

    -- Actualizar los IDs consecutivos
    FOR i IN 1..v_actividades.COUNT LOOP
        UPDATE Actividades
        SET ID_ACTIVIDAD = '#A' || LPAD(i, 3, '0')
        WHERE ID_ACTIVIDAD = v_actividades(i).ID_ACTIVIDAD;
    END LOOP;

    COMMIT;
END;
/
----------------------------------------------------------------------------------------------------------

-- CreaciÃ³n de la Tabla Talleres del modulo Alcaide
Drop table TalleresAlcaide;
CREATE TABLE TalleresAlcaide (
    ID_TALLER VARCHAR2(5),
    NOMBRE_TALLER VARCHAR2(100),
    CANTIDAD_GRUPOS NUMBER,
    CAPACIDAD_MAXIMA NUMBER,
    FECHA_CREACION DATE
);
--AÃ±adir dos nuevas columnas a la tabla TalleresAlcaide
ALTER TABLE TalleresAlcaide
ADD (FECHA_VENCIMIENTO DATE, REDUCCION_CONDENA NUMBER);

----------------------------------------------------------------------------------------------------------
Drop table Grupos;
//Creacion de Tabla Grupos Talleres
CREATE TABLE Grupos (
    ID_Grupo VARCHAR2(7 byte),
    ID_TALLER VARCHAR2(5),
    NOMBRE_GRUPO VARCHAR2(10),
    CAPACIDAD NUMBER
);

CREATE OR REPLACE PROCEDURE sp_agregar_taller(
    p_nombre IN VARCHAR2,
    p_cantidad_grupos IN NUMBER,
    p_capacidad_maxima IN NUMBER,
    p_fecha_creacion IN DATE,
    p_fecha_vencimiento IN DATE,
    p_reduccion_condena IN NUMBER
)
AS
    v_new_id VARCHAR2(5);
    v_cantidad_grupos NUMBER;
    v_new_grupo_id VARCHAR2(10);
BEGIN
    -- Obtener el ID mÃ¡ximo actual
    SELECT '#' || 'T' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_TALLER, 4))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM TalleresAlcaide;

    -- Insertar el nuevo taller
    INSERT INTO TalleresAlcaide(ID_TALLER, NOMBRE_TALLER, CANTIDAD_GRUPOS, CAPACIDAD_MAXIMA, FECHA_CREACION, FECHA_VENCIMIENTO, REDUCCION_CONDENA)
    VALUES (v_new_id, p_nombre, p_cantidad_grupos, p_capacidad_maxima, p_fecha_creacion, p_fecha_vencimiento, p_reduccion_condena);

    -- Obtener la cantidad de grupos del taller
    SELECT p_cantidad_grupos INTO v_cantidad_grupos FROM DUAL;

    -- Insertar los nombres de los grupos en la tabla Grupos
    FOR i IN 1..v_cantidad_grupos LOOP
        DECLARE
            v_new_grupo_id VARCHAR2(10);
            v_new_nombre_grupo VARCHAR2(10);
        BEGIN
            v_new_grupo_id := 'G' || 'T' || LPAD(i, 3, '0');
            IF v_cantidad_grupos = 1 THEN
                v_new_nombre_grupo := 'Grupo A';
            ELSE
                v_new_nombre_grupo := 'Grupo ' || CHR(64 + i);
            END IF;
            INSERT INTO Grupos (ID_GRUPO, ID_TALLER, NOMBRE_GRUPO, CAPACIDAD)
            VALUES (v_new_grupo_id, v_new_id, v_new_nombre_grupo, p_capacidad_maxima);
        END;
    END LOOP;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al agregar el taller: ' || SQLERRM);
        ROLLBACK;
END;
/


-- Crear el stored procedure para editar un taller
CREATE OR REPLACE PROCEDURE sp_editar_taller(
    p_id IN VARCHAR2,
    p_nombre IN VARCHAR2,
    p_cantidad_grupos IN NUMBER,
    p_capacidad_maxima IN NUMBER,
    p_fecha_creacion IN DATE,
    p_fecha_vencimiento IN DATE,
    p_reduccion_condena IN NUMBER
)
IS
BEGIN
    UPDATE TalleresAlcaide
    SET NOMBRE_TALLER = p_nombre,
        CANTIDAD_GRUPOS = p_cantidad_grupos,
        CAPACIDAD_MAXIMA = p_capacidad_maxima,
        FECHA_CREACION = p_fecha_creacion,
        FECHA_VENCIMIENTO = p_fecha_vencimiento,
        REDUCCION_CONDENA = p_reduccion_condena
    WHERE ID_TALLER = p_id;
    
    COMMIT;
END;
/



--Crear eliminar taller
CREATE OR REPLACE PROCEDURE sp_eliminar_taller(
    p_id_taller IN VARCHAR2
)
IS
    TYPE taller_type IS TABLE OF TalleresAlcaide%ROWTYPE;
    v_talleres taller_type;
BEGIN
    -- Eliminar el taller seleccionado
    DELETE FROM TalleresAlcaide WHERE ID_TALLER = p_id_taller;

    -- Obtener la lista de talleres restantes en orden ascendente
    SELECT *
    BULK COLLECT INTO v_talleres
    FROM TalleresAlcaide
    ORDER BY ID_TALLER ASC;

    -- Actualizar los IDs consecutivos
    FOR i IN 1..v_talleres.COUNT LOOP
        UPDATE TalleresAlcaide
        SET ID_TALLER = '#T' || LPAD(i, 3, '0')
        WHERE ID_TALLER = v_talleres(i).ID_TALLER;
    END LOOP;

    COMMIT;
END;    
/

----------------------------------------------------------------------------------------------------------
-- CreaciÃ³n de la Tabla Profesores del modulo Alcaide
Drop table Profesores;
CREATE TABLE Profesores (
    id_profesor         VARCHAR2(6 BYTE),
    cedula     VARCHAR2(255 BYTE),
    nombres     VARCHAR2(255 BYTE),
    apellidos     VARCHAR2(255 BYTE),
    correo     VARCHAR2(255 BYTE),
    especialidad     VARCHAR2(255 BYTE),
    experiencia     INT,
    usuario VARCHAR2(255 BYTE),
    contra  VARCHAR2(255 BYTE),
    fecha_Nacimiento DATE
);
--procedure para eliminar profesor
CREATE OR REPLACE PROCEDURE eliminar_profesor (
    p_id_profesor IN VARCHAR2
) AS
BEGIN
    DELETE FROM Profesores WHERE id_profesor = p_id_profesor;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('El profesor con ID ' || p_id_profesor || ' ha sido eliminado.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al eliminar el profesor: ' || SQLERRM);
END;
/

--PROCEDURE PARA EDITAR PROFESOR
CREATE OR REPLACE PROCEDURE sp_editar_profesor(
    p_id_profesor IN VARCHAR2,
    p_nombres IN VARCHAR2,
    p_apellidos IN VARCHAR2,
    p_cedula IN VARCHAR2,
    p_correo IN VARCHAR2,
    p_especialidad IN VARCHAR2,
    p_experiencia IN INT,
    p_usuario IN VARCHAR2,
    p_contrasena IN VARCHAR2,
    p_fecha_Nacimiento IN DATE -- FECHA NACIMIENTO
)
IS
BEGIN
    -- Actualizar los datos del profesor
    UPDATE Profesores
    SET 
        nombres = p_nombres,
        apellidos = p_apellidos,
        cedula = p_cedula,
        correo = p_correo,
        especialidad = p_especialidad,
        experiencia = p_experiencia,
        usuario = p_usuario,
        contra = p_contrasena,
        fecha_Nacimiento=p_fecha_Nacimiento
    WHERE id_profesor = p_id_profesor;
    
    COMMIT;
END;
/
----------------------------------------------------------------------------------------------------------
//tabla de asignacion de Profersor a una Activiadad o Taller
Drop Table AsignacionProfesor;
CREATE TABLE AsignacionProfesor (
  ID_Asignacion VARCHAR2(6 BYTE),
  Id_Docente VARCHAR2(6 BYTE),
  Nombre_Docente VARCHAR2(255),
  Tipo_Asignacion VARCHAR2(50),
  Nombre_ActividadTaller VARCHAR2(255),
  Id_ActividadTaller VARCHAR2(5),
  Nombre_Grupo VARCHAR2(255)
);

//proc agregarAsignacion
CREATE OR REPLACE PROCEDURE sp_AgregarAsignacionProfesor (
  p_IdDocente IN VARCHAR2,
  p_NombreDocente IN VARCHAR2,
  p_TipoAsignacion IN VARCHAR2,
  p_NombreActividadTaller IN VARCHAR2,
  p_IdActividadTaller IN VARCHAR2,
  p_NombreGrupo IN VARCHAR2
)
AS
  v_new_id VARCHAR2(9);
BEGIN
  -- Obtener el ID mÃ¡ximo actual
  SELECT 'AP' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_Asignacion, 3))), 0) + 1, 3, '0')
  INTO v_new_id
  FROM AsignacionProfesor;

  -- Insertar la nueva asignaciÃ³n
  INSERT INTO AsignacionProfesor (ID_Asignacion, Id_Docente, Nombre_Docente, Tipo_Asignacion, Nombre_ActividadTaller, Id_ActividadTaller, Nombre_Grupo)
  VALUES (v_new_id, p_IdDocente, p_NombreDocente, p_TipoAsignacion, p_NombreActividadTaller, p_IdActividadTaller, p_NombreGrupo);

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    -- Manejo de excepciones
    DBMS_OUTPUT.PUT_LINE('Error al agregar la asignaciÃ³n: ' || SQLERRM);
    ROLLBACK;
END;
/

//proc Editar un asignacion
CREATE OR REPLACE PROCEDURE sp_EditarAsignacionProfesor (
  p_IDAsignacion IN VARCHAR2,
  p_IdDocente IN VARCHAR2,
  p_NombreDocente IN VARCHAR2,
  p_TipoAsignacion IN VARCHAR2,
  p_NombreActividadTaller IN VARCHAR2,
  p_IdActividadTaller IN VARCHAR2,
  p_NombreGrupo IN VARCHAR2
)
AS
BEGIN
  UPDATE AsignacionProfesor
  SET Id_Docente = p_IdDocente,
      Nombre_Docente = p_NombreDocente,
      Tipo_Asignacion = p_TipoAsignacion,
      Nombre_ActividadTaller = p_NombreActividadTaller,
      Id_ActividadTaller = p_IdActividadTaller,
      Nombre_Grupo = p_NombreGrupo
  WHERE ID_Asignacion = p_IDAsignacion;
  COMMIT;
END;
/
//eliminar unaAsignacion
CREATE OR REPLACE PROCEDURE sp_eliminar_asignacion(
    p_id_asignacion IN VARCHAR
) AS
BEGIN
    DELETE FROM AsignacionProfesor WHERE ID_Asignacion = p_id_asignacion;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('La asignaciÃ³n con ID ' || p_id_asignacion || ' ha sido eliminada.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al eliminar la asignaciÃ³n: ' || SQLERRM);
END;
/
----------------------------------------------------------------------------------------------------------
-- CreaciÃ³n de la Tabla Reclusos del modulo Alcaide
Drop Table Reclusos;
CREATE TABLE Reclusos (
id_recluso VARCHAR2(6 BYTE),
cedula VARCHAR2(255 BYTE),
nombres VARCHAR2(255 BYTE),
apellidos VARCHAR2(255 BYTE),
tiempo_condena INT,
delito VARCHAR2(255 BYTE),
correo VARCHAR2(255 BYTE),
usuario VARCHAR2(255 BYTE),
contra VARCHAR2(255 BYTE),
fecha_nacimiento DATE
);
--CREACION DE PROCEDURE REGISTAR RECLUSO
CREATE OR REPLACE PROCEDURE sp_RegistrarRecluso(
    p_id_recluso IN Reclusos.id_recluso%TYPE,
    p_cedula IN Reclusos.cedula%TYPE,
    p_nombres IN Reclusos.nombres%TYPE,
    p_apellidos IN Reclusos.apellidos%TYPE,
    p_tiempo_condena IN Reclusos.tiempo_condena%TYPE,
    p_delito IN Reclusos.delito%TYPE,
    p_correo IN Reclusos.correo%TYPE,
    p_usuario IN Reclusos.usuario%TYPE,
    p_contra IN Reclusos.contra%TYPE,
    p_fecha_nacimiento IN Reclusos.fecha_nacimiento%TYPE
) AS
BEGIN
    INSERT INTO Reclusos (
        id_recluso,
        cedula,
        nombres,
        apellidos,
        tiempo_condena,
        delito,
        correo,
        usuario,
        contra,
        fecha_nacimiento
    ) VALUES (
        p_id_recluso,
        p_cedula,
        p_nombres,
        p_apellidos,
        p_tiempo_condena,
        p_delito,
        p_correo,
        p_usuario,
        p_contra,
        p_fecha_nacimiento
    );
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('El recluso ha sido registrado exitosamente.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al registrar el recluso: ' || SQLERRM);
END;
/

--CREACION DE PROCEDURE EDITAR RECLUSO
CREATE OR REPLACE PROCEDURE sp_EditarRecluso(
    p_id_recluso IN Reclusos.id_recluso%TYPE,
    p_cedula IN Reclusos.cedula%TYPE,
    p_nombres IN Reclusos.nombres%TYPE,
    p_apellidos IN Reclusos.apellidos%TYPE,
    p_tiempo_condena IN Reclusos.tiempo_condena%TYPE,
    p_delito IN Reclusos.delito%TYPE,
    p_correo IN Reclusos.correo%TYPE,
    p_usuario IN Reclusos.usuario%TYPE,
    p_contra IN Reclusos.contra%TYPE,
    p_fecha_nacimiento IN Reclusos.fecha_nacimiento%TYPE
) AS
BEGIN
    UPDATE Reclusos
    SET
        cedula = p_cedula,
        nombres = p_nombres,
        apellidos = p_apellidos,
        tiempo_condena = p_tiempo_condena,
        delito = p_delito,
        correo = p_correo,
        usuario = p_usuario,
        contra = p_contra,
        fecha_nacimiento=p_fecha_nacimiento
    WHERE id_recluso = p_id_recluso;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('El recluso ha sido actualizado exitosamente.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontrÃ³ el recluso con el ID especificado.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al actualizar el recluso: ' || SQLERRM);
END;
/


--CREACION DE PROCEDURE ELIMINAR UN RECLUSO
CREATE OR REPLACE PROCEDURE sp_EliminarRecluso(
    p_id_recluso IN Reclusos.id_recluso%TYPE
) AS
BEGIN
    DELETE FROM Reclusos WHERE id_recluso = p_id_recluso;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('El recluso ha sido eliminado exitosamente.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontrÃ³ el recluso con el ID especificado.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al eliminar el recluso: ' || SQLERRM);
END;
/
----------------------------------------------------------------------------------------------------------
//tabla de asignacion de Recluso a una Activiadad o Taller
Drop table AsignacionRecluso;
CREATE TABLE AsignacionRecluso (
  ID_Asignacion VARCHAR2(6 BYTE),
  Id_Recluso VARCHAR2(6 BYTE),
  Nombre_Recluso VARCHAR2(255),
  Tipo_Asignacion VARCHAR2(50),
  Nombre_ActividadTaller VARCHAR2(255),
  Id_ActividadTaller VARCHAR2(5),
  nombre_Grupo VARCHAR2(255),
  ID_Grupo VARCHAR2(7 byte)
);


-- Proc agregarAsignacionRecluso
CREATE OR REPLACE PROCEDURE sp_AgregarAsignacionTaller_Recluso (
    p_IdRecluso IN VARCHAR2,
    p_NombreRecluso IN VARCHAR2,
    p_TipoAsignacion IN VARCHAR2,
    p_NombreActividadTaller IN VARCHAR2,
    p_IdActividadTaller IN VARCHAR2,
    p_NombreGrupo IN VARCHAR2
)
AS
    v_new_id VARCHAR2(9);
BEGIN
    -- Obtener el ID mÃ¡ximo actual
    SELECT 'AR' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_Asignacion, 3))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM AsignacionRecluso;

    -- Insertar la nueva asignaciÃ³n
    INSERT INTO AsignacionRecluso (ID_Asignacion, Id_Recluso, Nombre_Recluso, Tipo_Asignacion, Nombre_ActividadTaller, Id_ActividadTaller, nombre_Grupo)
    VALUES (v_new_id, p_IdRecluso, p_NombreRecluso, p_TipoAsignacion, p_NombreActividadTaller, p_IdActividadTaller, p_NombreGrupo);

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al agregar la asignaciÃ³n: ' || SQLERRM);
        ROLLBACK;
END;
/
--Proc agregar Actividad a un recluso
CREATE OR REPLACE PROCEDURE sp_AgregarAsignacionActividad_Recluso (
    p_IdRecluso IN VARCHAR2,
    p_NombreRecluso IN VARCHAR2,
    p_TipoAsignacion IN VARCHAR2,
    p_NombreActividadTaller IN VARCHAR2,
    p_IdActividadTaller IN VARCHAR2
)
AS
    v_new_id VARCHAR2(9);
BEGIN
    -- Obtener el ID mÃ¡ximo actual
    SELECT 'AR' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_Asignacion, 3))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM AsignacionRecluso;

    -- Insertar la nueva asignaciÃ³n
    INSERT INTO AsignacionRecluso (ID_Asignacion, Id_Recluso, Nombre_Recluso, Tipo_Asignacion, Nombre_ActividadTaller, Id_ActividadTaller, nombre_Grupo)
    VALUES (v_new_id, p_IdRecluso, p_NombreRecluso, p_TipoAsignacion, p_NombreActividadTaller, p_IdActividadTaller, '');

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al agregar la asignaciÃ³n: ' || SQLERRM);
        ROLLBACK;
END;
/


-- Proc Editar una asignaciÃ³n
CREATE OR REPLACE PROCEDURE sp_EditarAsignacionTallerRecluso (
    p_IDAsignacion IN VARCHAR2,
    p_IdRecluso IN VARCHAR2,
    p_NombreRecluso IN VARCHAR2,
    p_TipoAsignacion IN VARCHAR2,
    p_NombreActividadTaller IN VARCHAR2,
    p_IdActividadTaller IN VARCHAR2,
    p_NombreGrupo IN VARCHAR2
)
AS
BEGIN
    UPDATE AsignacionRecluso
    SET Id_Recluso = p_IdRecluso,
        Nombre_Recluso = p_NombreRecluso,
        Tipo_Asignacion = p_TipoAsignacion,
        Nombre_ActividadTaller = p_NombreActividadTaller,
        Id_ActividadTaller = p_IdActividadTaller,
        nombre_Grupo = p_NombreGrupo
    WHERE ID_Asignacion = p_IDAsignacion;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al editar la asignaciÃ³n: ' || SQLERRM);
        ROLLBACK;
END;
/
---PROC PARA editar una asignacion Actividad a un recluso
CREATE OR REPLACE PROCEDURE sp_EditarAsignacionActividad_Recluso (
    p_IDAsignacion IN VARCHAR2,
    p_IdRecluso IN VARCHAR2,
    p_NombreRecluso IN VARCHAR2,
    p_TipoAsignacion IN VARCHAR2,
    p_NombreActividadTaller IN VARCHAR2,
    p_IdActividadTaller IN VARCHAR2
)
AS
BEGIN
    UPDATE AsignacionRecluso
    SET Id_Recluso = p_IdRecluso,
        Nombre_Recluso = p_NombreRecluso,
        Tipo_Asignacion = p_TipoAsignacion,
        Nombre_ActividadTaller = p_NombreActividadTaller,
        Id_ActividadTaller = p_IdActividadTaller,
        nombre_Grupo = ''
    WHERE ID_Asignacion = p_IDAsignacion;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al editar la asignaciÃ³n: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Proc eliminar una asignaciÃ³n
CREATE OR REPLACE PROCEDURE sp_eliminar_asignacionRecluso(
    p_id_asignacion IN VARCHAR2
)
AS
BEGIN
    DELETE FROM AsignacionRecluso WHERE ID_Asignacion = p_id_asignacion;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('La asignaciÃ³n con ID ' || p_id_asignacion || ' ha sido eliminada.');
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al eliminar la asignaciÃ³n: ' || SQLERRM);
        ROLLBACK;
END;
/
------------------------------------------------------------------------------------------------
--Creacion de la tabla USUARIOS
DROP Table Usuarios;
CREATE TABLE Usuarios (
    id_usuario      VARCHAR2(9 BYTE) PRIMARY KEY,
    nombre_usuario  VARCHAR2(255) UNIQUE,
    contrasena      VARCHAR2(255),
    nombre          VARCHAR2(255),
    correo_electronico VARCHAR2(255),
    rol             VARCHAR2(255)
);


INSERT INTO Usuarios (id_usuario, nombre_usuario, contrasena, nombre, correo_electronico, rol)
    VALUES ('#AlC01', 'admin', 'admin',' Alcaide adm','admin@alcaide.com','Alcaide') ;
--DISPARARDOR PARA AGREGAR USUARIOS QUE SE VAYAN AGREANDO ALA BASE SEA PROFESOR O RECLUSO
CREATE OR REPLACE TRIGGER trigger_insertar_usuario_profesor
AFTER INSERT ON Profesores
FOR EACH ROW
BEGIN
    INSERT INTO Usuarios (id_usuario, nombre_usuario, contrasena, nombre, correo_electronico, rol)
    VALUES (:NEW.id_profesor, :NEW.usuario, :NEW.contra, :NEW.nombres, :NEW.correo, 
            CASE WHEN SUBSTR(:NEW.id_profesor, 2, 1) = 'P' THEN 'Profesor' END);
END;
/

CREATE OR REPLACE TRIGGER trigger_insertar_usuario_recluso
AFTER INSERT ON Reclusos
FOR EACH ROW
BEGIN
    INSERT INTO Usuarios (id_usuario, nombre_usuario, contrasena, nombre, correo_electronico, rol)
    VALUES (:NEW.id_recluso, :NEW.usuario, :NEW.contra, :NEW.nombres, :NEW.correo, 
            CASE WHEN SUBSTR(:NEW.id_recluso, 2, 1) = 'R' THEN 'Recluso' END);
END;
/
-- Disparador para eliminar el usuario cuando se elimine un profesor
CREATE OR REPLACE TRIGGER trigger_eliminar_usuario_profesor
AFTER DELETE ON Profesores
FOR EACH ROW
BEGIN
    DELETE FROM Usuarios WHERE id_usuario = :OLD.id_profesor;
END;
/

-- Disparador para eliminar el usuario cuando se elimine un recluso
CREATE OR REPLACE TRIGGER trigger_eliminar_usuario_recluso
AFTER DELETE ON Reclusos
FOR EACH ROW
BEGIN
    DELETE FROM Usuarios WHERE id_usuario = :OLD.id_recluso;
END;
/
--Trigger para eliminar las asignaciones del recluso cuando se elimine el recluso:
CREATE OR REPLACE TRIGGER trigger_eliminar_asignaciones_recluso
AFTER DELETE ON Reclusos
FOR EACH ROW
BEGIN
    DELETE FROM AsignacionRecluso WHERE Id_Recluso = :OLD.Id_Recluso;
END;
/
--Trigger para eliminar las asignaciones del profesor cuando se elimine el profesor
CREATE OR REPLACE TRIGGER trigger_eliminar_asignaciones_profesor
AFTER DELETE ON Profesores
FOR EACH ROW
BEGIN
    DELETE FROM AsignacionProfesor WHERE id_docente = :OLD.id_profesor;
END;
/

-- Creacion de tabla Inscripcion
Drop table Inscripcion;
CREATE TABLE Inscripcion (
  ID_Inscripcion VARCHAR2(6 BYTE),
  Id_Recluso VARCHAR2(6 BYTE),
  ID_Grupo VARCHAR2(7 byte),
  Nombre_Recluso VARCHAR2(255),
  Apellidos_Recluso VARCHAR2(255 BYTE),
  Correo VARCHAR2(255 BYTE),
  Id_Taller VARCHAR2(5),
  Nombre_Taller VARCHAR2(100),
  Reduccion_Condena NUMBER,
  FECHA_CREACION DATE,
  FECHA_VENCIMIENTO DATE,
  NOMBRE_GRUPO VARCHAR2(10),
  CAPACIDAD NUMBER
);

-----------------------------------------------------------------------------------------

-- Proc agregarInscripcionRecluso
CREATE OR REPLACE PROCEDURE sp_Inscribir_Recluso (
    p_IdRecluso IN VARCHAR2,
    p_IdGrupo IN VARCHAR2,
    p_NombreRecluso IN VARCHAR2,
    p_ApellidosRecluso IN VARCHAR2,
    p_Correo IN VARCHAR2,
    p_IdTaller IN VARCHAR2,
    p_NombreTaller IN VARCHAR2,
    p_ReduccionCondena IN NUMBER,
    p_Fecha_creacion IN DATE,
    p_Fecha_Vencimiento IN DATE,
    p_NombreGrupo IN VARCHAR2,
    p_Capacidad IN NUMBER
) AS
    v_new_id VARCHAR2(9);
BEGIN
    -- Obtener el ID maximo actual
    SELECT 'TR' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_INSCRIPCION, 3))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM INSCRIPCION;

    -- Insertar la nueva inscripcion
    INSERT INTO INSCRIPCION (ID_INSCRIPCION, Id_RECLUSO, Id_Grupo, Nombre_Recluso, Apellidos_Recluso, Correo, Id_Taller, Nombre_Taller, Reduccion_Condena, Fecha_Creacion, Fecha_Vencimiento, nombre_Grupo, Capacidad)
    VALUES (v_new_id, p_IdRecluso, p_IdGrupo, p_NombreRecluso, p_ApellidosRecluso, p_Correo, p_IdTaller, p_NombreTaller, p_ReduccionCondena, p_Fecha_creacion, p_Fecha_Vencimiento, p_NombreGrupo, p_Capacidad);

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al agregar la asignacion: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Proc eliminar una inscripcion
CREATE OR REPLACE PROCEDURE sp_eliminar_inscripcionRecluso(
    p_id_inscripcion IN VARCHAR2
)
AS
BEGIN
    DELETE FROM INSCRIPCION WHERE ID_INSCRIPCION = p_id_inscripcion;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('La inscripcion con ID ' || p_id_inscripcion || ' ha sido eliminada.');
EXCEPTION
    WHEN OTHERS THEN
        -- Manejo de excepciones
        DBMS_OUTPUT.PUT_LINE('Error al eliminar la asignacion: ' || SQLERRM);
        ROLLBACK;
END;
/


--Trigger para eliminar las asignaciones del recluso cuando se elimine el recluso:
CREATE OR REPLACE TRIGGER trigger_eliminar_inscripcion_recluso
AFTER DELETE ON Reclusos
FOR EACH ROW
BEGIN
    DELETE FROM Inscripcion WHERE Id_Recluso = :OLD.Id_Recluso;
END;
/

--MODULO PROFESOR
Drop table Asistencias
CREATE TABLE Asistencias (
    Id_asistencia VARCHAR(20) PRIMARY KEY,
    Id_recluso VARCHAR(20),
    Nombre_recluso VARCHAR(255),
    taller VARCHAR(255),
    grupo VARCHAR(255),
    fecha DATE,
    asistencia VARCHAR(10)
);

--TABLA ASIGNACION PARA LA SUBIDA DE ASIGNACIONES POR PARTE DEL PROFESOR
CREATE TABLE Asignacion (
    Id_Asignacion VARCHAR(255) PRIMARY KEY,
    Titulo VARCHAR(255),
    Curso VARCHAR(255),
    Grupo VARCHAR(255),
    Descripcion VARCHAR(255),
    Fecha_Limite DATE
);
