import random

# *** BOLETÍN 1 ***

# 1. Escribir un programa donde se muestren los 10 primeros
#   números enteros

'''
1º- declaro variable numeros e igualo a 1
2º- genero bucle FOR -> recorro el bucle desde 1 a 10
3º- imprimo el mensaje por pantalla
'''

print('*** ejercicio 1 ***')
numeros = 1

for numeros in range(11):
    print(numeros, end= ', ')
    if numeros % 5 == 0:  # salto de línea cada 5 números
        print()

print('Fin ejercicio')
print()


#2. Escribir un programa donde se muestren los 50 primeros números pares

'''
1º- declaro la variable numbers e igualo a 1
2º- genero bucle FOR -> recorro el bucle en busca de 50 primeros pares
3º- imprimo el mensaje por pantalla
'''

print('** ejercicio 2 **')
numbers = 2

for numbers in range(101):
    par = numbers * 2
    print(par, end=', ')
    if par % 20 == 0:  # salto de línea por cada 20 números
        print()

print('Fin del ejercicio')
print()




#3. Escribir un programa donde se muestren los 5 primeros números múltiplos de uno dado
#por el usuario

'''
1º- genero la variable num_Multiplos 
2º- genero el imput. Permite interactuar al usuario 
3º- genero el bucle FOR para mostrar los 5 primeros múltiplos
'''

print('*** ejercicio 3 ***')
num = int(input('Ingresa un número [1 - 6]: '))

print(f'los 5 primeros múltiplos de {num} son ') # imprimo mensaje previo al bucle for
# para facilitar la lectura por pantalla

for i in range(1, 6):
    num_multiplo = num * i
    print(num_multiplo, end= ', ')
    if num_multiplo % 20 == 0: # salto de línea por cada 20 números, más orden
        print()

print('Fin ejercicio')
print()


#4. Escribir un programa donde se muestren todos los números divisibles por 7 menores a
#10_000

'''
1º- genero variable numero_
2º- entro en el bucle FOR para comprobar números divisibles a 7 menores a 10_000 
3º- imprimo mensaje por pantalla
'''

print('*** ejercicio 4 *** ')
print('Números divisibles por 7 menores a 10_000:  ')

for numero_ in range(7, 10_000, 7):
    print(numero_ , end=', ')
    if numero_ % 50 == 0: # salto de línea por cada 50 números
        print()

print('Fin del ejercicio')
print()


#5. Escribir un programa que pida un número al usuario y diga si es par o impar

'''
1º- genero la clase input para entrar mensajes por teclado al usuario
2º- genero condicional if else para comprobar que tipo de número es (par/impar)
3º- Imprimo el mensaje por pantallas
'''

print(' *** ejercicio 5 ***')
numeroS = int (input('Ingresa un número para averiguar si es par o impar: '))

if numeroS %2 == 0:
    print(numeroS , 'es número par')

else:
    print(numeroS , 'es número impar')

print('Fin ejercicio')
print()


#6. Escribir un programa que pida un número al usuario y diga si es divisible por 3 o no.

'''
1º- genero la clase input para entrar mensajes por teclado al usuario
2º- genero condicional if else para comprobar si es divisible por 3 (if) o no (else)
3º- Imprimo el mensaje por pantalla
'''

print('*** ejercicio 6 ***')
numDiv3 = int (input('Ingresa un número para averiguar si es divisible por 3: '))

if numDiv3 %3 == 0:
    print(numDiv3 , 'es divisible por 3')

else:
    print(numDiv3 , 'no es divisible por 3')

print('Fin ejercicio')
print()


#7. Escribir un programa que pida un número al usuario que simule ser el precio de un
#artículo y escriba el resultado de aplicarle el IVA del 21%

'''
1º- genero variable precio a float y la incorporo al input para salir por teclado 
2º- genero la variable precioIva. Compruebo el Iva agregado al producto. 
Imprimo el mensaje
'''

print('*** ejercicio 7 ***')

precio = float (input('Introduce el precio del artículo [con decimales, €]: '))
precioIva = precio * 1.21

print('Precio del artículo: ' , precio , '€')
print('Precio del articulo con IVA del 21%: ' , precioIva, '€')

print('Fin del ejercicio')
print()

#8. Escribir un programa que genere un número aleatorio entre el 0 y el 50 y lo muestre

''' 
1º- random.randint() para acoplar los valores mayor (50) y menor (0)
2º- Imprimo el mensaje
'''

