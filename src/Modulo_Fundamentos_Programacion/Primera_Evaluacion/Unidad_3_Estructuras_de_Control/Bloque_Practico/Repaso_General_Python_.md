# 🐍 RESUMEN DE PYTHON PARA 1º DAM

---

## 🔹 VARIABLES

En Python, una **variable** es un espacio donde guardo información (números, textos, etc.).  
No necesito declarar el tipo, Python lo detecta automáticamente.

```python
# Ejemplo de variables
nombre = "Juan"
edad = 18
nota = 7.5
print(nombre, edad, nota)
```

📘 **Pautas importantes:**
- No pueden comenzar con números.  
- Sensibles a mayúsculas (`Edad` ≠ `edad`).  
- Puedo cambiar su valor en cualquier momento.

---

## 🔹 CONDICIONALES

Me permiten **tomar decisiones** según una condición (`if`, `elif`, `else`).

```python
# Ejemplo condicional
edad = 20

if edad >= 18:
    print("Soy mayor de edad")
elif edad == 17:
    print("Casi mayor de edad")
else:
    print("Soy menor de edad")
```

📘 **Pautas importantes:**
- Uso `==` para comparar, **no** `=`.
- Los dos puntos `:` indican que empieza un bloque.
- La **indentación** (tabulación) es obligatoria.

---

## 🔹 MÉTODOS Y FUNCIONES MÁS UTILIZADAS

Una **función** es un bloque de código que puedo **reutilizar**.  
Se define con `def`.

```python
# Ejemplo de función
def saludar(nombre):
    print("Hola", nombre)

saludar("María")
```

📘 **Pautas importantes:**
- Si quiero que devuelva algo, uso `return`.
- Puedo pasarle parámetros o dejarla vacía.

```python
def suma(a, b):
    return a + b

resultado = suma(5, 3)
print(resultado)
```

---

## 🔹 STRINGS (Cadenas de texto)

Un **String** es texto. Puedo usar `'` o `"` indistintamente.

```python
mensaje = "Hola Mundo"
print(len(mensaje))           # longitud
print(mensaje.upper())        # mayúsculas
print(mensaje.lower())        # minúsculas
print(mensaje.replace("Hola", "Adiós"))  # reemplazar texto
```

📘 **Pautas importantes:**
- Los Strings son **inmutables** (no puedo modificarlos directamente).
- Puedo concatenar (`+`) o repetir (`*`) cadenas:
  ```python
  saludo = "Hola " + "Python"
  print(saludo)
  ```

---

## 🔹 SCANNER (Entrada de datos)

Uso `input()` para **pedir datos al usuario**.  
Siempre devuelve texto, por eso a veces tengo que **convertirlo**.

```python
nombre = input("¿Cómo te llamas? ")
edad = int(input("¿Cuántos años tienes? "))  # conversión a entero
print("Te llamas", nombre, "y tienes", edad, "años")
```

---

## 🔹 CONVERSIONES

Sirven para cambiar el tipo de dato de una variable.

```python
# Ejemplo de conversiones
x = "123"
num = int(x)        # de texto a entero
texto = str(45.6)   # de número a texto
decimal = float(10) # de entero a decimal
```

📘 **Tipos más comunes:**
- `int()` → entero  
- `float()` → decimal  
- `str()` → texto  
- `bool()` → booleano (True o False)

---

## 🔹 NÚMEROS ALEATORIOS

Para generar números al azar uso el módulo `random`.

```python
import random

numero = random.randint(1, 10)  # número entero entre 1 y 10
print("Número aleatorio:", numero)

decimal = random.uniform(1.0, 5.0)  # número decimal aleatorio
print("Decimal aleatorio:", decimal)
```

📘 **Otros ejemplos útiles:**
```python
lista = [10, 20, 30, 40]
print(random.choice(lista))  # elige un elemento aleatorio
```

---

## 🔹 BUCLES

### 🔸 Bucle **for**
Lo uso cuando sé **cuántas veces** quiero repetir algo.

```python
for i in range(5):
    print("Vuelta número", i)
```

📘 `range(5)` genera los números del 0 al 4.

### 🔸 Bucle **while**
Lo uso cuando quiero **repetir mientras se cumpla una condición**.

```python
contador = 0
while contador < 5:
    print("Contador:", contador)
    contador += 1  # incremento
```

📘 **Evita bucles infinitos:** asegúrate de que la condición cambie dentro del bucle.

---

# 🚀 CONCLUSIÓN

He aprendido que:
- Las **variables** guardan información.  
- Las **condicionales** toman decisiones.  
- Los **bucles** repiten acciones.  
- Las **funciones** organizan el código.  
- Y con **Strings**, **conversiones** y **random**, puedo hacer programas interactivos y divertidos.  

---

# 💡 Mini proyecto: Adivina el número

```python
import random

numero_secreto = random.randint(1, 10)
intento = 0

while True:
    intento = int(input("Adivina el número (1-10): "))
    if intento == numero_secreto:
        print("🎉 ¡Acertaste!")
        break
    else:
        print("❌ Intenta de nuevo")
```
