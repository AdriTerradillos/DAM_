import math
from dbm import error

# *** BOLETÍN 1 ***

# 1. Escribir un programa donde se muestren los 10 primeros
#   números enteros

'''
1º- declaro variable numeros e igualo a 1
2º- genero bucle FOR -> recorro el bucle desde 1 a 10
3º- imprimo el mensaje por pantalla
'''

print('** ejercicio 1 **')
numeros = 1

for numeros in range(11):
    print(numeros)

print('Fin ejercicio')


#2. Escribir un programa donde se muestren los 50 primeros números pares

'''
1º- declaro la variable numbers e igualo a 1
2º- genero bucle FOR -> recorro el bucle en busca de 50 primeros pares
3º- imprimo el mensaje por pantalla
'''

print('** ejercicio 2 **')
numbers = 2

for numbers in range(101):
    if numbers %2 == 0:
        print(numbers)

print('Fin del ejercicio')




#3. Escribir un programa donde se muestren los 5 primeros números múltiplos de uno dado
#por el usuario

'''
1º- genero la variable num_Multiplos 
2º- genero el imput. Permite interactuar al usuario 
3º- genero el bucle FOR para mostrar los 5 primeros múltiplos

'''
print('*** ejercicio 3 ***')
num = int(input('Ingresa un número [1 - 6] '))


print(f'los 5 primeros múltiplos de {num} son ') # imprimo mensaje previo al bucle for
# para facilitar la lectura por pantalla

for i in range(1, 6):
    num_multiplo = num * i
    print(num_multiplo)

print('Fin ejercicio')


#4. Escribir un programa donde se muestren todos los números divisibles por 7 menores a
#10_000

'''
1º- genero variable numeroDivisibles
2º- entro en el bucle FOR para comprobar números divisibles a 7 menores a 10_000 
3º- imprimo mensaje por pantalla
'''
print('*** ejercicio 4 *** ')
print('Números divisibles por 7 menores a 10_000 ')
for numero_ in range(7, 10_000, 7):
    print(numero_)

print('Fin del ejercicio')
print()


#5. Escribir un programa que pida un número al usuario y diga si es par o impar

'''
1º- genero la clase input para entrar mensajes por teclado al usuario
2º- genero condicional if else para comprobar que tipo de número es (par/impar)
3º- Imprimo el mensaje por pantallas
'''

print(' *** ejercicio 5 ***')
numeroS = int (input('Ingresa un número '))

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
numDiv3 = int (input('Ingresa un número '))

if numDiv3 %3 == 0:
    print(numDiv3 , 'es divisible por 3')

else:
    print(numDiv3 , 'no es divisible por 3')

print('Fin ejercicio')
print()


#7. Escribir un programa que pida un número al usuario que simule ser el precio de un
#artículo y escriba el resultado de aplicarle el IVA del 21%

'''
1º- genero una variable numIva y la incorporo al input para salir por teclado



'''


#8. Escribir un programa que genere un número aleatorio entre el 0 y el 50 y lo muestre





