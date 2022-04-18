<h1 align="center">Guia para despliegue Backend</h1>
<!-- ------------------------------------------  -->
<h2 align="center"> 1. Descarga de programas necesarios </h2>

<p>El proceso se realiza en un sistema operativo `Windows 10` acompañado de cada app necesario para le buen funcionamiento: </p>
<ul>
    <li><a href="https://www.eclipse.org/downloads/packages/release/2021-09/r">Eclipse</a> (IDE for java developers 2021-09)</li>
    <li><a href="https://www.postgresql.org/download/">PostgreSQL</a> (Version 14)</li>
    <li><a href="https://www.java.com/es/download/ie_manual.jsp">Java</a> (Version 8 Update 321)</li>
</ul>
<!-- ------------------------------------------  -->
<h2 align="center"> 2. Instalacion de programas necesarios</h2>

<p>Cada proceso de instalacion es habitual, aceptar terminos y condiciones, siguiente... siguiente... instalar</p>
<strong>Nota: </strong>En la instalacion de postgreSQL recuerda colocar los datos de seguridad de Name y Password
<!-- ------------------------------------------  -->
<h2 align="center"> 3. Configurar Eclipse con Springboot</h2>
 
Una vez abierto eclipse, nos dirigimos a la pestaña superior llamada Help -> Eclipse Marketplace

<img src="./Img/Screenshot_10.png"/>

Luego buscamos Sprinboot en el Find e instalamos "Spring tools 3 Add-On for Spring Tools 4 3.9.21.RELEASE"

<img src="./Img/Screenshot_11.png"/>

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
    <img src="./Img/Screenshot_3.png"/>
    </li></br>
    <!-- 4 -->
    <li><p>Se coloca nombre a la BD: BD_SafeLife(nombre opcional): </p>
    <img src="./Img/Screenshot_4.png"/>
    </li></br>
    <!-- 5 -->
    <li><p>Vamos a configurar nuestra BD: </p>
    Nos dirigimos hacia el menu Connection e ingresamos los datos:</br>
    <strong>Host: </strong>ec2-18-214-134-226.compute-1.amazonaws.com</br>
    <strong>Database: </strong>d4g3aaahil971t</br>
    <strong>User: </strong>prizigyckacpqw</br>
    <strong>Password: </strong>e2d23030a963fde759b5f8453ef983aeef8643ccfe444de26948dad7b98d3a35</br>   
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

<p>Luego, vamos a importar la carpeta ProyectoColab a eclipse</p>

<img src="./Img/Screenshot_12.png"/>
<img src="./Img/Screenshot_13.png"/>
<img src="./Img/Screenshot_14.png"/>

<p>Para finalizar le damos click derecho encima de la carpeta principal del proyecto, luego en Run as y ejecutamos con Spring Boot App</p>

<img src="./Img/Screenshot_15.png"/>

Y vemos como se ejecuto correctamente

<img src="./Img/Screenshot_16.png"/>

















