MODULO DE PROFESORES - UniversidadUT
Realizado / personalizado por: Gael Lora

Cambios realizados:
1. Se completo la clase Profesor con validaciones y formato.
2. Se agrego ProfesorDAO para registrar profesores en MySQL usando transacciones.
3. Se integro el modulo al Menu de consola.
4. Se agrego el script SQL en src/main/resources/sql/universidadut_profesores.sql.
5. Se personalizo el modulo con pequeños ajustes de codigo y encabezado de autor.

Antes de ejecutar:
1. Verifica usuario y password en src/main/java/org/example/config/Conexion.java.
2. Ejecuta el script SQL universidadut_profesores.sql en MySQL Workbench.
3. Ejecuta Main.java desde IntelliJ o con Maven.

Prueba sugerida:
Opcion 4 - Registrar profesor
Numero de empleado: 1001
Nombre: Juan Perez
CURP: PERJ010203HQTABC09
Puesto: Docente de Programacion
Sueldo: 12500.756

Resultado esperado:
Conexion Realizada Correctamente
Profesor registrado correctamente

Consulta MySQL:
SELECT * FROM profesores;
