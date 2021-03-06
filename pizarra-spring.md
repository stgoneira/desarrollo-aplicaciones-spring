# DESARROLLO DE APLICACIONES CON SPRING FRAMEWORK 

## TEMÁTICAS 
[x] Maven 
	* Dependencias 
[x] Spring Core 
	* Autowired 
[x] Spring Data 
	* JdbcTemplate 
	* JPA 
[x] Autenticación 
[x] Autorización 
[]  Transacciones 
[]  REST 
[x] Validation 
[x] Spring Web 
	* Thymeleaf 
	* Controller 
	
## TRABAJOS 

Evidencia Portafolio 07-05-2022
--------------------------------
- Archivo TXT con enlace a repositorio GITHUB de los avances realizados del proyecto CFT 

Evidencia Portafolio 14-05-2022
--------------------------------
- Archivo TXT con enlace a repositorio GITHUB de los avances realizados del proyecto CFT 

Evidencia Portafolio 20-05-2022
--------------------------------
- Tesorería JPA 
- Avances en Content Management System (Autenticación y Autorización) 


Evidencia Portafolio 27-05-2022
--------------------------------
- Proyecto Spring Security (cms) 
- Proyecto en Heroku (solo el enlace) 
- Proyecto API REST (productos)

Evaluación Portafolio (30 Mayo) - Catálogo 
------------------------------------------- 
- Catálogo de Productos con entidades: Producto y Categoría (JPA) 
- Atributos mínimos:
	* Producto: id, nombre, imagen, descripción 
	* Categoría: id, nombre 
- Vista de grilla para ver los productos 
- Vista de lista para ver los productos 
- NO es necesario hacer autenticación 

Trabajo Final (31 Mayo) - Mantenedor Biblioteca 
-------------------------------------------------
- CRUD entidades Libro y Autor
- Se debe acceder al mantenedor usando usuario y contraseña (Autenticación) 
- Utilice JDBC (SQL) 
- Opcionalmente agregue una vista pública para poder buscar libros 


## SESIONES 

Planificación 
--------------

1) Cargar datos iniciales 
2) Registro de estudiantes 
3) CRUD Cursos 
4) Autenticación 
5) Autorización CRUD Admin - Cursos 
6) Autorización - Postulación Cursos 
7) Panel postulación postulante 
8) Panel admin postulaciones 
9) Validación cupos 
10) Deploy en Heroku 


Notas
-------

// ejemplo Controller 

@GetMapping("/ruta") // define la ruta que debes escribir en el Browser 
public String miRuta() { // el método se pueda llamar como tú quieras 
	return "archivo-html"; 
}

-------------------------------------------------



BREAK 10:53 hasta 11:08hrs 

### Sesión - 23 de 23 - Sábado 04 de Junio 

- Avances en trabajos y resolución de problemas 

### Sesión - 22 de 23 - Viernes 03 de Junio 

BREAK 20:05 a 20:20hrs

- Desarrollo de caso Bolsa Laboral (Chile Trabajos) 

Actividad - Spring Security 
-----------------------------
1) Reconocer principales componentes de Spring Security 

2) Generar clase que implementa la interfaz UserDetailsService 

3) Generar clase que implementa la interfaz UserDetails 

4) Configurar los permisos en Archivo de Configuración, con Anotaciones, con condicionales o con Thymeleaf 

### Sesión - 21 de 23 - Jueves 02 de Junio 

BREAK 20:07 a 20:22hrs 

Objetivos del día 
------------------
- Construir esqueleto de aplicación que tiene 2 o más entidades que necesitan autenticarse 

/salir

/ingreso - login form 
/ - Listado de avisos 
/empresa/registro 
/postulante/registro 
/empresa/panel - panel privado de la empresa 
/postulante/panel - panel privado postulante  

### Sesión - 20 de 23 - Miércoles 01 de Junio 

BREAK de 20:00 a 20:15hrs

Objetivos del día 
------------------
- Consumir API REST usando Spring (RestTemplate) 
- Avances en proyectos del módulo 

Actividad - Consumo API Rest (iteración 1)
-------------------------------------------
1) Crear proyecto con dependencia obligatoria Spring Web y opcionales Thymeleaf, Spring Boot DevTools y Lombok 

2) Crear clase que mapee los atributos con las propiedades del documento JSON (mismos nombres) 

3) Crear controller y método que utilice RestTemplate para invocar la API y convertir el resultado en Objeto(s) Java 

