; MACROS

multiplicacion MACRO op1, op2, res
	MOV AX, op1
	MOV CX, op2
	IMUL CX
	MOV res, AX
ENDM

division MACRO op1, op2, res
	MOV DX, 0
	MOV AX, op1
	MOV CX, op2
	idiv CX
	cmp DX, 0
	MOV res,AX
ENDM

asignar MACRO op1, res
	MOV AX, op1
	MOV res,AX
	XOR AX,AX
ENDM

suma MACRO op1, op2, res
	MOV AX, op1
	add AX, op2
	MOV res, AX
	xor AX,AX
ENDM

resta MACRO op1, op2, res
	MOV AX, op1
	sub AX, op2
	MOV res, AX
ENDM

nuevaLinea MACRO
	putc 0Dh
	putc 0Ah
ENDM

incremenarUno MACRO var
	MOV AX, var
	inc AX
	MOV var,AX
ENDM

printNum MACRO var
    MOV AX, var
    call PRINT_NUM
    nuevaLinea
ENDM

printString MACRO var
	MOV DX, offset var
	MOV ah, 9
	int 21h
	nuevaLinea
ENDM

leerNum MACRO var
	CALL SCAN_NUM
	MOV var,CX
	nuevaLinea
ENDM

DEFINE_SCAN_NUM
DEFINE_PRINT_NUM_UNS
DEFINE_PRINT_NUM