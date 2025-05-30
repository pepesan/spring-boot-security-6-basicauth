# Ejemplo de aplicaicón Spring Boot 3 con Security 6 y Basic Auth

## URL de login
http://localhost:8080/login

Datos de acceso usuario admin

Usuario: admin
Contraseña: admin

Datos de acceso usuario pepesan

Usuario: pepesan
Contraseña: password

## URL de dashboard
http://localhost:8080/?continue

(definido en el MainController)

## URLs públicas

(Sin estar logueado)

http://localhost:8080/public/show

## URLs protegidas

(Sólo para el rol ADMIN)

http://localhost:8080/admin

(Sólo para los roles ADMIN/USER)

http://localhost:8080/user/show

