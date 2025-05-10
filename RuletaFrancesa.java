package com.mycompany.ruletaFrancesa;

import java.util.Scanner;

public class RuletaFrancesa {

    public static void main(String[] args) {
        Scanner ing = new Scanner(System.in);
        int sal = 50000, apuacu = 0, gandoscol = 0, gandosdoc = 0, ganbajalt = 0, ganparimp = 0, ganrojneg = 0, gancol = 0, gandoc = 0, gansei = 0, gancua = 0, gancal = 0, gancab = 0, ganple = 0, i = 0, j = 0, k = 0, l = 0, aux = 0, rul = 0, ret = 0;
        int doscol[] = new int[2], dosdoc[] = new int[2], bajalt[] = new int[2], parimp[] = new int[2], rojneg[] = new int[2], col[] = new int[3], doc[] = new int[3], sei[][] = new int[11][11], cua[][][][] = new int[37][37][37][37], cal[] = new int[12], cab[][] = new int[37][37], ple[] = new int[37];
        int posdoscol = 0, posdosdoc = 0, posbajalt = 0, posparimp = 0, posrojneg = 0, poscol = 0, posdoc = 0, possei[] = new int[2], poscua[] = new int[4], poscal = 0, poscab[] = new int[2], posple = 0;
        String nomlin[] = new String[12], nomcol, nomdoc, lin, nombajalt[] = new String[2], nomparimp[] = new String[2], nomrojneg[] = new String[2];
        nomlin[0] = "1ra";
        nomlin[1] = "2da";
        nomlin[2] = "3ra";
        nomlin[3] = "4ta";
        nomlin[4] = "5ta";
        nomlin[5] = "6ta";
        nomlin[6] = "7ma";
        nomlin[7] = "8va";
        nomlin[8] = "9na";
        nomlin[9] = "10ma";
        nomlin[10] = "11va";
        nomlin[11] = "12va";
        nomcol = "columna";
        nomdoc = "docena";
        lin = "linea";
        nombajalt[0] = "baja";
        nombajalt[1] = "alta";
        nomparimp[0] = "par";
        nomparimp[1] = "impar";
        nomrojneg[0] = "rojo";
        nomrojneg[1] = "negro";
        System.out.print("Digite un nombre de usuario: ");
        String nomjug = ing.nextLine();
        System.out.println();
        System.out.println("    |---- Bienvenido/a " + nomjug + " al juego de la RULETA FRANCESA!----|");
        System.out.println();
        System.out.println("Las instrucciones para jugar son las siguientes:");
        System.out.println();
        System.out.println("1-Usted dispondra de 50.000 pesos iniciales para apostar");
        System.out.println("2-Se le presentara distintos menus donde usted tendra que ingresar el numero que corresponde a la opcion que desea escoger");
        System.out.println("3-Para ganar usted tendra que obtener una suma de total de 500.000 pesos, sin limites de giros de ruleta");
        System.out.println("4-Usted perdera el juego si llega a perder todo su dinero");
        System.out.println();
        System.out.println("NOTA: 1-Para retirar dinero de una apuesta, escriba el numero negativo correspondiente al valor que desea retirar");
        System.out.println("      2-Colocar unicamente valores numericos enteros sin caracteres especiales");
        System.out.println("      3-La visualizacion del tablero funciona unicamente como guia");
        System.out.println("      4-El 0 solo aplica para las apuestas: Cuadro, Caballo, Pleno");
        dibujoTablero();
        while (sal >= 0 && sal < 500000) {
            int apu = 0;
            System.out.println("Saldo actual: " + sal);
            System.out.println("Valor total apostado: " + apuacu);
            System.out.println();
            System.out.println("Categorias de apuesta:");
            System.out.println("1-x1/2 (Dos columnas O Dos docenas)");
            System.out.println("2-x1 (Baja-Alta O Par-Impar O Rojo-Negro)");
            System.out.println("3-x2 (Columna O Docena)");
            System.out.println("4-x5 (Seisena)");
            System.out.println("5-x8 (Cuadro)");
            System.out.println("6-x11 (Calle)");
            System.out.println("7-x17 (Caballo)");
            System.out.println("8-x35 (Pleno)");
            System.out.println("9-MOSTRAR LAS APUESTAS ACTUALES");
            System.out.println("10-VER TABLERO");
            System.out.println("11-GIRAR LA RULETA");
            System.out.println("12-FINALIZAR Y RETIRAR DINERO ACTUAL");
            int opapu = ing.nextInt();
            switch (opapu) {
                case 1:
                    System.out.println("Apuesta seleccionada: x1/2");
                    System.out.println("1-Dos columnas");
                    System.out.println("2-Dos docenas");
                    int opx05 = ing.nextInt();
                    switch (opx05) {
                        case 1:
                            System.out.println("Usted ha apostado en dos columnas");
                            System.out.println("Seleccione columnas");
                            System.out.println("1-1ra y 2da columna");
                            System.out.println("2-2da y 3ra columna");
                            posdoscol = valorInvalido(posdoscol, doscol);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, doscol, posdoscol);
                            doscol[posdoscol] += apu;
                            sal -= apu;
                            valorRetirox05(doscol, posdoscol, apu, nomlin, nomcol);
                            valorApuestax05(i, doscol, gandoscol, apu, nomlin, nomcol);
                            apuesta0(apu);
                            anulacionApuestax05(doscol, posdoscol, apu, nomlin, nomcol);
                            break;
                        case 2:
                            System.out.println("Usted ha apostado en dos docenas");
                            System.out.println("Seleccione docenas");
                            System.out.println("1-1ra y 2da docena");
                            System.out.println("2-2da y 3ra docena");
                            posdosdoc = valorInvalido(posdosdoc, dosdoc);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, dosdoc, posdosdoc);
                            dosdoc[posdosdoc] += apu;
                            sal -= apu;
                            valorRetirox05(dosdoc, posdosdoc, apu, nomlin, nomdoc);
                            valorApuestax05(i, dosdoc, gandosdoc, apu, nomlin, nomdoc);
                            apuesta0(apu);
                            anulacionApuestax05(dosdoc, posdosdoc, apu, nomlin, nomdoc);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Apuesta seleccionada: x1");
                    System.out.println("1-Baja-Alta (1 al 18) o (19 al 36)");
                    System.out.println("2-Par-Impar");
                    System.out.println("3-Rojo-Negro");
                    int opx1 = ing.nextInt();
                    switch (opx1) {
                        case 1:
                            System.out.println("Usted ha apostado Baja-Alta");
                            System.out.println("Seleccione opcion");
                            System.out.println("1-Baja");
                            System.out.println("2-Alta");
                            posbajalt = valorInvalido(posbajalt, bajalt);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, bajalt, posbajalt);
                            bajalt[posbajalt] += apu;
                            sal -= apu;
                            valorRetirox1(bajalt, posbajalt, apu, nombajalt);
                            valorApuestax1(i, bajalt, ganbajalt, apu, nombajalt);
                            apuesta0(apu);
                            anulacionApuestax1(bajalt, posbajalt, apu, nombajalt);
                            break;
                        case 2:
                            System.out.println("Usted ha apostado Par-Impar");
                            System.out.println("Seleccione opcion");
                            System.out.println("1-Par");
                            System.out.println("2-Impar");
                            posparimp = valorInvalido(posparimp, parimp);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, parimp, posparimp);
                            parimp[posparimp] += apu;
                            sal -= apu;
                            valorRetirox1(parimp, posparimp, apu, nomparimp);
                            valorApuestax1(i, parimp, ganparimp, apu, nomparimp);
                            apuesta0(apu);
                            anulacionApuestax1(parimp, posparimp, apu, nomparimp);
                            break;
                        case 3:
                            System.out.println("Usted ha apostado Rojo-Negro");
                            System.out.println("Seleccione opcion");
                            System.out.println("1-Rojo");
                            System.out.println("2-Negro");
                            posrojneg = valorInvalido(posrojneg, rojneg);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, rojneg, posrojneg);
                            rojneg[posrojneg] += apu;
                            sal -= apu;
                            valorRetirox1(rojneg, posrojneg, apu, nomrojneg);
                            valorApuestax1(i, rojneg, ganrojneg, apu, nomrojneg);
                            apuesta0(apu);
                            anulacionApuestax1(rojneg, posrojneg, apu, nomrojneg);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Apuesta seleccionada: x2");
                    System.out.println("1-Columna");
                    System.out.println("2-Docena");
                    int opx2 = ing.nextInt();
                    switch (opx2) {
                        case 1:
                            System.out.println("Usted ha apostado en columna");
                            System.out.println("Seleccione columna");
                            System.out.println("1-1ra columna");
                            System.out.println("2-2da columna");
                            System.out.println("3-3ra columna");
                            poscol = valorInvalido(poscol, col);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, col, poscol);
                            col[poscol] += apu;
                            sal -= apu;
                            valorRetirox2x11(col, poscol, apu, nomlin, nomcol);
                            valorApuestax2x11(i, col, gancol, apu, nomlin, nomcol, 2);
                            apuesta0(apu);
                            anulacionApuestax2x11(col, poscol, apu, nomlin, nomcol);
                            break;
                        case 2:
                            System.out.println("Usted ha apostado en docena");
                            System.out.println("Seleccione docena");
                            System.out.println("1-1ra docena");
                            System.out.println("2-2da docena");
                            System.out.println("3-3ra docena");
                            posdoc = valorInvalido(posdoc, doc);
                            apu = ingresoApuesta(apu);
                            apu = apuestaSuperaSaldo(sal, apu);
                            apu = retiroSuperaValorApostado(sal, apu, apuacu, doc, posdoc);
                            doc[posdoc] += apu;
                            sal -= apu;
                            valorRetirox2x11(doc, posdoc, apu, nomlin, nomdoc);
                            valorApuestax2x11(i, doc, gandoc, apu, nomlin, nomdoc, 2);
                            apuesta0(apu);
                            anulacionApuestax2x11(doc, posdoc, apu, nomlin, nomdoc);
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Apuesta seleccionada: x5");
                    System.out.println("Usted ha apostado en seisena");
                    System.out.println("Seleccione en que lineas adyacentes quiere realizar su apuesta");
                    for (i = 0; i < possei.length; i++) {
                        possei[i] = ing.nextInt();
                        possei[i] -= 1;
                    }
                    for (i = 0; i < possei.length - 1; i++) {
                        for (j = 0; j < possei.length - i - 1; j++) {
                            if (possei[j] > possei[j + 1]) {
                                aux = possei[j];
                                possei[j] = possei[j + 1];
                                possei[j + 1] = aux;
                            }
                        }
                    }
                    possei[0] = valorInvalidoConArray0Seisena(possei, i, j, aux, sei);
                    possei[1] = valorInvalidoConArray1Seisena(possei, i, j, aux, sei);
                    apu = ingresoApuesta(apu);
                    apu = apuestaSuperaSaldo(sal, apu);
                    apu = retiroSuperaValorApostadoDosOpciones(sal, i, j, apu, apuacu, sei, possei);
                    sei[possei[0]][possei[1]] += apu;
                    sal -= apu;
                    valorRetirox5(sei, possei, apu, nomlin, lin);
                    valorApuestax5(i, j, sei, possei, gansei, apu, nomlin, lin);
                    apuesta0(apu);
                    anulacionApuestax5(sei, possei, apu, nomlin, lin);
                    break;
                case 5:
                    System.out.println("Apuesta seleccionada: x8");
                    System.out.println("Usted ha apostado en cuadro");
                    System.out.println("Seleccione los numeros que componen el cuadro en cualquier orden (Incluyendo el 0, 1, 2, 3)");
                    for (i = 0; i < poscua.length; i++) {
                        poscua[i] = ing.nextInt();
                    }
                    for (i = 0; i < poscua.length - 1; i++) {
                        for (j = 0; j < poscua.length - i - 1; j++) {
                            if (poscua[j] > poscua[j + 1]) {
                                aux = poscua[j];
                                poscua[j] = poscua[j + 1];
                                poscua[j + 1] = aux;
                            }
                        }
                    }
                    poscua[0] = valorInvalidoConArray0Cuadro(poscua, i, j, l, aux, cua);
                    poscua[1] = valorInvalidoConArray1Cuadro(poscua, i, j, l, aux, cua);
                    poscua[2] = valorInvalidoConArray2Cuadro(poscua, i, j, l, aux, cua);
                    poscua[3] = valorInvalidoConArray3Cuadro(poscua, i, j, l, aux, cua);
                    apu = ingresoApuesta(apu);
                    apu = apuestaSuperaSaldo(sal, apu);
                    apu = retiroSuperaValorApostadoCuatroOpciones(sal, i, j, apu, apuacu, cua, poscua);
                    cua[poscua[0]][poscua[1]][poscua[2]][poscua[3]] += apu;
                    sal -= apu;
                    valorRetirox8(cua, poscua, apu);
                    valorApuestax8(i, j, k, l, cua, poscua, gancua, apu);
                    apuesta0(apu);
                    anulacionApuestax8(cua, poscua, apu);
                    break;
                case 6:
                    System.out.println("Apuesta seleccionada: x11");
                    System.out.println("Usted ha apostado en calle");
                    System.out.println("Seleccione en que linea del 1 al 12 quiere realizar su apuesta");
                    poscal = valorInvalido(poscal, cal);
                    apu = ingresoApuesta(apu);
                    apu = apuestaSuperaSaldo(sal, apu);
                    apu = retiroSuperaValorApostado(sal, apu, apuacu, cal, poscal);
                    cal[poscal] += apu;
                    sal -= apu;
                    valorRetirox2x11(cal, poscal, apu, nomlin, lin);
                    valorApuestax2x11(i, cal, gancal, apu, nomlin, lin, 11);
                    apuesta0(apu);
                    anulacionApuestax2x11(cal, poscal, apu, nomlin, lin);
                    break;
                case 7:
                    System.out.println("Apuesta seleccionada: x17");
                    System.out.println("Usted ha apostado en caballo");
                    System.out.println("Seleccione dos casillas adyacentes");
                    for (i = 0; i < poscab.length; i++) {
                        poscab[i] = ing.nextInt();
                    }
                    for (i = 0; i < poscab.length - 1; i++) {
                        for (j = 0; j < poscab.length - i - 1; j++) {
                            if (poscab[j] > poscab[j + 1]) {
                                aux = poscab[j];
                                poscab[j] = poscab[j + 1];
                                poscab[j + 1] = aux;
                            }
                        }
                    }
                    poscab[0] = valorInvalidoConArray0Caballo(poscab, i, j, l, aux, cab);
                    poscab[1] = valorInvalidoConArray1Caballo(poscab, i, j, l, aux, cab);
                    apu = ingresoApuesta(apu);
                    apu = apuestaSuperaSaldo(sal, apu);
                    apu = retiroSuperaValorApostadoDosOpciones(sal, i, j, apu, apuacu, cab, poscab);
                    cab[poscab[0]][poscab[1]] += apu;
                    sal -= apu;
                    valorRetirox17(cab, poscab, apu);
                    valorApuestax17(i, j, cab, poscab, gancab, apu);
                    apuesta0(apu);
                    anulacionApuestax17(cab, poscab, apu);
                    break;
                case 8:
                    System.out.println("Apuesta seleccionada: x35");
                    System.out.println("Usted ha apostado en pleno");
                    System.out.println("Seleccione una casilla del 0 al 36");
                    posple = valorInvalidox35(posple, ple);
                    apu = ingresoApuesta(apu);
                    apu = apuestaSuperaSaldo(sal, apu);
                    apu = retiroSuperaValorApostado(sal, apu, apuacu, ple, posple);
                    ple[posple] += apu;
                    sal -= apu;
                    valorRetirox35(ple, posple, apu);
                    valorApuestax35(i, ple, ganple, apu);
                    apuesta0(apu);
                    anulacionApuestax35(ple, posple, apu);
                    break;
                case 9:
                    apu = 1;
                    int verapuact = 1;
                    int verapuactx05 = 1;
                    for (i = 0; i < doscol.length && i < dosdoc.length && verapuactx05 != 0; i++) {
                        if (0 != doscol[i] || 0 != dosdoc[i]) {
                            System.out.println("Apuesta x1/2 (Dos columnas O Dos docenas)");
                            valorApuestax05(i, doscol, gandoscol, apu, nomlin, nomcol);
                            valorApuestax05(i, dosdoc, gandosdoc, apu, nomlin, nomdoc);
                            System.out.println();
                            verapuactx05 = 0;
                            verapuact = 0;
                        }
                    }
                    int verapuactx1 = 1;
                    for (i = 0; i < bajalt.length && i < parimp.length && i < rojneg.length && verapuactx1 != 0; i++) {
                        if (0 != bajalt[i] || 0 != parimp[i] || 0 != rojneg[i]) {
                            System.out.println("Apuesta x1 (Rojo-Negro O Par-Impar O Baja-Alta)");
                            valorApuestax1(i, bajalt, ganbajalt, apu, nombajalt);
                            valorApuestax1(i, parimp, ganparimp, apu, nomparimp);
                            valorApuestax1(i, rojneg, ganrojneg, apu, nomrojneg);
                            System.out.println();
                            verapuactx1 = 0;
                            verapuact = 0;
                        }
                    }
                    int verapuactx2 = 1;
                    for (i = 0; i < col.length && i < doc.length && verapuactx2 != 0; i++) {
                        if (0 != col[i] || 0 != doc[i]) {
                            System.out.println("Apuesta x2 (Docena O Columna)");
                            valorApuestax2x11(i, col, gancol, apu, nomlin, nomcol, 2);
                            valorApuestax2x11(i, doc, gandoc, apu, nomlin, nomdoc, 2);
                            System.out.println();
                            verapuactx2 = 0;
                            verapuact = 0;
                        }
                    }
                    int verapuactx5 = 1;
                    for (i = 0; i < sei.length && verapuactx5 != 0; i++) {
                        for (j = 0; j < sei.length && verapuactx5 != 0; j++) {
                            if (0 != sei[i][j]) {
                                System.out.println("Apuesta x5 (Seisena)");
                                valorApuestax5(i, j, sei, possei, gansei, apu, nomlin, lin);
                                System.out.println();
                                verapuactx5 = 0;
                                verapuact = 0;
                            }
                        }
                    }
                    int verapuactx8 = 1;
                    for (i = 0; i < cua.length && verapuactx8 != 0; i++) {
                        for (j = 0; j < cua.length && verapuactx8 != 0; j++) {
                            for (k = 0; k < cua.length && verapuactx8 != 0; k++) {
                                for (l = 0; l < cua.length && verapuactx8 != 0; l++) {
                                    if (0 != cua[i][j][k][l]) {
                                        System.out.println("Apuesta x8 (Cuadro)");
                                        valorApuestax8(i, j, k, l, cua, poscua, gancua, apu);
                                        System.out.println();
                                        verapuactx8 = 0;
                                        verapuact = 0;
                                    }
                                }
                            }
                        }
                    }
                    int verapuactx11 = 1;
                    for (i = 0; i < cal.length && verapuactx11 != 0; i++) {
                        if (0 != cal[i]) {
                            System.out.println("Apuesta x11 (Calle)");
                            valorApuestax2x11(i, cal, gancal, apu, nomlin, lin, 11);
                            System.out.println();
                            verapuactx11 = 0;
                            verapuact = 0;
                        }
                    }
                    int verapuactx17 = 1;
                    for (i = 0; i < cab.length && verapuactx17 != 0; i++) {
                        for (j = 0; j < cab.length && verapuactx17 != 0; j++) {
                            if (0 != cab[i][j]) {
                                System.out.println("Apuesta x17 (Caballo)");
                                valorApuestax17(i, j, cab, poscab, gancab, apu);
                                System.out.println();
                                verapuactx17 = 0;
                                verapuact = 0;
                            }
                        }
                    }
                    int verapuactx35 = 1;
                    for (i = 0; i < ple.length && verapuactx35 != 0; i++) {
                        if (0 != ple[i]) {
                            System.out.println("Apuesta x35 (Pleno)");
                            valorApuestax35(i, ple, ganple, apu);
                            System.out.println();
                            verapuactx35 = 0;
                            verapuact = 0;
                        }
                    }
                    apu = 0;
                    if (verapuact == 1) {
                        System.out.println("Aun no tiene ninguna apuesta activa");
                    }
                    break;
                case 10:
                    dibujoTablero();
                    break;
                case 11:
                    sal = girarRuleta(rul, i, j, k, l, sal, doscol, nomlin, nomcol, dosdoc, nomdoc, bajalt, nombajalt, parimp, nomparimp, rojneg, nomrojneg, col, doc, lin, sei, cua, cal, cab, ple);
                    apuacu = 0;
                    break;
                case 12:
                    System.out.println("Usted se ha retirado con la suma de: " + sal);
                    sal = -2;
                    System.out.println("Gracias por jugar");
                    break;
            }
            apuacu += apu;
            if (sal != -2) {
                System.out.println("Volviendo al menu principal...");
                System.out.println();
            }
            if (sal == 0) {
                System.out.println("Saldo actual: " + sal);
                System.out.println("No tiene mas saldo disponible, desea retirar dinero?");
                System.out.println("1-SI");
                System.out.println("2-NO");
                ret = ing.nextInt();
                if (ret == 1) {
                    System.out.println("Escriba el numero negativo correspondiente al valor que desea retirar");
                    System.out.println("Volviendo al menu principal...");
                    System.out.println();
                } else {
                    System.out.println("Girando la ruleta");
                    sal = girarRuleta(rul, i, j, k, l, sal, doscol, nomlin, nomcol, dosdoc, nomdoc, bajalt, nombajalt, parimp, nomparimp, rojneg, nomrojneg, col, doc, lin, sei, cua, cal, cab, ple);
                    apuacu = 0;
                }
            }
            if (sal >= 500000) {
                System.out.println("Felicidades!, usted gano!");
                System.out.println("Usted gano una bonificacion de 500.000");
                sal += 500000;
                System.out.println("Su saldo es de: " + sal);
                System.out.println("Gracias por jugar");
                sal = -2;
            } else {
                if (sal <= 0 && ret != 1 && sal != -2) {
                    sal = -1;
                    System.out.println("Has perdido todo tu dinero, gracias por jugar");
                }
            }
        }
    }

    public static void dibujoTablero() {
        System.out.println();
        System.out.println("     -----------------------------------------------------------------------------------");
        System.out.println("    |  1 |  2 |  3 |  4  |  5  |  6  |  7  |  8  |  9  |  10 |  11 |  12 ||    Lineas   |");
        System.out.println(" ---------------------------------------------------------------------------------------");
        System.out.println("|   | 3R | 6  | 9R | 12R | 15  | 18R | 21R | 24  | 27R | 30R | 33  | 36R || 3ra columna |");
        System.out.println("|   |----|----|----|-----|-----|-----|-----|-----|-----|-----|-----|-----||-------------|");
        System.out.println("| 0 | 2  | 5R | 8  | 11  | 14R | 17  | 20  | 23R | 26  | 29  | 32R | 35  || 2da columna |");
        System.out.println("|   |----|----|----|-----|-----|-----|-----|-----|-----|-----|-----|-----||-------------|");
        System.out.println("|   | 1R | 4  | 7R | 10  | 13  | 16R | 19R | 22  | 25R | 28  | 31  | 34R || 1ra columna |");
        System.out.println(" ---|--------------------|-----------------------|-----------------------||-------------");
        System.out.println("    |     1ra docena     |       2da docena      |       3ra docena      |");
        System.out.println("    |--------------------|-----------------------|-----------------------|");
        System.out.println("    |   Baja   |   Par   |    Rojo   |   Negro   |    Impar   |   Alta   |");
        System.out.println("     --------------------------------------------------------------------");
        System.out.println();
        System.out.println("NOTA: Numeros representados con (R) son rojos, los demas son negros");
    }

    public static int valorInvalido(int pos, int catapu[]) {
        Scanner ing = new Scanner(System.in);
        pos = ing.nextInt();
        pos -= 1;
        while (pos >= catapu.length || pos < 0) {
            System.out.println("Valor invalido");
            System.out.println("Digite la opcion nuevamente");
            pos = ing.nextInt();
            pos -= 1;
        }
        return pos;
    }

    public static int valorInvalidox35(int pos, int catapu[]) {
        Scanner ing = new Scanner(System.in);
        pos = ing.nextInt();
        while (pos >= catapu.length || pos < 0) {
            System.out.println("Valor invalido");
            System.out.println("Digite la opcion nuevamente");
            pos = ing.nextInt();
        }
        return pos;
    }

    public static int valorInvalidoConArray0Seisena(int pos[], int i, int j, int aux, int catapu[][]) {
        Scanner ing = new Scanner(System.in);
        for (i = 0; i < pos.length; i++) {
            while (pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1)) {
                System.out.println("Valores invalidos");
                System.out.println("Digite las opciones nuevamente");
                for (i = 0; i < pos.length; i++) {
                    pos[i] = ing.nextInt();
                    pos[i] -= 1;
                }
                for (i = 0; i < pos.length - 1; i++) {
                    for (j = 0; j < pos.length - i - 1; j++) {
                        if (pos[j] > pos[j + 1]) {
                            aux = pos[j];
                            pos[j] = pos[j + 1];
                            pos[j + 1] = aux;
                        }
                    }
                }
            }
        }
        return pos[0];
    }

    public static int valorInvalidoConArray1Seisena(int pos[], int i, int j, int aux, int catapu[][]) {
        Scanner ing = new Scanner(System.in);
        for (i = 0; i < pos.length; i++) {
            while (pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1)) {
                System.out.println("Valores invalidos");
                System.out.println("Digite las opciones nuevamente");
                for (i = 0; i < pos.length; i++) {
                    pos[i] = ing.nextInt();
                    pos[i] -= 1;
                }
                for (i = 0; i < pos.length - 1; i++) {
                    for (j = 0; j < pos.length - i - 1; j++) {
                        if (pos[j] > pos[j + 1]) {
                            aux = pos[j];
                            pos[j] = pos[j + 1];
                            pos[j + 1] = aux;
                        }
                    }
                }
            }
        }
        return pos[1];
    }

    public static int valorInvalidoConArray0Cuadro(int pos[], int i, int j, int l, int aux, int catapu[][][][]) {
        Scanner ing = new Scanner(System.in);
        int vercua = 0;
        while (vercua != 3) {
            vercua = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1) || pos[2] != (pos[0] + 3) || pos[3] != (pos[0] + 4)) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercua--;
                    }
                }
                if (pos[0] == 0 && (pos[2] != 2 || pos[3] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
            }
        }
        return pos[0];
    }

    public static int valorInvalidoConArray1Cuadro(int pos[], int i, int j, int l, int aux, int catapu[][][][]) {
        Scanner ing = new Scanner(System.in);
        int vercua = 0;
        while (vercua != 3) {
            vercua = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1) || pos[2] != (pos[0] + 3) || pos[3] != (pos[0] + 4)) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercua--;
                    }
                }
                if (pos[0] == 0 && (pos[2] != 2 || pos[3] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
            }
        }
        return pos[1];
    }

    public static int valorInvalidoConArray2Cuadro(int pos[], int i, int j, int l, int aux, int catapu[][][][]) {
        Scanner ing = new Scanner(System.in);
        int vercua = 0;
        while (vercua != 3) {
            vercua = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1) || pos[2] != (pos[0] + 3) || pos[3] != (pos[0] + 4)) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercua--;
                    }
                }
                if (pos[0] == 0 && (pos[2] != 2 || pos[3] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
            }
        }
        return pos[2];
    }

    public static int valorInvalidoConArray3Cuadro(int pos[], int i, int j, int l, int aux, int catapu[][][][]) {
        Scanner ing = new Scanner(System.in);
        int vercua = 0;
        while (vercua != 3) {
            vercua = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || pos[1] != (pos[0] + 1) || pos[2] != (pos[0] + 3) || pos[3] != (pos[0] + 4)) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercua--;
                    }
                }
                if (pos[0] == 0 && (pos[2] != 2 || pos[3] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercua--;
                }
            }
        }
        return pos[3];
    }

    public static int valorInvalidoConArray0Caballo(int pos[], int i, int j, int l, int aux, int catapu[][]) {
        Scanner ing = new Scanner(System.in);
        int vercab = 0;
        while (vercab != 3) {
            vercab = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || (pos[1] != (pos[0] + 1) && pos[1] != (pos[0] + 3))) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercab--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercab--;
                    }
                }
                if (pos[0] == 0 && (pos[1] != 2 && pos[1] != 1 && pos[1] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercab--;
                }
            }
        }
        return pos[0];
    }

    public static int valorInvalidoConArray1Caballo(int pos[], int i, int j, int l, int aux, int catapu[][]) {
        Scanner ing = new Scanner(System.in);
        int vercab = 0;
        while (vercab != 3) {
            vercab = 3;
            for (i = 0; i < pos.length; i++) {
                while ((pos[i] >= catapu.length || pos[0] < 0 || (pos[1] != (pos[0] + 1) && pos[1] != (pos[0] + 3))) && pos[0] != 0) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercab--;
                }
                for (l = 1; l < 13; l++) {
                    if (pos[0] == 3 * l && pos[1] == pos[0] + 1) {
                        System.out.println("Valores invalidos");
                        System.out.println("Digite las opciones nuevamente");
                        for (i = 0; i < pos.length; i++) {
                            pos[i] = ing.nextInt();
                        }
                        for (i = 0; i < pos.length - 1; i++) {
                            for (j = 0; j < pos.length - i - 1; j++) {
                                if (pos[j] > pos[j + 1]) {
                                    aux = pos[j];
                                    pos[j] = pos[j + 1];
                                    pos[j + 1] = aux;
                                }
                            }
                        }
                        vercab--;
                    }
                }
                if (pos[0] == 0 && (pos[1] != 2 && pos[1] != 1 && pos[1] != 3)) {
                    System.out.println("Valores invalidos");
                    System.out.println("Digite las opciones nuevamente");
                    for (i = 0; i < pos.length; i++) {
                        pos[i] = ing.nextInt();
                    }
                    for (i = 0; i < pos.length - 1; i++) {
                        for (j = 0; j < pos.length - i - 1; j++) {
                            if (pos[j] > pos[j + 1]) {
                                aux = pos[j];
                                pos[j] = pos[j + 1];
                                pos[j + 1] = aux;
                            }
                        }
                    }
                    vercab--;
                }
            }
        }
        return pos[1];
    }

    public static int ingresoApuesta(int apu) {
        Scanner ing = new Scanner(System.in);
        System.out.println("Cuanto dinero desea apostar/retirar?");
        apu = ing.nextInt();
        return apu;
    }

    public static int apuestaSuperaSaldo(int sal, int apu) {
        Scanner ing = new Scanner(System.in);
        while (sal < apu) {
            System.out.println("La apuesta supera el saldo disponible");
            System.out.println("Ponga un valor diferente");
            apu = ing.nextInt();
        }
        return apu;
    }

    public static int retiroSuperaValorApostado(int sal, int apu, int apuacu, int catapu[], int pos) {
        Scanner ing = new Scanner(System.in);
        if (apu < 0) {
            apu *= -1;
            while (apu > apuacu || apu > catapu[pos]) {
                System.out.println("El retiro supera el valor apostado disponible para esta apuesta");
                System.out.println("Ponga un valor diferente");
                apu = ing.nextInt();
                apu *= -1;
            }
            apu *= -1;
        }
        return apu;
    }

    public static int retiroSuperaValorApostadoDosOpciones(int sal, int i, int j, int apu, int apuacu, int catapu[][], int pos[]) {
        Scanner ing = new Scanner(System.in);
        if (apu < 0) {
            apu *= -1;
            while (apu > apuacu || apu > catapu[pos[0]][pos[1]]) {
                System.out.println("El retiro supera el valor apostado disponible para esta apuesta");
                System.out.println("Ponga un valor diferente");
                apu = ing.nextInt();
                apu *= -1;
            }
            apu *= -1;
        }
        return apu;
    }

    public static int retiroSuperaValorApostadoCuatroOpciones(int sal, int i, int j, int apu, int apuacu, int catapu[][][][], int pos[]) {
        Scanner ing = new Scanner(System.in);
        if (apu < 0) {
            apu *= -1;
            while (apu > apuacu || apu > catapu[pos[0]][pos[1]][pos[2]][pos[3]]) {
                System.out.println("El retiro supera el valor apostado disponible para esta apuesta");
                System.out.println("Ponga un valor diferente");
                apu = ing.nextInt();
                apu *= -1;
            }
            apu *= -1;
        }
        return apu;
    }

    public static void valorRetirox05(int catapu[], int poscatapu, int apu, String nomlin[], String nomapu) {
        if (apu < 0 && 0 < catapu[poscatapu]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en: " + nomlin[poscatapu] + " y " + nomlin[poscatapu + 1] + " " + nomapu);
        }
    }

    public static void valorRetirox1(int catapu[], int poscatapu, int apu, String nomapu[]) {
        if (apu < 0 && 0 < catapu[poscatapu]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en: " + nomapu[poscatapu]);
        }
    }

    public static void valorRetirox2x11(int catapu[], int poscatapu, int apu, String nomlin[], String nomapu) {
        if (apu < 0 && 0 < catapu[poscatapu]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en: " + nomlin[poscatapu] + " " + nomapu);
        }
    }

    public static void valorRetirox5(int catapu[][], int poscatapu[], int apu, String nomlin[], String nomapu) {
        if (apu < 0 && 0 < catapu[poscatapu[0]][poscatapu[1]]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en: " + nomlin[poscatapu[0]] + " y " + nomlin[poscatapu[1]] + " " + nomapu);
        }
    }

    public static void valorRetirox8(int catapu[][][][], int poscatapu[], int apu) {
        if (apu < 0 && 0 < catapu[poscatapu[0]][poscatapu[1]][poscatapu[2]][poscatapu[3]]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en el cuadro: " + poscatapu[0] + ", " + poscatapu[1] + ", " + poscatapu[2] + ", " + poscatapu[3]);
        }
    }

    public static void valorRetirox17(int catapu[][], int poscatapu[], int apu) {
        if (apu < 0 && 0 < catapu[poscatapu[0]][poscatapu[1]]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en los numeros: " + poscatapu[0] + ", " + poscatapu[1]);
        }
    }

    public static void valorRetirox35(int catapu[], int poscatapu, int apu) {
        if (apu < 0 && 0 < catapu[poscatapu]) {
            apu *= -1;
            System.out.println("Usted ha retirado " + apu + " de su apuesta en el numero: " + poscatapu);
        }
    }

    public static void valorApuestax05(int i, int catapu[], int gancatapu, int apu, String nomlin[], String nomapu) {
        for (i = 0; i < catapu.length; i++) {
            if (0 != catapu[i] && apu != 0) {
                System.out.println("El valor de su apuesta es " + catapu[i] + " en: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
                gancatapu = (int) (catapu[i] * 0.5);
                System.out.println("Ganancia: " + gancatapu);
            }
        }
    }

    public static void valorApuestax1(int i, int catapu[], int gancatapu, int apu, String nomapu[]) {
        for (i = 0; i < catapu.length; i++) {
            if (0 != catapu[i] && apu != 0) {
                System.out.println("El valor de su apuesta es " + catapu[i] + " en: " + nomapu[i]);
                gancatapu = catapu[i];
                System.out.println("Ganancia: " + gancatapu);
            }
        }
    }

    public static void valorApuestax2x11(int i, int catapu[], int gancatapu, int apu, String nomlin[], String nomapu, int gan) {
        for (i = 0; i < catapu.length; i++) {
            if (0 != catapu[i] && apu != 0) {
                System.out.println("El valor de su apuesta es " + catapu[i] + " en: " + nomlin[i] + " " + nomapu);
                gancatapu = catapu[i] * gan;
                System.out.println("Ganancia: " + gancatapu);
            }
        }
    }

    public static void valorApuestax5(int i, int j, int catapu[][], int pos[], int gancatapu, int apu, String nomlin[], String nomapu) {
        for (i = 0; i < catapu.length; i++) {
            for (j = 0; j < catapu.length; j++) {
                if (0 != catapu[i][j] && apu != 0) {
                    System.out.println("El valor de su apuesta es " + catapu[i][j] + " en: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
                    gancatapu = catapu[i][j] * 5;
                    System.out.println("Ganancia: " + gancatapu);
                }
            }
        }
    }

    public static void valorApuestax8(int i, int j, int k, int l, int catapu[][][][], int pos[], int gancatapu, int apu) {
        for (i = 0; i < catapu.length; i++) {
            for (j = 0; j < catapu.length; j++) {
                for (k = 0; k < catapu.length; k++) {
                    for (l = 0; l < catapu.length; l++) {
                        if (0 != catapu[i][j][k][l] && apu != 0) {
                            System.out.println("El valor de su apuesta es " + catapu[i][j][k][l] + " en el cuadro: " + i + ", " + j + ", " + k + ", " + l);
                            gancatapu = catapu[i][j][k][l] * 8;
                            System.out.println("Ganancia: " + gancatapu);
                        }
                    }
                }
            }
        }
    }

    public static void valorApuestax17(int i, int j, int catapu[][], int pos[], int gancatapu, int apu) {
        for (i = 0; i < catapu.length; i++) {
            for (j = 0; j < catapu.length; j++) {
                if (0 != catapu[i][j] && apu != 0) {
                    System.out.println("El valor de su apuesta es " + catapu[i][j] + " en los numeros: " + i + ", " + j);
                    gancatapu = catapu[i][j] * 17;
                    System.out.println("Ganancia: " + gancatapu);
                }
            }
        }
    }

    public static void valorApuestax35(int i, int catapu[], int gancatapu, int apu) {
        for (i = 0; i < catapu.length; i++) {
            if (0 != catapu[i] && apu != 0) {
                System.out.println("El valor de su apuesta es " + catapu[i] + " en el numero: " + i);
                gancatapu = catapu[i] * 35;
                System.out.println("Ganancia: " + gancatapu);
            }
        }
    }

    public static void apuesta0(int apu) {
        if (apu == 0) {
            System.out.println("Usted no aposto nada en esta ronda");
        }
    }

    public static void anulacionApuestax05(int catapu[], int poscatapu, int apu, String nomlin[], String nomapu) {
        if (catapu[poscatapu] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en: " + nomlin[poscatapu] + " y " + nomlin[poscatapu + 1] + " " + nomapu);
        }
    }

    public static void anulacionApuestax1(int catapu[], int poscatapu, int apu, String nomapu[]) {
        if (catapu[poscatapu] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en: " + nomapu[poscatapu]);
        }
    }

    public static void anulacionApuestax2x11(int catapu[], int poscatapu, int apu, String nomlin[], String nomapu) {
        if (catapu[poscatapu] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en: " + nomlin[poscatapu] + " " + nomapu);
        }
    }

    public static void anulacionApuestax5(int catapu[][], int poscatapu[], int apu, String nomlin[], String nomapu) {
        if (catapu[poscatapu[0]][poscatapu[1]] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en: " + nomlin[poscatapu[0]] + " y " + nomlin[poscatapu[1]] + " " + nomapu);
        }
    }

    public static void anulacionApuestax8(int catapu[][][][], int poscatapu[], int apu) {
        if (catapu[poscatapu[0]][poscatapu[1]][poscatapu[2]][poscatapu[3]] == 0) {
            System.out.println("Usted ha anulado su apuesta en el cuadro: " + poscatapu[0] + ", " + poscatapu[1] + ", " + poscatapu[2] + ", " + poscatapu[3]);
        }
    }

    public static void anulacionApuestax17(int catapu[][], int poscatapu[], int apu) {
        if (catapu[poscatapu[0]][poscatapu[1]] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en los numeros: " + poscatapu[0] + " y " + poscatapu[1]);
        }
    }

    public static void anulacionApuestax35(int catapu[], int poscatapu, int apu) {
        if (catapu[poscatapu] == 0 && apu != 0) {
            System.out.println("Usted ha anulado su apuesta en el numero: " + poscatapu);
        }
    }

    public static int girarRuleta(int rul, int i, int j, int k, int l, int sal, int doscol[], String nomlin[], String nomcol, int dosdoc[], String nomdoc, int bajalt[], String nombajalt[], int parimp[], String nomparimp[], int rojneg[], String nomrojneg[], int col[], int doc[], String lin, int sei[][], int cua[][][][], int cal[], int cab[][], int ple[]) {
        rul = (int) (Math.random() * 36);
        System.out.println("Salio el numero: " + rul);
        for (i = 0; i < doscol.length; i++) {
            if (0 != doscol[i]) {
                j = 3;
                while (rul != j && j != 37) {
                    j += 3;
                    if (j >= 37) {
                        j = 37;
                    }
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                sal = ganarApuestax05(nomlin, i, nomcol, sal, doscol);
                            } else {
                                perderApuestax05(nomlin, i, nomcol, doscol);
                            }
                        } else {
                            perderApuestax05(nomlin, i, nomcol, doscol);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax05(nomlin, i, nomcol, doscol);
                            } else {
                                sal = ganarApuestax05(nomlin, i, nomcol, sal, doscol);
                            }
                        } else {
                            perderApuestax05(nomlin, i, nomcol, doscol);
                        }
                        break;
                }
                doscol[i] = 0;
            }
        }
        for (i = 0; i < dosdoc.length; i++) {
            if (0 != dosdoc[i]) {
                j = 25;
                while (rul != j && j != 37) {
                    j++;
                    if (j >= 37) {
                        j = 37;
                    }
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                sal = ganarApuestax05(nomlin, i, nomdoc, sal, dosdoc);
                            } else {
                                perderApuestax05(nomlin, i, nomdoc, dosdoc);
                            }
                        } else {
                            perderApuestax05(nomlin, i, nomdoc, dosdoc);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax05(nomlin, i, nomdoc, dosdoc);
                            } else {
                                sal = ganarApuestax05(nomlin, i, nomdoc, sal, dosdoc);
                            }
                        } else {
                            perderApuestax05(nomlin, i, nomdoc, dosdoc);
                        }
                        break;
                }
                dosdoc[i] = 0;
            }
        }
        for (i = 0; i < bajalt.length; i++) {
            if (0 != bajalt[i]) {
                j = 19;
                while (rul != j && j != 37) {
                    j++;
                    if (j >= 37) {
                        j = 37;
                    }
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                sal = ganarApuestax1(i, nombajalt, sal, bajalt);
                            } else {
                                perderApuestax1(i, nombajalt, bajalt);
                            }
                        } else {
                            perderApuestax1(i, nombajalt, bajalt);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax1(i, nombajalt, bajalt);
                            } else {
                                sal = ganarApuestax1(i, nombajalt, sal, bajalt);
                            }
                        } else {
                            perderApuestax1(i, nombajalt, bajalt);
                        }
                        break;
                }
                bajalt[i] = 0;
            }
        }
        for (i = 0; i < parimp.length; i++) {
            if (0 != parimp[i]) {
                j = 1;
                while (rul != j && j != 37) {
                    j += 2;
                    if (j >= 37) {
                        j = 37;
                    }
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                sal = ganarApuestax1(i, nomparimp, sal, parimp);
                            } else {
                                perderApuestax1(i, nomparimp, parimp);
                            }
                        } else {
                            perderApuestax1(i, nomparimp, parimp);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax1(i, nomparimp, parimp);
                            } else {
                                sal = ganarApuestax1(i, nomparimp, sal, parimp);
                            }
                        } else {
                            perderApuestax1(i, nomparimp, parimp);
                        }
                        break;
                }
                parimp[i] = 0;
            }
        }
        for (i = 0; i < rojneg.length; i++) {
            if (0 != rojneg[i]) {
                j = 2;
                while (rul != j && j != 37) {
                    j += 2;
                    if (j >= 37) {
                        j = 37;
                    }
                    if (j == 10 || j == 28) {
                        j++;
                        if (j >= 37) {
                            j = 37;
                        }
                        if (j == 17 || j == 35) {
                            j += 3;
                            if (j >= 37) {
                                j = 37;
                            }
                        }
                    }
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                sal = ganarApuestax1(i, nomrojneg, sal, rojneg);
                            } else {
                                perderApuestax1(i, nomrojneg, rojneg);
                            }
                        } else {
                            perderApuestax1(i, nomrojneg, rojneg);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax1(i, nomrojneg, rojneg);
                            } else {
                                sal = ganarApuestax1(i, nomrojneg, sal, rojneg);
                            }
                        } else {
                            perderApuestax1(i, nomrojneg, rojneg);
                        }
                        break;
                }
                rojneg[i] = 0;
            }
        }
        for (i = 0; i < col.length; i++) {
            if (0 != col[i]) {
                switch (i) {
                    case 0:
                        j = 1;
                        while (rul != j && j != 37) {
                            j += 3;
                            if (j >= 37) {
                                j = 37;
                            }
                        }
                        break;
                    case 1:
                        j = 2;
                        while (rul != j && j != 37) {
                            j += 3;
                            if (j >= 37) {
                                j = 37;
                            }
                        }
                        break;
                    case 2:
                        j = 3;
                        while (rul != j && j != 37) {
                            j += 3;
                            if (j >= 37) {
                                j = 37;
                            }
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomcol, col);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomcol, col);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomcol, col);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomcol, col);
                        }
                        break;
                    case 2:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomcol, col);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomcol, col);
                        }
                        break;
                }
                col[i] = 0;
            }
        }
        for (i = 0; i < doc.length; i++) {
            if (0 != doc[i]) {
                switch (i) {
                    case 0:
                        j = 1;
                        while (rul != j && j != 37) {
                            j++;
                            if (j >= 13) {
                                j = 37;
                            }
                        }
                        break;
                    case 1:
                        j = 13;
                        while (rul != j && j != 37) {
                            j += 3;
                            if (j >= 25) {
                                j = 37;
                            }
                        }
                        break;
                    case 2:
                        j = 25;
                        while (rul != j && j != 37) {
                            j += 3;
                            if (j >= 37) {
                                j = 37;
                            }
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomdoc, doc);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomdoc, doc);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomdoc, doc);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomdoc, doc);
                        }
                        break;
                    case 2:
                        if (rul != 0) {
                            if (j == 37) {
                                perderApuestax2x11(i, nomlin, nomdoc, doc);
                            } else {
                                sal = ganarApuestax2x11(i, nomlin, nomcol, sal, col, 2);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, nomdoc, doc);
                        }
                        break;
                }
                doc[i] = 0;
            }
        }
        for (i = 0; i < sei.length; i++) {
            for (j = 0; j < sei.length; j++) {
                if (0 != sei[i][j]) {
                    switch (i) {
                        case 0:
                            if (j == 1) {
                                if (rul != 0) {
                                    if (rul > 0 && rul < 7) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 1:
                            if (j == 2) {
                                if (rul != 0) {
                                    if (rul > 3 && rul < 10) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 2:
                            if (j == 3) {
                                if (rul != 0) {
                                    if (rul > 6 && rul < 13) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 3:
                            if (j == 4) {
                                if (rul != 0) {
                                    if (rul > 9 && rul < 16) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 4:
                            if (j == 5) {
                                if (rul != 0) {
                                    if (rul > 12 && rul < 19) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 5:
                            if (j == 6) {
                                if (rul != 0) {
                                    if (rul > 15 && rul < 22) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 6:
                            if (j == 7) {
                                if (rul != 0) {
                                    if (rul > 18 && rul < 25) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 7:
                            if (j == 8) {
                                if (rul != 0) {
                                    if (rul > 21 && rul < 28) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 8:
                            if (j == 9) {
                                if (rul != 0) {
                                    if (rul > 24 && rul < 31) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 9:
                            if (j == 10) {
                                if (rul != 0) {
                                    if (rul > 27 && rul < 34) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                        case 10:
                            if (j == 11) {
                                if (rul != 0) {
                                    if (rul > 30 && rul < 37) {
                                        sal = ganarApuestax5(i, j, nomlin, lin, sal, sei);
                                    } else {
                                        perderApuestax5(i, j, nomlin, lin, sei);
                                    }
                                } else {
                                    perderApuestax5(i, j, nomlin, lin, sei);
                                }
                            }
                            break;
                    }
                    sei[i][j] = 0;
                }
            }
        }
        for (i = 0; i < cua.length; i++) {
            for (j = 0; j < cua.length; j++) {
                for (k = 0; k < cua.length; k++) {
                    for (l = 0; l < cua.length; l++) {
                        if (0 != cua[i][j][k][l]) {
                            if (rul == i || rul == j || rul == k || rul == l) {
                                System.out.println("Has ganado en la apuesta del cuadro: " + i + ", " + j + ", " + k + ", " + l);
                                sal += cua[i][j][k][l] + (cua[i][j][k][l] * 8);
                                System.out.println("Valor de la apuesta: " + cua[i][j][k][l]);
                                cua[i][j][k][l] *= 8;
                                System.out.println("Ganancia total: " + cua[i][j][k][l]);
                            } else {
                                System.out.println("Has perdido tus apuestas en el cuadro: " + i + ", " + j + ", " + k + ", " + l);
                                System.out.println("Valor de la apuesta: " + cua[i][j][k][l]);
                            }
                            cua[i][j][k][l] = 0;
                        }
                    }
                }
            }
        }
        for (i = 0; i < cal.length; i++) {
            if (0 != cal[i]) {
                switch (i) {
                    case 0:
                        if (rul != 0) {
                            if (rul > 0 && rul < 4) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 1:
                        if (rul != 0) {
                            if (rul > 3 && rul < 7) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 2:
                        if (rul != 0) {
                            if (rul > 6 && rul < 10) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 3:
                        if (rul != 0) {
                            if (rul > 9 && rul < 13) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 4:
                        if (rul != 0) {
                            if (rul > 12 && rul < 16) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 5:
                        if (rul != 0) {
                            if (rul > 15 && rul < 19) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 6:
                        if (rul != 0) {
                            if (rul > 18 && rul < 22) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 7:
                        if (rul != 0) {
                            if (rul > 21 && rul < 25) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 8:
                        if (rul != 0) {
                            if (j > 24 && j < 28) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 9:
                        if (rul != 0) {
                            if (j > 27 && j < 31) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 10:
                        if (rul != 0) {
                            if (j > 30 && j < 34) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                    case 11:
                        if (rul != 0) {
                            if (j > 33 && j < 37) {
                                sal = ganarApuestax2x11(i, nomlin, lin, sal, cal, 11);
                            } else {
                                perderApuestax2x11(i, nomlin, lin, cal);
                            }
                        } else {
                            perderApuestax2x11(i, nomlin, lin, cal);
                        }
                        break;
                }
                cal[i] = 0;
            }
        }
        for (i = 0; i < cab.length; i++) {
            for (j = 0; j < cab.length; j++) {
                if (0 != cab[i][j]) {
                    if (rul == i || rul == j) {
                        System.out.println("Has ganado en la apuesta del caballo: " + i + ", " + j);
                        sal += cab[i][j] + (cab[i][j] * 17);
                        System.out.println("Valor de la apuesta: " + cab[i][j]);
                        cab[i][j] *= 17;
                        System.out.println("Ganancia total: " + cab[i][j]);
                    } else {
                        System.out.println("Has perdido tu apuesta en el caballo: " + i + ", " + j);
                        System.out.println("Valor de la apuesta: " + cab[i][j]);
                    }
                    cab[i][j] = 0;
                }
            }
        }
        for (i = 0; i < ple.length; i++) {
            if (0 != ple[i]) {
                if (rul == i) {
                    System.out.println("Has ganado en la apuesta del pleno: " + i);
                    sal += ple[i] + (ple[i] * 35);
                    System.out.println("Valor de la apuesta: " + ple[i]);
                    ple[i] *= 35;
                    System.out.println("Ganancia total: " + ple[i]);
                } else {
                    System.out.println("Has perdido tu apuesta en el pleno: " + i);
                    System.out.println("Valor de la apuesta: " + ple[i]);
                }
                ple[i] = 0;
            }
        }
        return sal;
    }

    public static void perderApuestax05(String nomlin[], int i, String nomapu, int catapu[]) {
        System.out.println("Has perdido tu apuesta en: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
        System.out.println("Valor de la apuesta: " + catapu[i]);
    }

    public static int ganarApuestax05(String nomlin[], int i, String nomapu, int sal, int catapu[]) {
        System.out.println("Has ganado en la apuesta de: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
        sal += catapu[i] + (int) (catapu[i] * 0.5);
        System.out.println("Valor de la apuesta: " + catapu[i]);
        catapu[i] = (int) (catapu[i] * 0.5);
        System.out.println("Ganancia total: " + catapu[i]);
        return sal;
    }

    public static void perderApuestax1(int i, String nomapu[], int catapu[]) {
        System.out.println("Has perdido tu apuesta en: " + nomapu[i]);
        System.out.println("Valor de la apuesta: " + catapu[i]);
    }

    public static int ganarApuestax1(int i, String nomapu[], int sal, int catapu[]) {
        System.out.println("Has ganado en la apuesta de: " + nomapu[i]);
        sal += catapu[i] * 2;
        System.out.println("Valor de la apuesta: " + catapu[i]);
        System.out.println("Ganancia total: " + catapu[i]);
        return sal;
    }

    public static void perderApuestax2x11(int i, String nomlin[], String nomapu, int catapu[]) {
        System.out.println("Has perdido tu apuesta en: " + nomlin[i] + " " + nomapu);
        System.out.println("Valor de la apuesta: " + catapu[i]);
    }

    public static int ganarApuestax2x11(int i, String nomlin[], String nomapu, int sal, int catapu[], int gan) {
        System.out.println("Has ganado en la apuesta de: " + nomlin[i] + " " + nomapu);
        sal += catapu[i] + catapu[i] * gan;
        System.out.println("Valor de la apuesta: " + catapu[i]);
        catapu[i] *= gan;
        System.out.println("Ganancia total: " + catapu[i]);
        return sal;
    }

    public static void perderApuestax5(int i, int j, String nomlin[], String nomapu, int catapu[][]) {
        System.out.println("Has perdido tu apuesta en: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
        System.out.println("Valor de la apuesta: " + catapu[i][j]);
    }

    public static int ganarApuestax5(int i, int j, String nomlin[], String nomapu, int sal, int catapu[][]) {
        System.out.println("Has ganado en la apuesta de: " + nomlin[i] + " y " + nomlin[i + 1] + " " + nomapu);
        sal += catapu[i][j] + catapu[i][j] * 5;
        System.out.println("Valor de la apuesta: " + catapu[i][j]);
        catapu[i][j] *= 5;
        System.out.println("Ganancia total: " + catapu[i][j]);
        return sal;
    }
}
