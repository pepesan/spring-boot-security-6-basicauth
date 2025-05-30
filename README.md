# Ejemplo de aplicación Spring Boot 3 con Security 6 y JWT

## URL de login (pública)
POST http://localhost:8080/api/auth/login

Datos de acceso usuario admin

Usuario: admin
Contraseña: admin
```json
{
"usernameOrEmail": "admin",
"password": "admin"
}
```


Datos de acceso usuario pepesan

Usuario: pepesan
Contraseña: password
```json
{
"usernameOrEmail": "pepesan",
"password": "password"
}
```

Ambas devolverán el token

Deberá meterse como Bearer token en la cabecera de Authorization como:

Bearer TOKEN_GENERADO

## URLs públicas

(Sin estar logueado)

GET http://localhost:8080/public/show

## URLs protegidas

(Sólo para el rol ADMIN)

GET http://localhost:8080/admin

GET http://localhost:8080/private/dashboard

(Sólo para los roles ADMIN/USER)

GET http://localhost:8080/user/show

