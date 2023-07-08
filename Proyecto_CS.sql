-- Creación de la Tabla Actividades del modulo Alcaide

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
    -- Obtener el ID máximo actual
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

-- Creación de la Tabla Talleres del modulo Alcaide

CREATE TABLE TalleresAlcaide (
    ID_TALLER VARCHAR2(5),
    NOMBRE_TALLER VARCHAR2(100),
    CANTIDAD_GRUPOS NUMBER,
    CAPACIDAD_MAXIMA NUMBER,
    FECHA_CREACION DATE
);
//Creacion de Tabla Grupos Talleres
CREATE TABLE Grupos (
    ID_GRUPO NUMBER,
    ID_TALLER VARCHAR2(5),
    NOMBRE_GRUPO VARCHAR2(10),
    CAPACIDAD NUMBER
);
select *from talleresalcaide;
select * from grupos;
select * from talleresalcaide where id_taller='#T001';
SELECT NOMBRE_GRUPO FROM Grupos WHERE ID_TALLER ='#T001';
SELECT ID_TALLER FROM TalleresAlcaide WHERE NOMBRE_TALLER ='CARPINTERIA';
CREATE OR REPLACE PROCEDURE sp_agregar_taller(
    p_nombre IN VARCHAR2,
    p_cantidad_grupos IN NUMBER,
    p_capacidad_maxima IN NUMBER,
    p_fecha_creacion IN DATE
)
AS
    v_new_id VARCHAR2(5);
    v_cantidad_grupos NUMBER;
BEGIN
    -- Obtener el ID máximo actual
    SELECT '#' || 'T' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_TALLER, 4))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM TalleresAlcaide;

    -- Insertar el nuevo taller
    INSERT INTO TalleresAlcaide(ID_TALLER, NOMBRE_TALLER, CANTIDAD_GRUPOS, CAPACIDAD_MAXIMA, FECHA_CREACION)
    VALUES (v_new_id, p_nombre, p_cantidad_grupos, p_capacidad_maxima, p_fecha_creacion);

    -- Obtener la cantidad de grupos del taller
    SELECT p_cantidad_grupos INTO v_cantidad_grupos FROM DUAL;

    -- Insertar los nombres de los grupos en la tabla Grupos
    INSERT INTO Grupos (ID_GRUPO, ID_TALLER, NOMBRE_GRUPO, CAPACIDAD)
    SELECT LEVEL, v_new_id, 'Grupo ' || CHR(64 + LEVEL), p_capacidad_maxima
    FROM DUAL
    CONNECT BY LEVEL <= v_cantidad_grupos;

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
    p_id IN NUMBER,
    p_nombre IN VARCHAR2,
    p_cantidad_grupos IN NUMBER,
    p_capacidad_maxima IN NUMBER,
    p_fecha_creacion IN DATE
)
IS
BEGIN
    UPDATE TalleresAlcaide
    SET NOMBRE_TALLER = p_nombre,
        CANTIDAD_GRUPOS = p_cantidad_grupos,
        CAPACIDAD_MAXIMA = p_capacidad_maxima,
        FECHA_CREACION = p_fecha_creacion
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


-- Creación de la Tabla Profesores del modulo Alcaide
select * from Profesores;

DELETE FROM Profesores WHERE nombres = 'Yordan';
CREATE TABLE Profesores (
    id_profesor         VARCHAR2(6 BYTE),
    cedula     VARCHAR2(255 BYTE),
    nombres     VARCHAR2(255 BYTE),
    apellidos     VARCHAR2(255 BYTE),
    correo     VARCHAR2(255 BYTE),
    especialidad     VARCHAR2(255 BYTE),
    experiencia     INT,
    usuario VARCHAR2(255 BYTE),
    contra  VARCHAR2(255 BYTE)
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
    p_nueva_cedula IN VARCHAR2 -- Nuevo parámetro para la nueva cédula
)
IS
    v_new_id_profesor VARCHAR2(10); -- Variable para almacenar el nuevo ID del profesor
BEGIN
    -- Generar el nuevo ID del profesor
    v_new_id_profesor := '#P' || SUBSTR(p_nueva_cedula, -4);

    -- Actualizar los datos del profesor
    UPDATE Profesores
    SET id_profesor = v_new_id_profesor, -- Actualizar el ID del profesor
        nombres = p_nombres,
        apellidos = p_apellidos,
        cedula = p_cedula,
        correo = p_correo,
        especialidad = p_especialidad,
        experiencia = p_experiencia,
        usuario = p_usuario,
        contra = p_contrasena
    WHERE id_profesor = p_id_profesor;
    
    COMMIT;
END;
/
//tabla de asignacion de Profersor a una Activiadad o Taller
CREATE TABLE AsignacionProfesor (
  ID_Asignacion INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Id_Docente VARCHAR2(6 BYTE),
  Nombre_Docente VARCHAR2(255),
  Tipo_Asignacion VARCHAR2(50),
  Nombre_ActividadTaller VARCHAR2(255),
  Id_ActividadTaller VARCHAR2(5),
  Nombre_Grupo VARCHAR2(255)
);
select * from AsignacionProfesor;
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
BEGIN
  INSERT INTO AsignacionProfesor (Id_Docente, Nombre_Docente, Tipo_Asignacion, Nombre_ActividadTaller, Id_ActividadTaller, Nombre_Grupo)
  VALUES (p_IdDocente, p_NombreDocente, p_TipoAsignacion, p_NombreActividadTaller, p_IdActividadTaller, p_NombreGrupo);
  COMMIT;
END;
/
//proc Editar un asignacion
CREATE OR REPLACE PROCEDURE sp_EditarAsignacionProfesor (
  p_IDAsignacion IN INT,
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
    p_id_asignacion IN INT
) AS
BEGIN
    DELETE FROM AsignacionProfesor WHERE ID_Asignacion = p_id_asignacion;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('La asignación con ID ' || p_id_asignacion || ' ha sido eliminada.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error al eliminar la asignación: ' || SQLERRM);
END;
/

-- Creación de la Tabla Reclusos del modulo Alcaide
