# Cliente - Gestionador de Clientes y Vehículos

## Descripción

El cliente es una aplicación que consume el microservicio del servidor y se encarga de interactuar con una base de datos MySQL a través de los endpoints expuestos por el servidor. Este cliente expone su propio conjunto de endpoints relacionados con la gestión de clientes y vehículos.

## Configuración

Asegúrese de que el microservicio del servidor esté en ejecución y correctamente configurado antes de iniciar el cliente. A continuación se presentan los detalles de los endpoints expuestos por el cliente.

## Endpoints de Cliente

**Base URL:** `/owners`

- **Listar todos los clientes:** 
  - Método: `GET`
  - Endpoint: `/list`
  
- **Buscar cliente por ID:** 
  - Método: `GET`
  - Endpoint: `/search/{id}`

- **Buscar cliente por apellido:** 
  - Método: `GET`
  - Endpoint: `/search/detail/{apellido}`

- **Buscar vehículos asociados a un cliente:** 
  - Método: `GET`
  - Endpoint: `/search/vehiclesByOwner/{id}`

- **Actualizar información de cliente:** 
  - Método: `PUT`
  - Endpoint: `/update/{id}/{nombre}/{apellido}`

- **Eliminar cliente:** 
  - Método: `DELETE`
  - Endpoint: `/delete/{id}`

- **Crear nuevo cliente:** 
  - Método: `POST`
  - Endpoint: `/create/{nombre}/{apellido}`

## Endpoints de Vehículo

**Base URL:** `/vehicles`

- **Listar todos los vehículos:** 
  - Método: `GET`
  - Endpoint: `/list`
  
- **Buscar vehículo por ID:** 
  - Método: `GET`
  - Endpoint: `/search/{id}`

- **Buscar vehículo por matrícula:** 
  - Método: `GET`
  - Endpoint: `/search/detail/{matricula}`

- **Buscar vehículos por nombre de fabricante:** 
  - Método: `GET`
  - Endpoint: `/search/detail/fabricante/{fabricante}`

- **Buscar propietario de vehículo por ID del vehículo:** 
  - Método: `GET`
  - Endpoint: `/search/owner/{id}`

- **Eliminar vehículo:** 
  - Método: `DELETE`
  - Endpoint: `/delete/{id}`

- **Actualizar matrícula de vehículo:** 
  - Método: `PUT`
  - Endpoint: `/update/{id}/{matricula}`

- **Crear nuevo vehículo:** 
  - Método: `POST`
  - Endpoint: `/create/{matricula}/{fabricante}/{modelo}/{idCliente}`

## Consideraciones

- Asegúrese de que los datos proporcionados al crear o actualizar registros sean válidos.
- Para evitar conflictos, no cree registros duplicados.
- Antes de eliminar un cliente o vehículo, asegúrese de que no existan dependencias relacionadas, como un vehículo asociado a un cliente.
