<h1 align="center">Guia para despliegue Backend</h1>
<!-- ------------------------------------------  -->
<h2 align="center"> 1. Descarga de programas necesarios </h2>

<p>El proceso se realiza en un sistema operativo `Windows 10` acompañado de cada app necesario para le buen funcionamiento: </p>
<ul>
    <li><a href="https://www.eclipse.org/downloads/">Eclipse</a></li>
    <li><a href="https://www.postgresql.org/download/">PostgreSQL</a></li>
    <li><a href="https://www.java.com/es/download/ie_manual.jsp">Java</a></li>
    <li><a href="https://git-scm.com/downloads">Git</a></li>
</ul>
<!-- ------------------------------------------  -->
<h2 align="center"> 2. Instalacion de programas necesarios</h2>

<p>Cada proceso de instalacion es habitual, aceptar terminos y condiciones, siguiente... siguiente... instalar</p>
<strong>Nota: </strong>En la instalacion de postgreSQL recuerda colocar los datos de seguridad de Name y Password
<!-- ------------------------------------------  -->
<h2 align="center"> 3. Configurar Eclipse con Springboot</h2>
 
Una vez abierto eclipse, nos dirigimos a la pestaña superior llamada Help -> Eclipse Marketplace

<img src="./Img/Screenshot_11.png"/>

Luego buscamos Sprinboot en el Find e instalamos "Spring tools 3 Add-On for Spring Tools 4 3.9.21.RELEASE"

<img src="./Img/Screenshot_12.png"/>

<!-- ------------------------------------------  -->
<h2 align="center"> 4. Configurar BD (PostgreSQL)</h2>

<p>Con el programa descargado previamente (PostgreeSQL):</p>

<ol>
    <!-- 1 -->
    <li><p>Buscar la carpeta Postgree en el inicio (tecla windows) y abrir pgAdmin 4: </p>
    <img src="./Img/Screenshot_1.png"/>
    </li></br>
    <!-- 2 -->
    <li><p>Al ingresar se pedira la contraseña ingresada en la etapa de instalacion: </p>
    <img src="./Img/Screenshot_2.png"/>
    </li></br>
    <!-- 3 -->
    <li><p>Luego abre servers, posterior register y finalmente server: </p>
    <img src="./V/Screenshot_3.png"/>
    </li></br>
    <!-- 4 -->
    <li><p>Se coloca nombre a la BD: BD_SafeLife(nombre opcional): </p>
    <img src="./Img/Screenshot_4.png"/>
    </li></br>
    <!-- 5 -->
    <li><p>Vamos a configurar nuestra BD: </p>
    Nos dirigimos hacia el menu Connection e ingresamos los datos:</br>
    <strong>Host: </strong>ec2-34-192-210-139.compute-1.amazonaws.com</br>
    <strong>Database: </strong>d3uef5qnrfdnk2</br>
    <strong>User: </strong>gsiyywzbkfonjy</br>
    <strong>Password: </strong>7df55e61c0ebcc9a79d0e7af8d3f26b18d5bdf53c474451a9a52c585fc49e3fe</br>   
    <img src="./Img/Screenshot_5.png"/>
    </li></br>
    <!-- 6 -->
    <li><p>Luego nos dirigimos en la pestaña Advanced y en DB restriction agregamos el Database, finalizamos en Save: </p>
    <img src="./Img/Screenshot_6.png"/>
    </li></br>
    <!-- 6 -->
    <li><p>Verificamos que se hayan creado las tablas: </p>
    <img src="./Img/Screenshot_7.png"/>
    </li></br>
<!-- ------------------------------------------  -->
<h2 align="center"> 5. Preparando el despliegue</h2>

<p>Para un correcto despliegue de Backend, este, se debe descargar desde el repositorio de Github :</p>

`https://github.com/GeanDev2022/Software/tree/Backend`

<p>De esta forma: </p>
<img src="./Img/Screenshot_8.png"/>

<p>Luego descomprime este .ZIP en una carpeta de su interes, le queda una carpeta llamada "Software-Backend", dentro de ella se encuentra el codigo del Backend (ProyectoColab)</p>
<img src="./Img/Screenshot_9.png"/>

<p>Posterior a eso, debemos dirigirnos a la rama "deploy" donde se encuentra las configuraciones del despliegue del proyecto, ademas del .JAR generado</p>
<img src="./Img/Screenshot_.png"/>

<p>Vamos a la carpeta target, y dentro de ella sin seleccionar ningun archivo damos click derecho y abrimos un "Git Bash here" e ingresamos: </p>

`java -jar ProyectoColab-0.0.1-SNAPSHOT.jar`

<img src="./Img/Screenshot_10.png"/>
<p>Despues de desplegado el proyecto en Tomcat, podemos acceder a los recursos de este mediante http://localhost:8080</p>

















