# Conversor de medidas
Se pide desarrollar una aplicación que permita convertir de una unidad de medida a otra.

## Modelo de pantalla

* Un texto editable numérico donde ingresar un valor
* Un botón Convertir
* Un label que muestre el valor convertido

## Requerimiento Principal

Convertir de millas a kilómetros.

# Variantes en Arena con Binding

## Simple

Es el que implementa el requerimiento principal. La vista ConversorWindow trabaja con el esquema MVC contra un modelo muy sencillo, que tiene dos propiedades:

* millas 
* kilometros 
* y un método convertir que realiza la acción
