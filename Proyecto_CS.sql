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

-- Crear el stored procedure para eliminar una actividad y actualizar los IDs
CREATE OR REPLACE PROCEDURE sp_eliminar_actividad(
    p_id_actividad IN VARCHAR2
)
IS
    TYPE actividad_type IS TABLE OF Actividades%ROWTYPE;
    v_actividades actividad_type;
BEGIN
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

/*SELECT *
FROM Actividades
ORDER BY ID_actividad;
DELETE FROM actividades
DELETE FROM actividades where id_actividad ='#A002'*/
-- Creación de la Tabla Talleres del modulo Alcaide

CREATE TABLE TalleresAlcaide (
    ID_TALLER VARCHAR2(5),
    NOMBRE_TALLER VARCHAR2(100),
    CANTIDAD_GRUPOS NUMBER,
    CAPACIDAD_MAXIMA NUMBER,
    FECHA_CREACION DATE
);

CREATE OR REPLACE PROCEDURE sp_agregar_taller(
    p_nombre IN VARCHAR2,
    p_cantidad_grupos IN NUMBER,
    p_capacidad_maxima IN NUMBER,
    p_fecha_creacion IN DATE
)
IS
    v_new_id VARCHAR2(5);
BEGIN
    -- Obtener el ID máximo actual
    SELECT '#' || 'T' || LPAD(NVL(MAX(TO_NUMBER(SUBSTR(ID_TALLER, 4))), 0) + 1, 3, '0')
    INTO v_new_id
    FROM TalleresAlcaide;

    -- Insertar el nuevo taller
    INSERT INTO TalleresAlcaide(ID_TALLER, NOMBRE_TALLER, CANTIDAD_GRUPOS, CAPACIDAD_MAXIMA, FECHA_CREACION)
    VALUES (v_new_id, p_nombre, p_cantidad_grupos, p_capacidad_maxima, p_fecha_creacion);

    COMMIT;
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


-- Crear el stored procedure para eliminar un taller
CREATE OR REPLACE PROCEDURE sp_eliminar_taller(
    p_id IN NUMBER
)
IS
BEGIN
    DELETE FROM TalleresAlcaide WHERE ID_TALLER = p_id;
    
    COMMIT;
END;
/

/*BEGIN
  sp_agregar_taller('Programación', 3, 30, SYSDATE);
END;



/*
SELECT *FROM TalleresAlcaide
ORDER BY ID_TALLER
    DELETE FROM talleresalcaide*/
-- Creación de la Tabla Profesores del modulo Alcaide
-- Creación de la Tabla Reclusos del modulo Alcaide