4) Opcionalmente mostrar estos datos en una vista de Thymeleaf 

Actividad - Consumo API Rest (iteración 2)
-------------------------------------------
5) Mapear los atributos de la clase Java cuando no se llaman de manera idéntica a los del documento JSON 

6) Generar clases adicionales para objetos incrustados en el doc JSON 

### Sesión - 19 de 23 - Martes 31 de Mayo 

Objetivos del día 
------------------
- Terminar cliente de la API REST utilizando HTML y Javascript 

Actividad - Cliente HTML + JS 
--------------------------------
1) Implementar función JS que utilice fetch() para traer los productos desde la API REST y mostrarlos en una tabla HTML 

2) Atachar función que actualiza la tabla al evento DOMContentLoaded 

3) Crear formulario para productos 

4) Crear función que guarda un producto usando fetch() y el método POST de HTTP. 

5) Vincular la función que guarda un producto al evento submit del formulario 

6) Agregar en la tabla un botón para eliminar. Agregar atributo data-id con el ID del producto (HTML). Adicionalmente colocar una clase (atributo class de HTML) que distinga al botón (ej. producto-eliminar)

7) Escuchar el evento click sobre todos los botones eliminar y atachar función 

8) La función para eliminar un producto usará fetch() para invocar el método DELETE del Web Service 

9) Funcionalidad para editar productos:
	9.1) Agregar campo oculto con ID al formulario 
	
	9.2) Agregar atributo class y data-id al botón editar 
	
	9.3) Escuchar y atachar una función al evento click del botón editar 
	
	9.4) La función anterior invoca el WS (método GET) que devuelve el producto a editar. Y carga estos datos en el formulario 

### Sesión - 18 de 23 - Lunes 30 de Mayo 

BREAK 20:40 a 20:55hrs

Objetivos del día 
-------------------
- Identificar los distintos métodos de HTTP (GET, POST, PUT, DELETE) 
- Crear controlador en Spring usando los distintos métodos HTTP 
- Consumir los servicios desde proyecto HTML 

Actividad - Catálogo REST 
--------------------------- 
1) Crear entidad Producto 
2) Crear repositorio 
3) Crear RestController con operaciones CRUD 
4) Crear proyecto usando solo HTML y JS para consumir los WS 

### Sesión - 17 de 23 - Sábado 28 de Mayo 

BREAK 10:45 a 11:00hrs

Objetivos del día 
------------------
- Reconocer los tipos de datos de la BD que sirven para almacenar archivos 
- Reconocer como crear un formulario HTML que permita la subida de archivos 
- Reconocer la importancia de las cabeceras en HTTP 
- Reconocer la mejor estrategia de backups (respaldos) cuando hay archivos almacenados de por medio 
- Avanzar en proyectos (Proyecto Final Módulo, Proyecto Evaluación Portafolio, Examen)
- Subir evidencia 27 de Mayo  

Actividad - File Upload 
------------------------
1) Proyecto Spring Web + JPA 
2) Crear entidad usando anotación @Lob 
3) Crear repositorio JPA 
4) Crear método en controller usando tipo MultipartFile 
5) Crear método en el controller que nos permita utilizar el archivo 

### Sesión - 16 de 23 - Viernes 27 de Mayo 

BREAK 20:00 a 20:15hrs 

Objetivos del día
------------------
- Reconocer la utilidad de un Web Service 
- Reconocer el formato de intercambio JSON, XML y Texto Plano 
- Construir un Web Service básico usando Spring 
- Consumir un Web Service desde un 2do proyecto 
- Avanzar en Examen Certificación, Proyecto Final o Evaluación Portafolio 

### Sesión - 15 de 23 - Jueves 26 de Mayo 

BREAK de 20:06 a 20:21hrs 

Objetivos del día 
----------------- 
- Revisión del caso examen de certificación
- Planificación iterativa del mismo 
- Avanzar en la estructura del proyecto (Github, Heroku y documentación) 

### Sesión - 14 de 23 - Miércoles 25 de Mayo 

BREAK de 20:00 a 20:15hrs 

Objetivo del día 
-----------------
Desplegar proyecto Java + Spring en plataforma Heroku. 

Pasos 
-------
1) Crear una cuenta en Heroku e instalar Heroku CLI
2) Vincular nuestro proyecto a través de GIT 
3) Configurar la versión de Java que debe utilizar Heroku 
4) Heroku Addon - (PostgreSQL) 
5) Integrarnos a las variables ambientales de Heroku 
6) Probar el despliegue 


