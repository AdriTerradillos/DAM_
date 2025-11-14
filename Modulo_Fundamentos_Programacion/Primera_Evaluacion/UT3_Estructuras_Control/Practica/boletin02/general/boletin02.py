from Primera_Evaluacion.UT3_Estructuras_Control.Practica.boletin02 import general


#   *** EJERCICIOS PYTHON 2 ***


# Este boletín de ejercicios está orientado a practicar fundamentalmente con variables enteras y
# float, operadores aritméticos sencillos, dos sentencias de control (if, for y while), la entrada de
# datos por teclado y la generación de números aleatorios.



# 1. Escribir un programa en python que nos pida tres números en cualquier orden y nos los
# muestre en pantalla ordenados de menor a mayor

# 1º- genero tres variables Integer 'num1', 'num2' & 'num3' junto con input + formulo el mensaje
# 2º- condicional if para realizar comprobaciones necesarias (operadores)
# 3º- imprimo mensaje por pantalla


def ejercicio1():
    print('*** ejercicio 1 ***')
    print('Se le pedirá introducir tres números enteros')
    print('Objetivo programa: ordenar de menor a mayor')
    num1 = int(input('Introduzca el primer valor numérico: '))
    num2 = int(input('Introduzca el segundo valor numérico: '))
    num3 = int(input('Introduzca el tercer valor numérico: '))

    # los guardo en un lista
    numeros = [num1, num2, num3]

    # ordeno la lista
    ordenados = sorted(numeros)
    print('Los números ordenados de menor a mayor son: ', ordenados)
    print()





# 2. Idem al anterior pero pidiéndonos apellidos de personas

'''
1º- Pido al usuario que ingrese sus apellidos usando input().
2º- Guardo la respuesta en la variable 'apellidos'
3º- Muestro por pantalla los apellidos ingresados.
'''

def ejercicio2():
    print('*** ejercicio 2 ***')
    apellidos = input('Por favor, introduce tus apellidos: ')
    print('Tus apellidos son ' , apellidos)
    print()

# 3. Programa que pide las notas de dos trimestres y calcula la media aritmética

'''
1º- Solicito al usuario las notas del primer y segundo trimestre.
2º- Convierto las entradas a float para poder hacer operaciones numéricas.
3º- Calculo la media aritmética sumando y dividiendo entre 2.
4º- Muestro el resultado por pantalla.
'''

def ejercicio3():
    print('*** ejercicio 3 ***')
    nota1 = float(input('Introduce la nota del primer trimestre: '))
    nota2 = float(input('Introduce la nota del segundo trimestre: '))
    media = (nota1 + nota2) / 2
    print('La media aritmética es: ' , media)
    print()


# 4. Programa que calcula la media ponderada de un trimestre

'''
1º- Solicito las tres notas: trabajo en clase, ejercicios prácticos y examen.
2º- Convierto las entradas a float.
3º- Aplico la ponderación correspondiente a cada nota.
4º- Sumo los resultados ponderados y muestro la media ponderada.
'''

def ejercicio4():
    print('*** ejercicio 4 ***')
    trabajo = float(input('Nota del trabajo en clase (10%): '))
    ejercicios = float(input('Nota de los ejercicios prácticos (20%): '))
    examen = float(input('Nota del examen (70%): '))
    media_ponderada = trabajo * 0.1 + ejercicios * 0.2 + examen * 0.7
    print('La media ponderada es: ', media_ponderada)
    print()


# 5. Modificación del ejercicio anterior para comprobar mínimos

'''
1º- Calculo la media ponderada igual que antes.
2º- Compruebo si alguna nota es menor que 4.5 y la media es aprobatoria (>5).
3º- Si se cumple la condición, la nota final será 4.
4º- Muestro el resultado final.
'''

def ejercicio5():
    print('*** ejercicio 5 ***')
    trabajo = float (input('Nota del trabajo en clase (10%): '))
    ejercicios = float (input('Nota de los ejercicios prácticos (20%): '))
    examen = float (input('Nota del examen (70%): '))

    media_ponderada = trabajo * 0.1 + ejercicios * 0.2 + examen * 0.7

    if media_ponderada >= 5 and (trabajo < 4.5 or ejercicios < 4.5 or examen < 4.5):
        print('La nota final ajustada por mínimo es: 4')
    else:
        print('La nota final es: ', media_ponderada)

    print()



# 6. Programa que pide entradas hasta que escribamos FIN

'''
1º- Inicializo un contador para las entradas válidas.
2º- Uso un bucle while infinito pidiendo entradas al usuario.
3º- Compruebo si la entrada es 'FIN'. Si es así, salgo del bucle.
4º- En cada entrada válida aumento el contador.
5º- Muestro el número de entradas válidas.
'''

def ejercicio6():
    print('*** ejercicio 6 ***')
    contador = 0
    while True:
        entrada = input('Introduce algo (FIN para terminar): ')
        if entrada == 'FIN':
            break
        contador += 1
    print('Número de entradas válidas:', contador)
    print()

# 7. Programa que imprime la tabla de multiplicar de un número

'''
1º- Pido al usuario un número.
2º- Recorro del 1 al 10 usando un bucle for.
3º- Multiplico el número por el contador del bucle en cada iteración.
4º- Imprimo el resultado en formato tabla de multiplicar.
'''

def ejercicio7():
    print('*** ejercicio 7 ***')
    numero = int(input('Introduce un número para la tabla de multiplicar: '))
    for i in range(1, 11):
        print(f'{numero} x {i} = {numero * i}')

print()

# 8. Programa que pide una contraseña y la confirma

'''
1º- Uso un bucle while para seguir pidiendo las contraseñas.
2º- Pido al usuario la contraseña dos veces.
3º- Si coinciden, salgo del bucle.
4º- Si no coinciden, vuelvo a pedirlas.
'''

def ejercicio8():
    print('*** ejercicio 8 ***')
    while True:
        contraseñaI = input('Introduce la contraseña: ')
        contraseñaII = input('Confirma la contraseña: ')
        if contraseñaI == contraseñaII:
            print('Contraseña aceptada')
            break
        else:
            print('No coinciden. Inténtalo de nuevo.')
            print()


# 9. Programa que formatea nombre y apellidos

'''
1º- Pido el nombre y los apellidos por separado.
2º- Uso f-strings para mostrar el nombre completo formateado.
'''

def ejercicio9():
    print('*** ejercicio 9 ***')
    nombre = input('Introduce tu nombre: ')
    apellido = input('Introduce tus apellidos: ')

    print(f'{apellido}, {nombre}')
    print()


# 10. Programa que muestra la capital según el destino elegido

'''
1º- Pido al usuario que elija un destino entre Francia, Italia, Chile o Japón.
2º- Uso condicionales if-elif-else para mostrar la capital correspondiente.
'''

def ejercicio10():
    print('*** ejercicio 10 ***')
    destino = input('Elige un destino (Francia, Italia, Chile, Japón): ')

    if destino == 'Francia':
        print('La capital es París')

    elif destino == 'Italia':
        print('La capital es Roma')

    elif destino == 'Chile' or destino == 'chile':
        print('La capital es Santiago de Chile')

    elif destino == 'Japón' or destino == 'Japon':
        print('La capital es Tokio')

    else:
        print('Destino no reconocido')
        print()

if __name__ == '__main__':
    ejercicio1()
    ejercicio2()
    ejercicio3()
    ejercicio4()
    ejercicio5()
    ejercicio6()
    ejercicio7()
    ejercicio8()
    ejercicio9()
    ejercicio10()
