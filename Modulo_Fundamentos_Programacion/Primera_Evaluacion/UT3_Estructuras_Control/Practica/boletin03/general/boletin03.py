
# *** EJERCICIOS PYTHON 3 ***
# Este boletín de ejercicios está orientado a practicar con todo lo visto hasta ahora


# 1. Escribir un programa en python que pida al

'''
1º- Pido al usuario un número entero.
2º- Recorro todos los números del 1 al número introducido.
3º- Compruebo cuáles son divisores (n % i == 0).
4º- Imprimimo los divisores uno debajo de otro.
'''

def ejercicio1():
    print('*** ejercicio 1 ***')

    numero = int(input('Introduce un número entero: '))
    print('Los divisores de', numero, 'son:')

    for i in range(1, numero + 1):
        if numero % i == 0:
            print(i)

    print()

# 2.  Idem, pero que ponga los divisores uno detrás de otro separados por comas

'''
1º- Pido al usuario un entero.
2º- Caculo los divisores igual que ejercicio 1.
3º- Guardo divisores en una lista
4º- Muestro los divisores separados por comas
'''

def ejercicio2():
    print('*** ejercicio 2 ***')

    numero = int(input('Introduce un número entero: '))
    divisores = []

    for i in range(1, numero + 1):
        if numero % i == 0:
            divisores.append(str(i))

    print('Los divisores de', numero, 'son:', ', '.join(divisores))
    print()

# Juego: adivinar un número entre 1 y 50 (máx. 3 intentos)

'''
1º- Genero un número aleatorio entre 1 y 50
2º- Permitiré hasta 3 intentos al usuario
3º- Indico si el número introducido es mayor o menor
4º- Terminará el juego si acierta o se acaban los intentos
'''

import random

def ejercicio3():
    print('*** ejercicio 3 ***')

    numero_secreto = random.randint(1, 50)
    intentos_max = 3

    for intento in range(1, intentos_max + 1):
        numero = int(input(f'Intento {intento} de {intentos_max}: Introduce un número entre 1 y 50: '))

        if numero == numero_secreto:
            print('¡Correcto! Has acertado el número.')
            break
        elif numero < numero_secreto:
            print('El número secreto es mayor.')
        else:
            print('El número secreto es menor.')
    else:
        print('Has agotado los intentos. El número secreto era', numero_secreto)

    print()

# Modificar el juego anterior para permitir intentos ilimitados

'''
1º- Genero un número aleatorio entre 1 y 50
2º- Repito indefinidamente hasta acertar
3º- Cuento los intentos fallidos
4º- Muestro cuantos fallos se hicieron antes de acertar
'''

def ejercicio4():
    print('*** ejercicio 4 ***')

    numero_secreto = random.randint(1, 50)
    fallos = 0

    while True:
        numero = int(input('Introduce un número entre 1 y 50: '))
        if numero == numero_secreto:
            print('¡Correcto! Has acertado el número.')
            print('Has fallado', fallos, 'veces antes de lograrlo.')
            break
        elif numero < numero_secreto:
            print('El número secreto es mayor.')
        else:
            print('El número secreto es menor.')
        fallos += 1

    print()

