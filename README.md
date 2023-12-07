# Modelo de Base de Datos para Plazoleta de Comidas

Este es un modelo de base de datos diseñado para una pequeña aplicación de una plazoleta de comidas. El modelo incluye cuatro tablas principales: "Restaurante", "Cliente", "Pedido" y "Producto".

## Tablas y Relaciones

### 1. Restaurante

- **Atributos:**
    - id (Clave primaria)
    - Nombre
    - Tipo_Cocina
    - Ubicacion

### 2. Cliente

- **Atributos:**
    - id (Clave primaria)
    - Nombre
    - documento
    - email
    - direccion
    - direccion
    - fecha_fegistro

### 3. Pedido

- **Atributos:**
    - id (Clave primaria)
    - Fecha
    - Total
    - estado
    - ID_Cliente (Clave foránea)
    - ID_Restaurante (Clave foránea)

- **Relaciones:**
    - Relación con la tabla "Cliente" a través de ID_Cliente.
    - Relación con la tabla "Restaurante" a través de ID_Restaurante.

### 4. Producto

- **Atributos:**
    - id (Clave primaria)
    - Nombre
    - Precio
    - Descripcion
    - ID_Restaurante (Clave foránea)

- **Relaciones:**
    - Puede haber una relación adicional con la tabla "Restaurante" para rastrear qué restaurante ofrece qué productos.


### EntPoints
- **health**
  - http://localhost:8080/actuator/health



- **Clientes**
  - http://localhost:8080/clientes/v1/getClientes
  - http://localhost:8080/clientes/v1/save
  - http://localhost:8080/clientes/v1/delete
  - http://localhost:8080/clientes/v1/cliente/10
  - http://localhost:8080/clientes/v1/delete/10


- **Restaurantes**
  - http://localhost:8080/restaurante/v1/getRestaurantes
  - http://localhost:8080/restaurante/v1/getRestaurante/10


- **Producto**
  - http://localhost:8080/productos/v1/getProductos
  - http://localhost:8080/productos/v1/getProducto/10


- **Pedidos**
  - http://localhost:8080/pedidos/v1/getPedidos
  - http://localhost:8080/pedidos/v1/getPedido/10