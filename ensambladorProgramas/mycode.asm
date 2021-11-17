org 100h

include "emu8086.inc"
include "macros.inc"

TITLE ProgramaASM
.MODEL lange
.STACK 64
.DATA

r1 DW ?
r2 DW ?
r3 DW ?
acum DW ?
msj1 DB 10,13,"Ingresa el regalo: ",'$'
regalo DW ?
msj2 DB 10,13,"Numero de alumnos que escogieron el regalo 1:",'$'
msj3 DB 10,13,"Numero de alumnos que escogieron el regalo 2:",'$'
msj4 DB 10,13,"Numero de alumnos que escogieron el regalo 3:",'$'
T1 DW ?
T2 DW ?
T3 DW ?
T4 DW ?
T5 DW ?
T6 DW ?
T7 DW ?
T8 DW ?

.CODE

asignar 0, r1
asignar 0, r2
asignar 0, r3
asignar 0, acum
e5:
CMP acum, 5
JL e10
JMP e15
e10:
printString msj1
printNum acum
leerNum regalo
CMP regalo, 1
JE e25
JMP e30
e25:
suma r1, 1, T3
asignar T3, r1
JMP e20
e30:
CMP regalo, 2
JE e40
JMP e45
e40:
suma r2, 1, T5
asignar T5, r2
JMP e35
e45:
CMP regalo, 3
JE e55
JMP e60
e55:
suma r3, 1, T7
asignar T7, r3
e60:
e35:
e20:
suma acum, 1, T8
asignar T8, acum
JMP e5
e15:
printString msj2
printNum r1
printString msj3
printNum r2
printString msj4
printNum r3

.EXIT