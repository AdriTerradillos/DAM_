# Python 3 para 1.º de DAM: Guía didáctica y narrativa

## 1. Introducción
Yo estoy aprendiendo Python 3, un lenguaje interpretado, fácil de leer y muy flexible. Permite programación imperativa, funcional y más adelante orientada a objetos.

## 2. Instalación y primer programa
Antes de escribir código, debo instalar Python y un entorno de desarrollo (VS Code, PyCharm, IDLE, etc.).

**Primer programa:**
```python
# Mi primer programa en Python
print("¡Hola, mundo!")
```

**Ejercicio:**
Ahora voy a escribir un programa que muestre mi nombre y edad en pantalla.
```python
# Mostrar nombre y edad
print("Mi nombre es Juan y tengo 20 años")
```

## 3. Variables, tipos de datos y operadores
Yo entiendo que las variables son etiquetas que guardan datos. Python tiene varios tipos: números, cadenas, booleanos, listas, tuplas, diccionarios y conjuntos.

### 3.1 Números y operadores
```python
# Enteros y flotantes
edad = 20  # int
precio = 19.99  # float

# Operaciones
suma = edad + 5
producto = precio * 2
print(suma, producto)
```

**Ejercicio:**
Voy a calcular el área de un rectángulo con base y altura dadas.
```python
base = 5
altura = 3
area = base * altura
print("El área es:", area)
```

### 3.2 Cadenas de texto
```python
nombre = "Juan"
saludo = f"Hola, {nombre}!"
print(saludo)
```

**Ejercicio:**
Ahora voy a pedir al usuario que ingrese su nombre y mostrar un saludo personalizado.
```python
nombre = input("Ingresa tu nombre: ")
print(f"¡Hola, {nombre}!")
```

### 3.3 Booleanos
```python
es_mayor = edad >= 18
print(es_mayor)
```

**Ejercicio:**
Voy a verificar si un número es par o impar.
```python
numero = 7
es_par = numero % 2 == 0
print("Es par:", es_par)
```

### 3.4 Listas y tuplas
```python
# Lista mutable
frutas = ["manzana", "banana", "cereza"]
frutas.append("naranja")
print(frutas)

# Tupla inmutable
colores = ("rojo", "verde", "azul")
print(colores[0])
```

**Ejercicio:**
Voy a crear una lista de 5 números y calcular su suma.
```python
numeros = [1,2,3,4,5]
suma = sum(numeros)
print("La suma es:", suma)
```

### 3.5 Diccionarios y conjuntos
```python
# Diccionario
persona = {"nombre": "Juan", "edad": 20}
print(persona["nombre"])

# Conjunto
colores = {"rojo", "verde", "azul"}
colores.add("amarillo")
print(colores)
```

**Ejercicio:**
Voy a crear un diccionario con mis tres comidas favoritas y mostrar cada una.
```python
comidas = {"desayuno": "huevos", "almuerzo": "pizza", "cena": "sopa"}
for comida in comidas.values():
    print(comida)
```

## 4. Estructuras de control

### 4.1 Condicionales
```python
edad = 20
if edad >= 18:
    print("Soy mayor de edad")
else:
    print("Soy menor de edad")
```

**Ejercicio:**
Voy a escribir un programa que determine si un número ingresado es positivo, negativo o cero.
```python
numero = int(input("Ingresa un número: "))
if numero > 0:
    print("Positivo")
elif numero < 0:
    print("Negativo")
else:
    print("Cero")
```

### 4.2 Bucles
```python
# Bucle for
for i in range(5):
    print("Número:", i)

# Bucle while
contador = 0
while contador < 5:
    print("Contador:", contador)
    contador += 1
```

**Ejercicio:**
Voy a imprimir los números pares del 1 al 10.
```python
for i in range(1, 11):
    if i % 2 == 0:
        print(i)
```

## 5. Funciones
```python
def saludar(nombre):
    print(f"¡Hola, {nombre}!")

saludar("Juan")
```

**Ejercicio:**
Voy a crear una función que reciba dos números y devuelva su suma.
```python
def sumar(a, b):
    return a + b

resultado = sumar(3, 5)
print("La suma es:", resultado)
```

## 6. Ficheros
```python
# Escribir en un archivo
with open("ejemplo.txt", "w") as f:
    f.write("Hola, archivo\n")

# Leer de un archivo
with open("ejemplo.txt", "r") as f:
    contenido = f.read()
    print(contenido)
```

**Ejercicio:**
Ahora voy a crear un archivo que guarde los números del 1 al 5, uno por línea.
```python
with open("numeros.txt", "w") as f:
    for i in range(1, 6):
        f.write(f"{i}\n")
```

## 7. Excepciones
```python
try:
    numero = int(input("Ingresa un número: "))
    print(10 / numero)
except ValueError:
    print("No ingresaste un número válido")
except ZeroDivisionError:
    print("No se puede dividir entre cero")
```

**Ejercicio:**
Voy a pedir dos números al usuario y dividirlos, manejando posibles errores.
```python
try:
    a = int(input("Primer número: "))
    b = int(input("Segundo número: "))
    resultado = a / b
    print("Resultado:", resultado)
except ValueError:
    print("Debes ingresar números")
except ZeroDivisionError:
    print("No se puede dividir entre cero")
```

## 8. Módulos
```python
import math
print(math.sqrt(16))  # Raíz cuadrada

from math import factorial
print(factorial(5))
```

**Ejercicio:**
Voy a usar el módulo random para generar un número aleatorio entre 1 y 100.
```python
import random
numero = random.randint(1, 100)
print("Número aleatorio:", numero)
```

---

Con esta guía puedo practicar todos los fundamentos de Python directamente en mi IDE y ejecutar cada bloque de código paso a paso.

