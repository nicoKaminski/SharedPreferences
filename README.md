# SharedPreferencesApp

Esta aplicación de Android demuestra el uso de `SharedPreferences` para guardar información de contactos, el almacenamiento interno para guardar una bitácora y el almacenamiento externo (tarjeta SD) para guardar notas, implementando tres Activities.

## Descripción

La aplicación consta de tres Activities:

*   **MainActivity:** Permite al usuario ingresar y guardar texto en una bitácora utilizando almacenamiento interno. Al iniciar la aplicación, se recupera el contenido de la bitácora guardada (si existe) y se muestra en un `EditText`. Al presionar el botón "Guardar Bitácora", se guarda el texto ingresado y la aplicación se cierra.

*   **AgendaActivity:** Permite al usuario guardar y buscar información de contactos (nombre y datos). La información se guarda usando `SharedPreferences`, donde el nombre del contacto es la clave y los datos son el valor.

*   **SdActivity:** Permite al usuario guardar y consultar notas en el almacenamiento externo (tarjeta SD).  Las notas se guardan en archivos individuales, donde el nombre del archivo es el nombre de la nota.

## Uso

### MainActivity (Bitácora)

1.  Al iniciar la aplicación, se mostrará en el campo de texto etiquetado como "Bitácora" el contenido previamente guardado (si existe).
2.  Ingresa o modifica el texto en el campo de texto "Bitácora".
3.  Haz clic en el botón "Guardar Bitácora".
4.  El texto se guardará en el almacenamiento interno y la aplicación se cerrará.
5.  Al volver a abrir la aplicación, se mostrará el contenido guardado.

### AgendaActivity (Contactos)

1.  Ingresa el nombre del contacto en el campo de texto etiquetado como "Nombre".
2.  Ingresa la información del contacto en el campo de texto etiquetado como "Información".
3.  Haz clic en el botón "Guardar Info" para guardar la información del contacto. Se mostrará un mensaje Toast "Contacto guardado".
4.  Para buscar información de un contacto, ingresa el nombre en el campo de texto "Nombre" y haz clic en el botón "Buscar Info".
5.  Si el contacto existe, se mostrará su información en el campo de texto "Información" y un mensaje Toast "Contacto encontrado". Si no existe, se mostrará un mensaje Toast "Contacto no encontrado".

### SdActivity (Notas)

1.  Ingresa el nombre de la nota en el campo de texto etiquetado como "Nombre de la Nota".
2.  Ingresa el contenido de la nota en el campo de texto etiquetado como "Notas".
3.  Haz clic en el botón "Guardar Nota" para guardar la nota en la tarjeta SD. Se mostrará un mensaje Toast "Nota guardada". Los campos se limpiaran una vez guardada la nota
4.  Para consultar una nota, ingresa el nombre de la nota en el campo de texto "Nombre de la Nota" y haz clic en el botón "Consultar Nota".
5.  Si la nota existe, se mostrará su contenido en el campo de texto "Notas". Si no existe, se mostrará un mensaje Toast "Error al consultar".

## Navegación

*   Desde `MainActivity`, se puede acceder a `AgendaActivity` y a `SdActivity`.
*   Desde `AgendaActivity`, se puede acceder a `MainActivity` y a `SdActivity`.
*   Desde `SdActivity`, se puede acceder a `MainActivity` y a `AgendaActivity`.

## Créditos

Este proyecto fue creado siguiendo el curso de La Geekipedia De Ernesto:

*   [Lista de reproducción del curso](https://www.youtube.com/playlist?list=PLyvsggKtwbLX06iMtXnRGX5lyjiiMaT2y)
*   [Canal](https://www.youtube.com/@LaGeekipediaDeErnesto)

## Contacto

Para cualquier consulta o comentario, puedes contactarme a través de [LinkedIn](https://www.linkedin.com/in/nkaminski-profile/) o [GitHub](https://github.com/N-Kaminski).

---

¡Gracias por revisar mi proyecto!