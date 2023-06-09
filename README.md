<!--- Escribe en breve un resumen del proyecto --->
# Proyecto Watson Assistant - Chatbot
<!--- Escribe una breve descripción del proyecto --->
## Descripción del proyecto
Este proyecto es un chatbot el cual se comunica con el servicio de Watson Assistant, el cual es un servicio de inteligencia artificial que permite crear chatbots para que puedan interactuar con los usuarios de una manera más natural. Este chatbot es uno generico que habla de una empresa cualquiera, y que tiene como objetivo dar información sobre la empresa, sus productos y servicios, y también permite tramos con el seguro del coche.
## Descripción de la arquitectura
La arquitectura de este proyecto es la siguiente:
 + Backend: Spring Boot (Java)
 + Frontend: Angular 8

#
## Descripción de la implementación
### Backend
El backend está implementado en Java con el framework Spring Boot. Este backend se encarga de comunicarse con el servicio de Watson Assistant, y de devolver la respuesta del chatbot via json por un metodo http GET.
### Frontend
El frontend está implementado en Angular 8. Este frontend se encarga de mostrar la interfaz de usuario, y de comunicarse con el backend para obtener la respuesta del chatbot.
#
## Descripción de la instalación
### Backend
Para instalar el backend, se debe ejecutar el siguiente comando:
```bash
mvn clean install
```
### Frontend
Para instalar el frontend, se debe ejecutar el siguiente comando:
```bash
npm install
```
#
## Descripción de la ejecución
### Backend
Para ejecutar el backend, se debe ejecutar el siguiente comando:
```bash
mvn spring-boot:run
```
Esto ejecutará el backend en el puerto 8080 a la escucha de peticiones http de tipo GET y con el metodo /send.
### Frontend
Para ejecutar el frontend, se debe ejecutar el siguiente comando:
```bash
ng serve
```
o alternativamente puedes ejecutar lo siguiente
```bash
npm start
```
Esto ejecutará el frontend en el puerto 4200 a la espera de un usuario que acceda a la aplicación.

**Nota**: Si quieres mandar mensajes por el frontend, debes ejecutar el backend antes que el frontend, ya que el frontend se conecta al backend para obtener la respuesta del chatbot.

#
## Descripción de la configuración
### Backend
El backend se configura mediante el fichero application.properties, el cual se encuentra en la ruta src/main/resources. En este fichero se debe configurar la url del servicio de Watson Assistant, la apikey y el workspaceid, además de la fecha de la version de Watson Assistant que se está utilizando.

application.properties sigue esta estructura en el archivo:
```properties
ibm.watson.assistant.apikey = APIKEY
ibm.watson.assistant.url = URL
ibm.watson.assistant.id = ID
ibm.watson.assistant.version = YYYY-MM-DD
``` 
Simplemente sustituye con tus datos los valores de APIKEY, URL, ID y la version. La version debe ser la fecha de la version de Watson Assistant que se está utilizando y debe seguir el formato YYYY-MM-DD.
### Frontend
Frontend no requiere configuración especial.

#
## Notas
### Backend
Este bot de momento solo es capaz de responder con texto, imagenes y opciones de respuesta. Es posible que si tu bot de Watson Assistant tiene más opciones, el bot no las pueda responder.
### Frontend
Si quieres mandar otros tipos de mensajes, como por ejemplo, un audio, debes modificar el código del frontend para que pueda enviar el mensaje y recibir la respuesta del chatbot.
#
## Generar documentacion / Ver documentacion
### Backend
Para generar la documentación del backend, se debe ejecutar el siguiente comando:
```bash
mvn javadoc:javadoc
```
Esto generará la documentación en la ruta target/site/apidocs. Para ver la documentación, abre el fichero index.html que se encuentra en la ruta target/site/apidocs.
### Frontend
Para generar la documentación del frontend, se debe ejecutar el siguiente comando:
```bash
npm run compodoc
```
Esto generará la documentación en la ruta documentation. Para ver la documentación, abre el fichero index.html que se encuentra en la ruta documentation.

**Asegurate de estar en las carpetas correspondientes antes de ejecutar los comandos.**
### Android
Para generar la documentación del android, se debe ejecutar el siguiente comando:
```bash
./gradlew dokkaHtml
```
Esto generará la documentación en la ruta app/build/dokka/html. Para ver la documentación, abre el fichero index.html que se encuentra en la ruta.

#
## Licencia
Este proyecto está bajo la licencia GLP-3.0 - mira el fichero [LICENSE](LICENCE) para más detalles.

#
## Autor
+ **Pablo Sánchez López** - [PSL2001](https://github.com/PSL2001)

#
