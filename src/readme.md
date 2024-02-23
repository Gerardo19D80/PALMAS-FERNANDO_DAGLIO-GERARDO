#### Este examen esta realizado por: Fernando Palmas y Gerardo Daglio. Camada-1

## ENUNCIADO

La clínica odontológica ahora nos pide que desarrollemos la posibilidad de gestionar a los **odontólogos**. Es decir, que el sistema permita registrar los **odontólogos** y **listarlos**.

#### Luego del relevamiento obtuvimos la siguiente información:

Un odontólogo tiene: 
    
    private int numeroMatrícula;
    private String nombre;
    private String apellido;

#### Nuestro chapter lead de arquitectura nos pide:

**TAREA 1**
Que un integrante de la dupla desarrolle la **funcionalidad de persistencia** utilizando H2 como base de datos aplicando el patrón DAO para acceder a los datos, realizar los métodos que nos permitan: 

1. guardar un odontólogo, 
2. y listar todos los odontólogos.

**TAREA 2**
Que el otro integrante de la dupla desarrolle otra funcionalidad de persistencia sin utilizar una base de datos y utilizando una colección a elección (ArrayList, HashMap o HashSet) dentro del mismo patrón DAO para acceder a los datos y realizar los métodos que nos permitan:

1. guardar un odontólogo, 
2. y listar todos los odontólogos.

**TAREA 3**
Loguear el resultado o la ejecución de cada operación utilizando log4j.

**TAREA 4**

- Crear un script SQL para la creación de las tablas con sus respectivos atributos.
- 
- Tests: Con JUnit testear el listado de todos los odontólogos (previamente guardar algunos odontólogos).

## Observaciones

CREATE SQL

DROP TABLE IF EXISTS ODONTOLOGOS;

CREATE TABLE ODONTOLOGOS (
ID INT AUTO_INCREMENT PRIMARY KEY,
NUMEROMATRICULA INT NOT NULL,
NOMBRE VARCHAR(100) NOT NULL,
APELLIDO VARCHAR(100) NOT NULL,
);

