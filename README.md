# Patrones de diseño — Ingeniería de Software

Material común del equipo para la presentación del **martes 6 de octubre de 2026**. Contiene los **25 patrones de la consigna**: 7 creacionales, 7 estructurales y 11 conductuales.

Cada patrón incluye código Java 17 ejecutable, comentarios para exposición, un diagrama de clases UML en Mermaid y el análisis **problema — solución — consecuencias**. Los ejemplos son de consola y funcionan sin servicios externos ni bibliotecas adicionales.

## Organización

Se mantiene la estructura Maven y el paquete base del repo del equipo:

```text
src/main/java/com/patronesingsoft/
├── Main.java                    # Ejecuta y comprueba las 25 demos
├── creational/                  # 7 patrones
│   ├── AbstractFactory/
│   ├── Builder/
│   ├── DependencyInjection/
│   ├── FactoryMethod/
│   ├── ObjectPool/
│   ├── Prototype/
│   └── Singleton/
├── structural/                  # 7 patrones
│   ├── Adapter/
│   ├── Bridge/
│   ├── Composite/
│   ├── Decorator/
│   ├── Facade/
│   ├── Flyweight/
│   └── Proxy/
└── behavioral/                  # 11 patrones
    ├── ChainOfResponsibility/
    ├── Command/
    ├── Interpreter/
    ├── Iterator/
    ├── Mediator/
    ├── Memento/
    ├── Observer/
    ├── State/
    ├── Strategy/
    ├── TemplateMethod/
    └── Visitor/
```

Dentro de cada carpeta: **una clase o interfaz por archivo**, `Demo.java` y `README.md`. Cada README explica los roles, muestra el UML, indica cómo ejecutar y ofrece un guion breve. Los nombres de carpetas conservan la forma del equipo, sin espacios para que también sean paquetes Java válidos.

## Compilar y comprobar todo

Requiere **JDK 17 o superior**, con `java` y `javac` en el PATH. El proyecto usa APIs de Java 17 aunque se compile con un JDK más nuevo.

Desde la raíz, en PowerShell:

```powershell
./verificar.ps1
```

