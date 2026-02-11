# TecnoStore – Sistema de Gestión de Ventas en Java (Consola)

##  Descripción del Proyecto

**TecnoStore** es una tienda minorista dedicada a la venta de teléfonos celulares de distintas marcas y gamas. Actualmente, la empresa gestiona sus ventas, inventario y clientes de manera manual mediante hojas de cálculo, lo que genera errores, duplicidad de información y dificultad para obtener reportes.

Este proyecto tiene como objetivo desarrollar un **sistema de consola en Java** que permita automatizar estos procesos, aplicando buenas prácticas de **Programación Orientada a Objetos (POO)**, uso de **colecciones**, **manejo de excepciones**, **persistencia de datos con JDBC**, **Stream API** y **patrones de diseño**, siguiendo los principios **SOLID**.

---

##  Objetivos del Sistema

### Gestión de Celulares
- Registrar, actualizar, eliminar y listar celulares.
- Cada celular debe tener:
  - ID
  - Marca
  - Modelo
  - Precio
  - Stock
  - Sistema operativo
  - Gama (Alta, Media, Baja)
- Validaciones:
  - El precio y el stock deben ser valores positivos.

###  Gestión de Clientes
- Registrar clientes con:
  - ID
  - Nombre
  - Identificación
  - Correo electrónico
  - Teléfono
- Validaciones:
  - Formato correcto de correo electrónico.
  - Identificación única por cliente.

### Gestión de Ventas
- Registrar una venta seleccionando un cliente y uno o más celulares.
- Calcular el total de la venta incluyendo **IVA del 19%**.
- Actualizar el stock del celular vendido.
- Guardar la venta en la base de datos utilizando **JDBC**.

### Reportes y Análisis
Mostrar en consola:
- Celulares con stock bajo (menor a 5 unidades).
- Top 3 de celulares más vendidos.
- Total de ventas agrupadas por mes.

---

## Persistencia y Archivos
- Generación del archivo **`reporte_ventas.txt`** con el resumen de todas las ventas realizadas.
- Manejo de excepciones utilizando **try-with-resources**.
  
---

## Patrones de Diseño 
- Se usa el patron de diseño factory para el regitro de celulares
---

## 🗂️ Estructura del Proyecto

### 📁 BaseDeDatos
Contiene la configuración de conexión y el script SQL.

- `Conexion.java`: Maneja la conexión JDBC con MySQL.
- `tecnostore_db.sql`: Script para la creación de la base de datos y tablas.

---

### 📁 Controlador
Gestiona la lógica de interacción entre vista y modelo.

- `ControladorCelular`: Lógica de gestión de celulares.
- `ControladorCliente`: Lógica de gestión de clientes.
- `ControladorVenta`: Lógica de gestión de ventas.
- `ControladorMenu`: Control general de navegación.
- `ControladorMenuPrincipal`: Controlador del menú principal.
- `ControladorMenuCelular`: Controlador del menú de celulares.
- `ControladorMenuCliente`: Controlador del menú de clientes.
- `ControladorMenuVenta`: Controlador del menú de ventas.
- `ControladorReporteVenta`: Controlador de generación de reportes.

---

### 📁 Modelo
Representa las entidades del negocio.


- `Celular`: Clase base que representa un celular.
- `CelularGamaAlta`, `CelularGamaMedia`, `CelularGamaBaja`: Implementan los distintos tipos de celulares según su gama.
- `CategoriaGama`: Enumeración de gamas de celulares.
- `Cliente`: Representa un cliente del sistema.
- `Venta`: Representa una venta.
- `DetalleVenta`: Detalle de los productos incluidos en una venta.
- `Factura`: Genera la información final de la venta.
- `FactoryCelular`: Implementa el patrón **Factory** para la creación de celulares.
- `ReporteCelularBajoStock`: Genera reportes de stock bajo.
- `ReporteCelularesMasVendidos`: Genera reportes de celulares más vendidos.
- `ReporteVentasTotalesPorMes`: Genera reportes de ventas agrupadas por mes.

---

### 📁 Persistencia
Acceso a datos usando.

