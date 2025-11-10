
#   *** EJERCICIOS PYTHON 2 ***

# Este boletín de ejercicios está orientado a practicar fundamentalmente con variables enteras y
# float, operadores aritméticos sencillos, dos sentencias de control (if, for y while), la entrada de
# datos por teclado y la generación de números aleatorios.




# 1. Escribir un programa en python que nos pida tres números en cualquier orden y nos los
# muestre en pantalla ordenados de menor a mayor

'''
1º- Pido tres números al usuario
2º- Los guardo en una lista con append(n)
3º- Ordeno la lista con sort()
4º- imprimo mensaje por pantalla
'''

print('*** ejercicio 1 ***')

numeros = []

for i in range(3):
    n = float(input(f'Introduce el primer número {i + 1}: '))
    numeros.append(n)

numeros.sort()

print('Números ordenados de mayor a menor: ', numeros)
print()


# 2. Idem al anterior pero pidiéndonos apellidos de personas

'''
1º- Pido tres apellidos al usuario (genero antes nuevo array apellidos [])
2º- Los guardo en una lista con append()
3º- Ordeno la lista alfabéticamente con sort()
4º- imprimo el mensaje por pantalla
'''

print('*** ejercicio 2 ***')

apellidos = []

for i in range(3):
    apellidos = (input(f'Introduce el apellido {i + 1}: '))

    apellidos = apellido : apellidos

apellidos.sort()


print('Apellidos ordenados alfabéticamente: ' , apellidos)

print('\nFin del ejercicio')


# 3. Escribir un programa en python que nos pida las notas de los dos trimestres y nos
# muestre la media aritmética resultante

'''
1º- Pido las dos notas
2º- Calculo la media (suma / 2)
3º- imprimo el resultado por pantalla (formateado f'')
'''

print('*** ejercicio 3 ***')

nota1 = float(input('Introduce la nota del primer trimestre: '))
nota2 = float(input('Introduce la nota del segundo trimestre: '))

media = (nota1 + nota2) / 2

print(f'La media aritmética es: {media:.2f}')

print('\nFin del ejercicio')
print()


# 4. Escribir un programa en python que nos pida las notas obtenidas en un trimestre y nos
# muestre la media ponderada sabiendo que;

    # ◦ La primera nota corresponde al trabajo en clase y cuenta como un 10% del total
    # ◦ La segunda corresponde a los ejercicios prácticos: 20%
    # ◦ La tercera la nota del examen: 70%

'''
1º- Pido las tres notas
2º- Calculo la media ponderada aplicando los porcentajes
3º- imprimo el resultado por pantalla
'''

print('*** ejercicio 4 ***')

nota1 = float(input('Introduce la nota del trabajo en clase (10%): '))
nota2 = float(input('Introduce la nota de ejercicios prácticos (20%): '))
nota3 = float(input('Introduce la nota del examen (70%): '))

media_ponderada = (nota1 * 0.1) + (nota2 * 0.2) + (nota3 * 0.7)

print(f'La nota media ponderada es: {media_ponderada:2.f}')

print('\nFin del ejercicio')
print()



# 5. Modifica el ejercicio anterior para que cuando la media salga como aprobado pero el
# alumno tenga menos de un 4,5 en cualquiera de los apartados la nota resultante será
# un 4

'''
1º- Pido de nuevo las tres notas
2º- Calculo la media ponderada
3º- Compruebo si hay alguna nota menor que 4.5
4º- Si la media >= 5 pero hay alguna nota < 4.5, la nota final será 4
'''

print('*** ejercicio 5 ***')

nota1 = float(input('Introduce la nota del trabajo en clase (10%): '))
nota2 = float(input('Introduce la nota de ejercicios prácticos (20%): '))
nota3 = float(input('Introduce la nota del examen (70%): '))

media_ponderada = (nota1 * 0.1) + (nota2 * 0.2) + (nota3 * 0.7)

if media_ponderada >= 5 and (nota1 < 4.5 or nota2 < 4.5 or nota3 < 4.5):
    media_ponderada = 4