Si Windows bloquea la ejecución de scripts, habilitarla únicamente para este proceso:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File ./verificar.ps1
```

El script compila todos los archivos, activa las aserciones y ejecuta las 25 demos. Un fallo detiene la comprobación. La última línea esperada es:

```text
OK: los 25 patrones funcionan correctamente.
```

En Linux/macOS, desde la raíz:

```sh
mkdir -p out
find src/main/java -name '*.java' > out/fuentes.txt
javac --release 17 -encoding UTF-8 -Xlint:all -d out @out/fuentes.txt
java -ea -cp out com.patronesingsoft.Main
```

También se puede compilar con `mvn compile` y ejecutar `java -ea -cp target/classes com.patronesingsoft.Main`. Maven es opcional. `mvn test` no reemplaza la ejecución del verificador: las comprobaciones están dentro de las demos.

## Ejecutar un patrón

Después de compilar, por ejemplo:

```powershell
java -ea -cp out com.patronesingsoft.creational.Builder.Demo
java -ea -cp out com.patronesingsoft.structural.Adapter.Demo
java -ea -cp out com.patronesingsoft.behavioral.Observer.Demo
```

En el IDE: importar el `pom.xml`, seleccionar JDK 17 o superior, abrir la `Demo.java` del patrón y ejecutar con la opción de VM `-ea`. El `Main` general exige aserciones activas para evitar informar éxito sin comprobar.

## Índice del material

Cada enlace abre el código y la explicación del patrón correspondiente. GitHub renderiza los bloques Mermaid en el README de cada carpeta.

| Patrón | Tipo | Ejemplo |
| --- | --- | --- |
| [Abstract Factory](src/main/java/com/patronesingsoft/creational/AbstractFactory/README.md) | Creacionales | Controles Windows y macOS |
| [Builder](src/main/java/com/patronesingsoft/creational/Builder/README.md) | Creacionales | Armado de computadoras |
| [Dependency Injection](src/main/java/com/patronesingsoft/creational/DependencyInjection/README.md) | Creacionales | Confirmaciones de inscripción |
| [Factory Method](src/main/java/com/patronesingsoft/creational/FactoryMethod/README.md) | Creacionales | Logística terrestre y marítima |
| [Object Pool](src/main/java/com/patronesingsoft/creational/ObjectPool/README.md) | Creacionales | Préstamo de conexiones simuladas |
| [Prototype](src/main/java/com/patronesingsoft/creational/Prototype/README.md) | Creacionales | Copia de documentos con etiquetas |
| [Singleton](src/main/java/com/patronesingsoft/creational/Singleton/README.md) | Creacionales | Configuración del campus virtual |
| [Adapter](src/main/java/com/patronesingsoft/structural/Adapter/README.md) | Estructurales | Sensor Fahrenheit consumido en Celsius |
| [Bridge](src/main/java/com/patronesingsoft/structural/Bridge/README.md) | Estructurales | Controles remotos y dispositivos |
| [Composite](src/main/java/com/patronesingsoft/structural/Composite/README.md) | Estructurales | Tamaño de archivos y carpetas |
| [Decorator](src/main/java/com/patronesingsoft/structural/Decorator/README.md) | Estructurales | Correo con SMS y registro |
| [Facade](src/main/java/com/patronesingsoft/structural/Facade/README.md) | Estructurales | Compra con inventario, pago y envío |
| [Flyweight](src/main/java/com/patronesingsoft/structural/Flyweight/README.md) | Estructurales | Árboles que comparten su especie |
| [Proxy](src/main/java/com/patronesingsoft/structural/Proxy/README.md) | Estructurales | Carga diferida de una imagen |
| [Chain of Responsibility](src/main/java/com/patronesingsoft/behavioral/ChainOfResponsibility/README.md) | Conductuales | Escalamiento de solicitudes de soporte |
| [Command](src/main/java/com/patronesingsoft/behavioral/Command/README.md) | Conductuales | Encendido de una luz con deshacer |
| [Interpreter](src/main/java/com/patronesingsoft/behavioral/Interpreter/README.md) | Conductuales | Expresiones con números, variables y sumas |
| [Iterator](src/main/java/com/patronesingsoft/behavioral/Iterator/README.md) | Conductuales | Recorrido de una colección de libros |
| [Mediator](src/main/java/com/patronesingsoft/behavioral/Mediator/README.md) | Conductuales | Sala de chat del equipo |
| [Memento](src/main/java/com/patronesingsoft/behavioral/Memento/README.md) | Conductuales | Restauración de versiones de un editor |
| [Observer](src/main/java/com/patronesingsoft/behavioral/Observer/README.md) | Conductuales | Avisos de un curso a sus alumnos |
| [State](src/main/java/com/patronesingsoft/behavioral/State/README.md) | Conductuales | Pedido nuevo, pagado y enviado |
| [Strategy](src/main/java/com/patronesingsoft/behavioral/Strategy/README.md) | Conductuales | Cotización de envío estándar o express |
| [Template Method](src/main/java/com/patronesingsoft/behavioral/TemplateMethod/README.md) | Conductuales | Informes de texto y HTML |
| [Visitor](src/main/java/com/patronesingsoft/behavioral/Visitor/README.md) | Conductuales | Descripción y etiquetas de documentos e imágenes |

## Cómo preparar la exposición

**Muestra visual de Observer:** [diapositivas, diagramas y recorrido paso a paso](presentaciones/observer/README.md). Disponible como PowerPoint editable y presentación HTML que funciona sin conexión.

Usar el mismo orden en cada patrón: **problema → UML y participantes → solución en código → demo → consecuencias**. Los comentarios identifican el rol de cada archivo y las líneas donde se aplica el patrón. Las aserciones sirven como evidencia del comportamiento; no son parte esencial del patrón.

El material es una base común para el reparto ya acordado entre integrantes. El [relevamiento y pendientes](PENDIENTES.md) distingue el estado inicial del repo y lo que falta coordinar para la presentación.

## Continuidad con los trabajos del equipo

Abstract Factory, Builder, Factory Method, Prototype y Singleton conservan los ejemplos del repo [Patrones-Creacionales-IngSoft](https://github.com/jggaretto/Patrones-Creacionales-IngSoft), reorganizados en esta estructura. Observer y Strategy retoman los ejemplos de la copia local del [TP anterior](https://github.com/Niquinhoo/tp1-patrones-diseno). Las clases antes agrupadas dentro de demos ahora tienen archivos propios.

## Referencias

El [catálogo de Refactoring.Guru](https://refactoring.guru/es/design-patterns/catalog) contiene 22 de los patrones pedidos. La consigna también exige **Dependency Injection, Object Pool e Interpreter**, por lo que se incluyen aunque no figuren en ese catálogo.

- [Martin Fowler: Dependency Injection](https://martinfowler.com/articles/injection.html).
- [Apache Commons Pool: reutilización de objetos](https://commons.apache.org/proper/commons-pool/).
- [Gamma, Helm, Johnson y Vlissides: Interpreter, material alojado en MIT](https://people.csail.mit.edu/addy/pattern/pat5c.htm).

Los diagramas describen este código y las explicaciones son propias. Los límites de cada simulación están documentados en su carpeta.