- `CelularDAO`: Operaciones CRUD para celulares.
- `ClienteDAO`: Operaciones CRUD para clientes.
- `VentaDAO`: Registro de ventas.
- `DetalleVentaDAO`: Manejo del detalle de ventas.
- `FacturaDAO`: Persistencia de facturas.
- `ReporteVentasDAO`: Consultas para reportes.

---

### 📁 Utilidades
Clases de apoyo para entrada de datos y validaciones.

- `EntradaUsuario`: Lectura de datos desde consola.
- `ValidacionEntrada`: Validaciones de datos ingresados.
- `Mensaje`: Manejo de mensajes en consola.

---

### 📁 Vista
Interfaz de usuario por consola.

- `Menu`: Clase base para los menús.
- `MenuPrincipal`: Menú principal del sistema.
- `MenuCelular`: Menú de gestión de celulares.
- `MenuCliente`: Menú de gestión de clientes.
- `MenuVenta`: Menú de gestión de ventas.
- `MenuReportes`: Menú de reportes.

---

### 📦 Paquete Principal
- `Main.java`  
  Punto de entrada para iniciar la aplicaion.

---

## 🛢️ Base de Datos MySQL

**Nombre:** `tecnostore_db`

### 📋 Tablas

#### celulares
- id
- marca
- modelo
- sistema_operativo
- gama
- precio
- stock

#### clientes
- id
- nombre
- identificacion
- correo
- telefono

#### ventas
- id
- id_cliente
- fecha
- total

#### detalle_ventas
- id
- id_venta
- id_celular
- cantidad
- subtotal

---

## Tecnologías Utilizadas
- Java
- JDBC
- MySQL
---

##  Ejemplo de ejecucion
<img width="1026" height="446" alt="imagen" src="https://github.com/user-attachments/assets/2f6c2720-2892-40c5-a864-5a653cc0003f" />
Al iniciar la aplicación, el sistema muestra el **menú principal** en consola, desde el cual el usuario puede acceder a las diferentes funcionalidades del sistema:

- Gestionar Celulares  
- Gestionar Clientes  
- Gestionar Ventas  
- Ver Reportes  
- Salir  

En este ejemplo, el usuario selecciona la opción **4 – Ver Reportes**, ingresando el valor correspondiente cuando el sistema solicita la acción a realizar.

---

###  Reportes Generados

#### Celulares con stock bajo
El sistema analiza el inventario de celulares y verifica si existen productos con un stock menor a **5 unidades**.  
En este caso, el sistema indica que **no existen celulares con menos de 5 unidades en stock**.

---

#### Top 3 de celulares más vendidos
El sistema genera un ranking con los **tres celulares más vendidos**, mostrando para cada uno:

- Marca  
- Modelo  
- Sistema operativo  
- Gama  
- Cantidad de ventas  

Resultados obtenidos:
- **Xiaomi – Redmi Note 12**, gama media, con **2 ventas**.
- **Samsung – Galaxy S23**, gama alta, con **1 venta**.
- **Nokia – C21**, gama baja, con **1 venta**.



---

####  Total de ventas por mes
Finalmente, el sistema muestra el total de ventas agrupadas por **mes y año**.  
En el ejemplo, se registran **3 ventas totales durante febrero de 2026**.

---

---

## Indicaciones para la Conexión a MySQL

La aplicacion utiliza una base de datos **MySQL** para almacenar la información de celulares, clientes, ventas y reportes.  
La conexión se gestiona mediante la clase `Conexion`, ubicada en el paquete **BaseDeDatos**, haciendo uso de **JDBC**.

---

### Clase `Conexion`

La clase `Conexion` es responsable de establecer la comunicación entre la aplicación Java y la base de datos MySQL.

#### Función principal
- Crear y retornar un objeto `Connection` activo.
- Centralizar la configuración de la conexión a la base de datos.
- Manejar excepciones en caso de errores de conexión.

---

### Configuración de la Conexión

La conexión se realiza utilizando el método `getConnection` de la clase `DriverManager`, especificando:

- **URL de conexión:**  
  `jdbc:mysql://localhost:3306/tecnostore_db`

- **Usuario:**  
  `root`

- **Contraseña:**  
  Definida por el usuario según su configuración local de MySQL.

Ejemplo de código utilizado:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/tecnostore_db",
    "root",
    "****"
);