print('*** ejercicio 8 ***')

numAleatorio = random.randint(0, 50)
print('el número aleatorio entre 0 y 50 es: ' , numAleatorio)

print('Fin del ejercicio')
print()


# 9. Escribir un programa que genere dos números aleatorios simultáneamente entre el 1 y el
# 6 (simulando una tirada de dos dados)

'''
1º- genero dos variables 'dado1' y 'dado2 con random.randint(). 
Busco obtener un número aleatorio entre 1 y 6
2º- Imprimo el mensaje por pantalla
'''

print('*** ejercicio 9 ***')

dado1 = random.randint(1, 6)
dado2 = random.randint(1, 6)

print('Resultado primer dado: ' , dado1)
print('Resultado primer dado: ' , dado2)

print('Fin del ejercicio')
print()


# 10. Escribir un programa que nos pida dos números y genere un número aleatorio
# comprendido entre ambos. Por el momento no te preocupes de que el primer número
# siempre debería de ser menor que el segundo, simplemente no los metas en un orden
# incorrecto.

'''
1º- genero dos variables 'numAleatorio1' y 'numAleatorio2'. Integro el input
2º- Compruebo si el primer número es menor que el segundo con un if else
3º- Imprimo el mensaje por pantalla
'''

print('*** ejercicio 10 ***')

numAleatorio1 = int (input('Ingresa el primer valor numerico: '))
numAleatorio2 = int (input('Ingresa el segundo valor numerico:  '))

if numAleatorio1 < numAleatorio2:
    print(numAleatorio1 , ' es menor que ' , numAleatorio2)

else:
    print(numAleatorio1 , ' es mayor que ' , numAleatorio2)


print('Fin del ejercicio')
print()


#11. Modificar el programa del punto anterior para que si el primer número que metemos es
#mayor que el segundo funcione correctamente. Es decir, si metemos en primer lugar el
#50 y en segundo el 10 nos debería de generar un número aleatorio entre el 10 y el 50 (y
#no entre el 50 y el 10 que no tiene mucha lógica...)

'''
1º- Tomo los datos de las variables del ejercicio anterior 'numAleatorio1' y ''numAleatorio2'
Las variables son dinámicas, puedo volver a declararlas sin problema de compilación. (a diferencia de JAVA)
2º- Modifico dentro del condicional if el signo de '>' por '<' , mantengo misma estrucutura
3º- Imprimo el mensaje por pantalla
'''

print('*** ejercicio 11 ***')
numAleatorio1 = int (input('Ingresa el primer valor numerico: '))
numAleatorio2 = int (input('Ingresa el segundo valor numerico: '))

if numAleatorio1 > numAleatorio2:
    print(numAleatorio1 , ' es mayor que ' , numAleatorio2)

else:
    print(numAleatorio1 , ' es menor que ' , numAleatorio2)


print('Fin del ejercicio')
print()

# 12. Escribir un programa que genere seis números aleatorios entre el 1 y el 49 (simulando
# una primitiva). Por el momento no te preocupes de que algunos números puedan salir
# repetidos. Ya resolveremos eso más adelante.


'''
1º- genero seis variables 'num1', 'num2', ... 'num6'.  Establecezco la longitud de estos
numeros aleatorios dentro del intervalo [1 , 50] con random.randint(). 
 Obtengo entonces seis números aleatorios entre 1 y 49
2º- bucle for --> conozco de antemano las veces que quiero los aleatorios.
Establezco la contidad de números aleatorios que pide el enunciado [1 , 6]
3º- Imprimo mensaje por pantalla
'''

print('*** ejercicio 12 ***')

num1 = random.randint(1 , 50)
num2 = random.randint(1 , 50)
num3 = random.randint(1 , 50)
num4 = random.randint(1 , 50)
num5 = random.randint(1 , 50)
num6 = random.randint(1 , 50)

for i in range(1, 6):
    print(f'Primer número aleatorio:  {num1}\n'
          f'Segundo número aleatorio: {num2}\n'
          f'Tercer número aleatorio: {num3}\n'
          f'Cuarto número aleatorio: {num4}\n'
          f'Quinto número aleatorio: {num5}\n'
          f'Sexto número aleatorio: {num6}')
    break  # cierro el programa para evitar loop

print('Fin del ejercicio')
print()
print()

print('******')
print('Fin del Boletin01.py')
print('******')