Actividad - Despliegue de mi App Spring en Heroku 
---------------------------------------------------
1) Crear cuenta en Heroku.com 
2) Instalar Heroku CLI 
3) Ejecutar en PowerShell y seguir los pasos para autenticación:
heroku login 
4) Crear proyecto Java + Spring con dependencias de: Dev Tools, Spring Web y Thymeleaf 
5) Crear 2 rutas en un controller y sus respectivos archivos HTML 
6) Configurar la versión de Java que debe utilizar Heroku. Debemos crear un archivo llamado system.properties, en la raíz del proyecto (al mismo nivel que el pom.xml) con el siguiente contenido: 

java.runtime.version=11

7) Inicializar repositorio local de GIT con el comando (dentro de la carpeta del proyecto usando PowerShell):

git init 

8) Es vincular el repositorio remoto de Heroku:

heroku git:remote -a el-nombre-de-su-proyecto-heroku

9) Hacer commit y push del repositorio 

git add -A 
git commit -m "preparando deploy Heroku"
git push heroku master 

Actividad - Agregar Soporte BD en Heroku 
------------------------------------------ 

1) Agregar Addon "Heroku Postgres" 

2) Agregar dependencias a proyecto Spring (Driver + JPA | JDBC + Lombok[opcional])

3) Configurar proyecto Java para conexión con variables ambientales: application.properties 

spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}

4) Configurar variables ambientales en Sistema Operativo (ambiente desarrollo) para conectar con un PostgreSQL instalado de manera local o alternativamente usar alguna plataforma como ElephantSQL  

JDBC_DATABASE_URL
JDBC_DATABASE_USERNAME
JDBC_DATABASE_PASSWORD

5) Reiniciar Spring Tool Suite para que reconozca las variables ambientales 

6) Generar algún código que genere algo en la Base de Datos, por ejemplo una entidad JPA para que se cree una nueva tabla en la BD. 

7) Revisar que se haya generado el cambio en la BD de desarrollo 

8) Desplegar en Heroku 

9) Visitar la URL 

10) Conectar PgAdmin u otro cliente a la BD de Heroku 

11) Revisar que se haya hecho la modificación en la BD de Heroku (Producción) 

### Sesión - 13 de 23 - Martes 24 de Mayo 

BREAK 20:00 a 20:15hrs

Objetivo del día
------------------
Implementar la autenticación del trabajo final (mantenedor biblioteca) 

### Sesión - 12 de 23 - Lunes 23 de Mayo 

BREAK de 20:30 a 20:45hrs

Objetivo del día
------------------

- Autorización usando JPA y JdbcTemplate

Actividad Autenticación y Autorización JPA 
-------------------------------------------
1) Revisar y agregar dependencia a JPA y Driver correspondiente

2) Crear una base de datos para el proyecto 

3) Configurar el datasource y JPA en modo UPDATE en application.properties 

4) Crear una clase @Entity que representa al usuario. Como mínimo tiene que tener un campo para el username, para la password y para los roles. 

Checkpoint - que se haya creado automáticamente la tabla en la BD 

5) Implementar UsuarioRepository 

6) Configurar @Bean que defina la clase a utilizar por Spring Security para codificar las contraseñas 

7) Crear clase @Service que sabe como crear un usuario y codificar su contraseña 

8) Generar ruta en controller (ej. /admin/instalar) que generará un usuario inicial en el sistema.

9) Dar permiso a ruta /admin/instalar 

Checkpoint: es ingresar a esa ruta y que aparezca el usuario en la tabla de la BD 

10) Crear clase que implemente interfaz UserDetailsService. Esta clase buscará el usuario en la BD y lo devolverá en formato entendible para Spring Security. Recuerde anotarla con @Service  

11) Configurar Spring Security para que utilice el servicio del tipo UserDetailsService y que utilice el codificado de password que generamos:

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth 
		.userDetailsService( miServicioUsuario )
		.passwordEncoder( passwordEncoder ) 
	;
} 

### Sesión - 11 de 23 - Viernes 20 de Mayo 

BREAK de 20:12 a 20:27hrs

- Autorización con formulario personalizado 
- Generamos usuarios a través de clase Java 


Actividad - Form Personalizado 
--------------------------------

1) Configurar en método configure(HttpSecurity http) 
la ruta del formulario:

