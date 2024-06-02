# 🎓 EduManager 📚

¡Bienvenido a EduManager! Una solución integral para la gestión educativa, diseñada para ayudarte a administrar horarios de clases, generar PDFs y enviar correos electrónicos automáticamente. 🌟

<!-- INFORMATION -->

## Gracias por Visitar el Proyecto

<img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/login.png" alt="img" align="right" width="320px">

### Funcionalidades de EduManager

- **Control de Estudiantes**
- **Control de Profesores**
- **Control de Coordinadores**
- **Inscripción de Materias**
- **Calificación de Grupos**
- **Envío de Horarios por Correo**
- **Descarga de Horarios como PDF**

## Variables de Entorno

Para comenzar a usar el proyecto, lo primero que debes hacer es crear un archivo `.env` con las siguientes credenciales:

```
SERVER=localhost:3306
USER_ID=root
DATABASE=control_escolar
PASSWORD=
EMAIL=
EMAIL_PASSWORD=
```

## Guía de Uso

### Crear una Cuenta de Gmail

<p align="left" width="400px">
Para empezar, debes crear una cuenta de Gmail que se utilizará para enviar emails a los usuarios y recibir los correos que llegan a soporte. Asigna el email a la variable `EMAIL` en el archivo `.env`.

Luego de crear la cuenta, activa la verificación en dos pasos desde la pestaña "Seguridad". Después de eso, dirígete al siguiente enlace: [App Passwords](https://myaccount.google.com/apppasswords) y crea una nueva aplicación con el nombre que desees. La contraseña que te aparezca, asígnala a la variable `EMAIL_PASSWORD` en el archivo `.env`.
</p>

<img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/appPasswords.png" alt="img" align="right" width="400px">

### Instalar MySQL y Crear la Base de Datos

<p align="left" width="400px">

Si no tienes MySQL instalado, descárgalo e instálalo desde la [Pagina oficial de MySQL](https://dev.mysql.com/downloads/installer/). También es necesario que descargues [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) para poder ejecutar el script que crea la base de datos. Si conoces otra forma de hacerlo, este paso no sería necesario.

Durante la instalación de MySQL, configura una contraseña para el usuario root. Recuerda agregar esa contraseña a la variable `PASSWORD` en el archivo `.env`.

1. Haz clic en "LocalInstance MySQL".
2. Abre el script `CreateDB` ubicado en la carpeta SQL del proyecto.
3. Haz clic en el icono del rayo para ejecutar el script y crear la base de datos.
</p>

<p align="center" width="800px">
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/LocalInstance.png" width="400px" />
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/OpenSqlScript.png" width="400px" />
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/ExecuteScript.png" width="800px" />
</p>

### Insertar Datos desde el Panel de Administrador

Por defecto, las claves de administrador son las siguientes:
- **Username:** 11111111
- **Password:** Password9$

> [!IMPORTANT]  
> Después de iniciar sesión por primera vez, dirígete al panel del perfil del administrador y cambia la contraseña.

Para importar los datos desde el archivo de Excel, simplemente haz clic en el botón "Importar Datos" en el panel del administrador.

<p align="center">
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/AdminForm.png" width="400" />
</p>

Modifica el archivo de Excel antes de importarlo si deseas cambiar los usuarios. En el campo de contraseña, la contraseña debe estar hasheada. Puedes ingresar al panel del administrador e ingresar una contraseña para que te devuelva su hash. Por defecto, todos los usuarios tienen el hash de la contraseña `Password9$`.

## Ejecución del programa

Dirigite al directorio dist y da doble click en el archivo EduManager.jar

## Vistas de los Usuarios

<p align="center">
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/studentForm.png" width="400" />
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/teacherForm.png" width="400" />
  <img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/coordinatorForm.png" width="400" />
</p>

## Implementaciones

Los estudiantes pueden descargar su horario o recibirlo por medio de su email asi como enviar preguntas al email de soporte.

<img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/email.png" width="800" />
<img src="https://github.com/cr1st1anhernandez/EduManager/blob/main/screenshot/schedule.png" width="400" />

## 📬 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadida nueva característica'`).
4. Sube los cambios a tu repositorio (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

## 📞 Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme a través de LinkedIn o envíame un correo a cristian0402218@gmail.com.

¡Gracias por usar EduManager! 🎉 ¡Esperamos que este proyecto te sea de gran ayuda!