print(f'La nota final es: {media_ponderada:2.f}')

print('\nFin del ejercicio')
print()


# 6. Escribir un programa en python que pida una entrada por teclado hasta que escribamos
# la palabra FIN (con mayúsculas). En ese caso terminamos y mostramos por pantalla el
# numero de entradas válidas que hemos hecho (sin contar esta última que sólo sirve para
# finalizar el programa)

'''
1º- Uso un while True hasta dar con el resultado
2º- Pido una cadena de texto al usuario de forma repetida
3º- Si escribe 'FIN' o 'fin', salgo del bucle ignoreCase()
4º. contabilizo las entradas que se hicieron
'''

print('*** ejercicio 6 ***')

contador = 0

while True:
    entrada = input('Escribe algo (FIN / fin para terminar): ')

    if entrada.lower() == 'FIN':
        break
    contador += 1

print(f'Has introducido {contador} entradas válidas.')

print('\nFin del ejercicio')
print()


# 7. Escribir un programa en python que pida un número por teclado y nos imprima la tabla
# de multiplicar de dicho número del 1 al 10. Por ejemplo, si introducimos el 74 el
# resultado será algo así:

   #  74 x 1 = 74
   #  74 x 2 = 148
   #  …
   #  74 x 10 = 740

'''
1º- Pido un número entero
2º- Pido dos contraseñas
3º- Muestro los resultados por pantalla formateados (f'')
'''

print('*** ejercicio 7 ***')

num = int(input('Introduce un número para ver su tabla de multiplicar [1 - 10]: '))

for i in range(1, 11):
    print(f'{num} * {i} = {num * i}')

print('\nFin del ejercicio')
print()


# 8. Escribir un programa en python que pida una contraseña por teclado (dos veces) y si no
# coinciden nos las vuelva a pedir hasta que lo hagan

'''
1º- Uso un bucle while (desconozco las veces que se va a repetir el bucle)
2º- Pido dos contraseñas
3º- Si no son iguales, vuelvo a pedirlas
'''

print('*** ejercicio 8 ***')

while True:
    password1 = input('Introduce la contraseña: ')
    password2 = input('Escribe nuevamente la contraseña: ')

    if password1.__eq__(password2):
        print('Contraseña correcta. Accediendo a su cuenta...\nEspere por favor.')
        break

    else:
        print('Las contraseñas no coinciden, inténtalo de nuevo.')

print('\nFin del ejercicio')
print()


# 9. Escribir un programa en python que nos pida nuestro nombre y apellidos (dos peticiones
# hechas en ese orden) y nos lo escriba formateado de la siguiente forma:

'''
1º- Pido nombre y apellidos
2º- Divido los apellidos en una lista
3º- muestro en el formato que pide el enunciado
'''

print('*** ejercicio 9 ***')

nombre = input('Introduce tu nombre: ')
apellidos = input('Introduce tus apellidos: ')

print(f'{apellidos}, {nombre}')

print('\nFin del ejercicio')
print()


# 10. Escribir un programa en python que nos pida elegir entre cuatro destinos turísticos
# (Francia, Italia, Chile o Japón) y dependiendo de nuestra respuesta nos diga cual es la
# capital de nuestro destino (París, Roma, Santiago de Chile o Tokio)

'''
1º- imprimo mensaje inicial mostrando las opciones
2º- Pido el destino al usuario
3º- Uso if - elif - else para mostrar la capital (en vez de un switch)
'''

print('*** ejercicio 10 ***')

print('Destinos disponibles: Francia | Italia | Chile | Japón')

destino = input('Elige un destino: ').strip().lower() # evitamos problemas de mayúsculas y minúsculas al inroducir destino

if destino.__eq__('francia'):
    print('La capital es París.')

elif destino.__eq__('italia'):
    print('La capital es Roma.')

elif destino.__eq__('Chile'):
    print('La capital es Santiago de chile')

elif destino.__eq__('japón') or destino.__eq__('japon'):
    print('La capital es Tokio.')

else:
    print('Destino no reconocido.')

