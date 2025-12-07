# Aplicación Android

Esta aplicación Android permite a los usuarios registrarse, iniciar sesión y visualizar un conjunto de tarjetas mediante un **ViewPager**. Está desarrollada con **Java** y utiliza **Fragments**, **ViewBinding** y **SharedPreferences**.
---

## Uso

1. Al abrir la app, se mostrará la **Splash Screen**.
2. El usuario será redirigido a la pantalla de **Login**.
   - Si no hay cuentas registradas, le puedes dar clic a **¿Aún no te has registrado todavía?**.
3. En **Register**:
   - Introduce nombre, apellido, correo y contraseña.
   - Confirma la contraseña y pulsa "Registrar".
   - Los datos se guardarán automáticamente en `SharedPreferences`.
4. En **Login**:
   - Introduce el nombre de usuario y contraseña.
   - Si los datos coinciden con los registrados, se abre `MainActivity`.
5. En **MainActivity**:
   - Se muestran las tarjetas usando un **ViewPager** con dos fragments (`tarjetas1` y `tarjetas2`).

---
