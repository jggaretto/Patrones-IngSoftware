# Relevamiento y pendientes para la presentación

**Consigna:** martes 6 de octubre de 2026. **Rama:** `Patrones-Completos`.

## Estado inicial observado

El repo `jggaretto/Patrones-IngSoftware`, actualizado desde `main` en el commit `46effae`, tenía únicamente `pom.xml` y un `Main.java` que imprimía Hello world. No tenía implementaciones de patrones, UML ni análisis de problema, solución y consecuencias.

Se revisó además la copia local del trabajo creacional del equipo, commit `e3d6d4b`, y se comprobó que sus cinco ejemplos compilaban y funcionaban. Se reutilizaron sus temas y se separaron los participantes anidados en archivos propios. Observer y Strategy se retomaron de la copia local del TP anterior.

Durante el trabajo se incorporó el nuevo commit del equipo `a168ac6` (`Carpetas`). Contenía carpetas vacías y una copia de archivos compilados. Esta rama conserva ese commit en su historial y reemplaza los marcadores vacíos por las categorías `creational`, `structural` y `behavioral`, con sus 25 implementaciones. `target/` queda fuera del seguimiento porque Maven lo genera.

## Cobertura de esta rama

| Grupo | Patrones | Código y demo | UML Mermaid | Problema / solución / consecuencias |
| --- | ---: | --- | --- | --- |
| Creational | 7 | Completo | Completo | Completo |
| Structural | 7 | Completo | Completo | Completo |
| Behavioral | 11 | Completo | Completo | Completo |
| **Total** | **25** | **25** | **25** | **25** |

Cada demo conserva una comprobación ejecutable del comportamiento del patrón. `verificar.ps1` compila con compatibilidad Java 17 y `Main` ejecuta las 25 con `-ea`. Las instrucciones y los límites de cada simulación están en sus README.

**Validación realizada:** compilación con JDK 25.0.2 y `--release 17`, ejecución satisfactoria de las 25 demos con aserciones y renderizado de los 25 diagramas Mermaid. Se comprobó además la estructura de carpetas, una declaración pública por archivo y los enlaces locales de los README. Maven no está instalado en este entorno; la ejecución verificada usa `javac` y `java`.

## Pendientes de coordinación

- [ ] Identificar en el índice qué integrante expone cada patrón según el reparto existente; no se inventa un nuevo reparto.
- [ ] Cada integrante debe ensayar su demo y explicar las relaciones del UML usando los nombres reales de las clases.
- [ ] Revisar en GitHub que cada integrante pueda visualizar el Mermaid y acceder a la rama.
- [ ] Confirmar con el enunciado completo si también se exige PDF, diapositivas o alguna entrega fuera del repo; esos formatos no aparecen en la consigna compartida.
- [ ] Acordar con el equipo la integración de esta rama cuando el material esté revisado.

**Pendientes de los tres entregables solicitados:** ninguno tras ejecutar correctamente el verificador. La revisión oral y la coordinación del equipo siguen pendientes.
