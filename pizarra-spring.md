# DESARROLLO DE APLICACIONES CON SPRING FRAMEWORK 

## TEMÁTICAS 

## TRABAJOS 


## SESIONES 

### Sesión - 6 de 23 - Sábado 14 de Mayo

BREAK 10:30 hasta 10:45hrs 

Tarea (Terminar antes del Break)
-------
- Crear el CRUD de la entidad Carrera 
- Soporte un id, nombre y descripción para la entidad Carrera 

Objetivos de hoy 
------------------
- 

Repaso
------- 
- Gestionando el proyecto y las depencias con Maven 
- Reconocer la sintaxis e información que va dentro del archivo pom.xml 
- Iniciar proyectos usando STS o start.spring.io
- Reconocer la función que cumplen los siguientes componentes de Spring: 
	* Spring Web 
	* Thymeleaf 
	* Spring Boot Devtools 	
	* Validation 
	* JDBC API (JdbcTemplate) 
	* Driver BD (Mysql, PostgreSQL u otro)
- Reconocer la sintaxis de una anotación en Java 
- Reconocer las siguientes anotaciones: 
	* @Autowired (inyección de dependencias) 
	* @Controller 
	* @RequestMapping 
	* @GetMapping
	* @PostMapping 
	* @Repository 
- Reconocer el uso de los elementos básicos de Thymeleaf:
	* th:text 
	* th:each 
	* ${objeto} ${objeto.atributo}
	* @{/enlace} @{/enlace/{entidadId}}
	
	
### Sesión - 5 de 23 - Viernes 13 de Mayo

BREAK de 20:05 hasta 20:20hrs

Instrucciones
---------------
1) Instalar XAMPP 
2) Levantar servidor Apache y MySQL 
3) Ingresar en Browser preferido a la sgte URL:
http://localhost/phpmyadmin  
4) Crear Base de Datos, se sugiere nombrarla cft 
5) Crear tabla alumnos con el sgte comando SQL:

CREATE TABLE alumnos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre CHAR(50) NOT NULL,
	fecha_nacimiento DATE NOT NULL 
);

6) Eliminar la dependencia del driver de PostgreSQL 
7) Agregar la dependencia al driver MariaDB 
8) Actualizar las propiedade de conexión (application.properties) 

OPCIONAL (pero recomendado)
9) Guardar proyecto en repositorio GIT antes de comenzar con el refactoring del código 
10) comando > git init 
11) commando > git add -A 
12) comando > git commit -m "antes del refactoring de agregar fecha LocalDate"

AGREGAR FECHA NACIMIENTO (LocalDate) 
13) Eliminar el atributo edad y agregar el atributo fechaNacimiento
14) Modificar getters/setters/constructores según corresponda 
15) Corregir la clase Repository para adecuarse al nuevo campo 
16) Corregir template alumno-form.html 
17) Corregir template alumno-ficha.html 
18) Modificar application.properties para configurar la conversión de fecha desde HTML a Java 

AGREGAR SOPORTE CRUD PARA ALUMNO 
19) Reestructuración del código de Controller para posteriormente soportar más entidades de manera ordenada (@RequestMapping y rutas parametrizadas)
20) Reorganización en carpetas por entidad de los templates
 
templates/
	alumno/
		ficha.html 
		form.html 
		listado.html
	index.html 

21) Se creo template listado.html dentro de carpeta alumno para poder mostrar el listado de alumnos. Conceptos nuevos (Enlaces parametrizados y función each de Thymeleaf)

22) Corregir el atributo action del formulario de Alumno 

Objetivos del día 
------------------

- Completar CRUD Alumno y opcionalmente el de Carrera 
- Conectar a una BD distinta (MySQL) 
- Reconocer cómo integrar campos de fechas entre Thymeleaf y Jdbctemplate 
- Agregar entidad Carrera 
- Identificar la sintaxis de Thymeleaf para generar enlaces parametrizados 
- Reconoce las tareas que se ejecutan con Maven (clean, test, install, package) 
- Reconocer la utilidad del proyecto Lombok 
- Ejecutar Maven desde Spring Tool Suite 
- Ejecutar Maven desde un entorno tipo Terminal 
- Generar empaquetado JAR del proyecto Spring 
- Ejecutar fuera de Spring Tool Suite un proyecto web 

### Sesión - 4 de 23 - Jueves 12 de Mayo

BREAK 20:15 a 20:30hrs 

Actividad - Conexión BD PostgreSQL 
-----------------------------------
1) Agregar dependencias: JDBC APi y PostgreSQL Driver 

2) Configurar el datasource en application.properties 

3) Generar interfaces DAO o Repository 
3.1) Agregar atributo id a la clase Alumno 
3.2) Agregar constructor con los 3 parámetros (id, nombre, edad)
3.3) Agregar getters/setters 

4) Generar las implementaciones DAO o Repository 

Objetivos del día 
------------------

- Incluir dependencias en nuestro proyecto 
- Usan JdbcTemplate de Spring para hacer consultas SQL sobre una BD relacional 
- Reconocer las diferencias entre el patrón DAO y Repository 


### Sesión - 3 de 23 - Miércoles 11 de Mayo

BREAK 19:55 hasta 20:10 hrs 

Objetivos del día 
------------------

- Procesar Formularios con Spring 
- Validar formularios web usando Hibernate Validator (JSR 380) 
- Agregar dependencias a proyecto Spring 
- Identificar las versiones de las librerías del proyecto 
- Reconocer la vinculación e importancia de la documentación primaria y las versiones 
- Reconocer el rol de Spring en la integración de distintos proyectos 


### Sesión - 2 de 23 - Martes 10 de Mayo

BREAK 20:20 a 20:35hrs

Objetivos del día 
------------------
- Reconocer la herramienta Spring Tool Suite 
- Reconocer el cómo iniciar un proyecto utilizando Spring Boot 
- Crear un sitio básico utilizando Spring MVC y Thymeleaf 
- Reconocer el archivo pom.xml de Maven 
- Reconocer cómo saber las versiones de las librerías instaladas en Spring 
- Realizar pruebas simples de un proyecto web utilizando MockMVC 
- Reconocer cómo agregar más dependencias de Spring al proyecto 


### Sesión - 1 de 23 - Lunes 9 de Mayo (20:00 a 21:30hrs)

BREAK de 20:07 a 20:22hrs 

Actividad - Instalación Spring Tool Suite 
-------------------------------------------
1) Descargar el programa para su S.O. desde https://spring.io/tools 

2) Ejecutar el JAR descargado (descomprime una carpeta)

3) La carpeta la puede ubicar donde ud. quiera 

4) Finalmente ejecutar SpringToolSuite4.exe