http.formLogin( form -> form 
				.loginPage("/mi-form-personalizado") 
				.defaultSuccessUrl("/") 
				.permitAll()
			)
2) Crear un controller con la ruta al formulario personalizado 

3) En la vista (html) el formulario personalizado debe tener un campo llamado username y otro llamado password. El formulario debe ser enviado por POST a la misma URL del formulario 

### Sesión - 10 de 23 - Jueves 19 de Mayo 

BREAK de 20:20 a 20:35hrs

- Autenticación sin BD externa 
- Autorización 
- Utilizar los fragmentos de Thymeleaf 

Actividad - Spring Security - CMS 
---------------------------------- 

### Versiones 

1.0 )
- Spring Web 
- Dev Tools 
- Thymeleaf 
- Spring Security 
- Lombok (opcional)

### Controllers 

SitioController 

AdminController

### Rutas

/inicio (pública)
/nosotros (pública)
/contacto (pública)
/admin/index (privada)
/admin/reporte (privada)

### Partes
templates/parts/head.html 
templates/parts/menu.html 
templates/parts/scripts.html 

## v2) Configurar un usuario y contraseña (application.properties)
spring.security.user.name=santiago
spring.security.user.password=mipass
spring.security.user.roles=ADMIN

## v2.1) Configurar los permisos 

## v2.2) Personalizar el Login Form 

## v3) Configurar varios usuarios

## v4) Configurar usuarios con JPA 

## v5) Configurar usuarios con JDBC 








### Sesión - 9 de 23 - Miércoles 18 de Mayo 

BREAK 20:30 a 20:45hrs

- Reconocer la utilidad del proyecto Lombok 
- Reconoce las tareas que se ejecutan con Maven (clean, test, package, install) 
- Ejecutar Maven desde Spring Tool Suite 
- Ejecutar Maven desde un entorno tipo Terminal 
- Generar empaquetado JAR del proyecto Spring 
- Ejecutar fuera de Spring Tool Suite un proyecto web

Actividad - Lombok 
-------------------- 
1) Descargar el JAR desde https://projectlombok.org/download 

2) Ejecutar el JAR y especificar la ruta del Spring Tool Suite 

3) Reiniciar Spring Tool Suite si estaba ejecutándose 

4) Generar proyecto Spring agregando la dependencia de Lombok 

5) Generar una clase simple en Java con solo sus atributos 

6) Anotar la clase con:
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

7) Agregue y remueva anotaciones para identificar los cambios que se producen en la lista de métodos y constructores usando Eclipse (STS) 


### Sesión - 8 de 23 - Martes 17 de Mayo 

BREAK de 20:25 a 20:40hrs 

Objetivos del día
------------------
- Implementar entidades relacionadas usando JPA 

### Sesión - 7 de 23 - Lunes 16 de Mayo 

BREAK 20:45 a 21:00hrs 

Objetivos del día
------------------
- Reconocer la funcionalidad de un ORM 
- Integrar Hibernate a proyecto de Spring 
- Identificar las anotaciones más comunes de JPA 
- Reconocer la utilidad de la interfaz JpaRepository de Spring 


Actividad Tesorería JPA 
-------------------------
1) Generar proyecto Web con dependencia "Spring Data JPA" 
2) Configurar conexión BD en archivo applications.properties  

### Sesión - 6 de 23 - Sábado 14 de Mayo

BREAK 10:30 hasta 10:45hrs 

Actividad - Soporte vinculación Alumno - Carrera 
-------------------------------------------------
1) Modificar la entidad (clase Java)
	* Crear Carrera 
	* Modificar Alumno
2) Modificar la tabla en la BD (Foreign Key) 
	CREATE TABLE carreras(
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre CHAR(50) NOT NULL
	);
	ALTER TABLE alumnos
		ADD COLUMN carrera_id INT,
		ADD FOREIGN KEY(carrera_id) REFERENCES carreras(id)
	;
3) Agregar un converter a Spring 
4) Modificación formulario 
5) Modificar todos los componentes dependientes:
	* Repositorio 
	* Controller 
	* Formularios 

Tarea (Terminar antes del Break)
-------
- Crear el CRUD de la entidad Carrera 
- Soporte un id, nombre y descripción para la entidad Carrera 

Objetivos de hoy 
------------------
- Repasar conceptos principales de Spring vistos hasta hoy 
- Agregar soported CRUD a entidad Carrera 
- Configurar converter en Spring 

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







