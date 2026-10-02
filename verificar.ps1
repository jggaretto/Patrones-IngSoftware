# Compila con compatibilidad Java 17 y ejecuta las 25 demos con aserciones.
$ErrorActionPreference = 'Stop'
Push-Location $PSScriptRoot
try {
    New-Item -ItemType Directory -Path 'out' -Force | Out-Null
    $fuentes = Get-ChildItem -Recurse -Filter '*.java' -File 'src/main/java'
    # El archivo de argumentos evita el límite de longitud de comandos de Windows.
    $rutas = @($fuentes | ForEach-Object { '"' + $_.FullName.Replace([char]92, [char]47) + '"' })
    $lista = Join-Path (Get-Location) 'out/fuentes.txt'
    [System.IO.File]::WriteAllLines($lista, $rutas, [System.Text.UTF8Encoding]::new($false))
    & javac --release 17 -encoding UTF-8 -Xlint:all -d out '@out/fuentes.txt'
    if ($LASTEXITCODE -ne 0) { throw "Fallo de compilación (código $LASTEXITCODE)" }
    & java -ea -cp out com.patronesingsoft.Main
    if ($LASTEXITCODE -ne 0) { throw "Fallo en las comprobaciones (código $LASTEXITCODE)" }
} finally {
    Pop-Location
}
