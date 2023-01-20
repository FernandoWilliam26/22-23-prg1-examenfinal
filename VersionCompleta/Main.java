import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //todo rellenar mapa

        String[][] mapa = {

                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"}, //1
                {"[]", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "[]", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "o", "[]"}, //2
                {"[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", ".", ".", ".", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]"}, //3
                {"[]", ".", ".", ".", ".", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", ".", ".", ".", ".", "[]"}, //4
                {"[]", ".", "[]", "[]", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "[]", "[]", ".", "[]"}, //5
                {"[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]"}, //6
                {"[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "", "", "", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]"}, //7
                {"[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "", "", "", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]"}, //8
                {"", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "", "", "", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", ""}, //9
                {"[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "", "", "", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]"}, //10
                {"[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "", "", "", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]"}, //11
                {"[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]"}, //12
                {"[]", ".", "[]", "[]", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "[]", "[]", ".", "[]"}, //13
                {"[]", ".", ".", ".", ".", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", ".", ".", ".", ".", "[]"}, //14
                {"[]", ".", "[]", "[]", "[]", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", ".", ".", ".", ".", "[]", "[]", "[]", "[]", "[]", "[]", ".", "[]", "[]", "[]", ".", "[]"}, //15
                {"[]", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "[]", "[]", "[]", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "o", "[]"}, //16
                {"[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]", "[]"} //17

        };

        //todo que el mapa este bien
        //todo colocar Pacman en la 14-14 y guardar su posicion en variable, pacmanI pacmanJ...
        //todo contar las bolas y cada vez que me como una que las reste, aparte de que me cuente 100 puntos por bola

        int pacmanI = 14;
        int pacmanJ = 14;
        int fantasmaI = 4;
        int fantasmaJ = 14;
        int turnos = 0;
        int bolitas = 0;
        int puntos = 0;
        int vidas = 2;
        int end = 0;
        int poder = 0;



        mapa[pacmanJ][pacmanJ] = "P";
        mapa[fantasmaI][fantasmaJ] = "F";



        //todo mostrar mapa

        for (int i = 0; i < mapa.length; i++) {

            for (int j = 0; j < mapa[0].length; j++) {


                System.out.print(mapa[i][j] + "\t");

            }

            System.out.println();

        }

        //todo turnos++, dentro de un while, pedir movimiento personaje, moverle y remostrar el mapa

        Scanner entrada = new Scanner(System.in);

        while (bolitas != 199 && mapa[pacmanI][pacmanJ]!=mapa[fantasmaI][fantasmaJ]) {

            System.out.println("[Puntos conseguidos]: " + puntos);
            System.out.println("[PoderInvencibilidad]: " + poder);
            System.out.println("[Turnos]: " + turnos);

            //todo movimiento Pacman

            System.out.println("Donde te vas a mover?");
            String movPacman = entrada.next();

            //todo Pacman hacia arriba

            if (movPacman.equalsIgnoreCase("w")) {

                if (mapa[pacmanI - 1][pacmanJ] == "[]") { //todo esto hace que no te des contra el muro


                } else {

                    mapa[pacmanI][pacmanJ] = " ";

                    if (mapa[pacmanI - 1][pacmanJ] == "." || mapa[pacmanI - 1][pacmanJ] == "o") { //todo esto hace que te cuente las bolas cuando vas hacia arriba

                        if (mapa[pacmanI - 1][pacmanJ] == "o") { //todo esto es para cuando te comas una bola grande que tengas 15 turnos para coemr a los fantasmas


                            poder = poder + 15; //todo aqui los tiempos se suman, si se sumasen seria poder = + 15;
                            puntos = puntos + 3;

                        }
                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI - 1][pacmanJ] = "P";

                    pacmanI = pacmanI - 1;

                    System.out.println("Pacman hacia arriba");

                    //todo pones aqui los turnos para que veas como va

                    turnos++;

                }

            }

            //todo Pacman hacia la izquierda

            if (movPacman.equalsIgnoreCase("a")) {

                if (pacmanI == 8 && pacmanJ == 0) { //todo esto hace que pueda pasar de una puerta a otra

                    mapa[pacmanI][pacmanJ] = " ";
                    pacmanI = 8;
                    pacmanJ = 28;
                    mapa[pacmanI][pacmanJ] = "P";

                } else if (mapa[pacmanI][pacmanJ - 1] == "[]") { //todo esto hace que no te des contra el muro

                    System.out.println("No te puedes mover");

                } else {

                    mapa[pacmanI][pacmanJ] = " ";

                    if (mapa[pacmanI][pacmanJ - 1] == "." || mapa[pacmanI][pacmanJ - 1] == "o") { //todo esto hace que te cuente las bolas cuando vas hacia la izquierda

                        if (mapa[pacmanI][pacmanJ - 1] == "o") { //todo esto es para cuando te comas una bola grande que tengas 15 turnos para coemr a los fantasmas


                            poder = poder + 15; //todo aqui los tiempos  se suman, si no se sumasen seria poder = + 15;
                            puntos = puntos + 3;


                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI][pacmanJ - 1] = "P";

                    pacmanJ = pacmanJ - 1;

                    System.out.println("Pacman hacia izquierda");

                    //todo pones aqui los turnos para que veas como va

                    turnos++;

                }

            }

            //todo Pacman hacia derecha

            if (movPacman.equalsIgnoreCase("d")) {

                if (pacmanI == 8 && pacmanJ == 28) { //todo esto hace que pueda pasar de una puerta a otra

                    mapa[pacmanI][pacmanJ] = " ";
                    pacmanI = 8;
                    pacmanJ = 0;
                    mapa[pacmanI][pacmanJ] = "P";

                } else if (mapa[pacmanI][pacmanJ + 1] == "[]") { //todo esto hace que no te des contra el muro

                    System.out.println("No te puedes mover");

                } else {

                    mapa[pacmanI][pacmanJ] = " ";

                    if (mapa[pacmanI][pacmanJ + 1] == "." || mapa[pacmanI][pacmanJ + 1] == "o") { //todo esto hace que te cuente las bolas cuando vas hacia la derecha

                        if (mapa[pacmanI][pacmanJ + 1] == "o") { //todo esto es para cuando te comas una bola grande que tengas 15 turnos para coemr a los fantasmas


                            poder = poder + 15; //todo aqui los tiempos se suman, si no se sumasen seria poder = + 15;
                            puntos = puntos + 3;

                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI][pacmanJ + 1] = "P";

                    pacmanJ = pacmanJ + 1;

                    System.out.println("Pacman hacia la derecha");

                    //todo pones aqui los turnos para que veas como va

                    turnos++;

                }

            }

            //todo Pacman hacia abajo

            if (movPacman.equalsIgnoreCase("s")) {

                if (mapa[pacmanI + 1][pacmanJ] == "[]") {

                    System.out.println("No te puedes mover");

                } else {

                    mapa[pacmanI][pacmanJ] = " ";

                    if (mapa[pacmanI + 1][pacmanJ] == "." || mapa[pacmanI + 1][pacmanJ] == "o") { //todo esto hace que te cuente las bolas cuando vas hacia abajo

                        if (mapa[pacmanI + 1][pacmanJ] == "o") { //todo esto es para cuando te comas una bola grande que tengas 15 turnos para coemr a los fantasmas

                            poder = poder + 15; //todo aqui los tiempos se suman, si no se sumasen seria poder = 15;
                            puntos = puntos + 3;

                        }

                        bolitas++;
                        puntos = puntos + 3;

                    }

                    mapa[pacmanI + 1][pacmanJ] = "P";

                    pacmanI = pacmanI + 1;

                    System.out.println("Pacman hacia abajo");

                    //todo pones aqui los turnos para que veas como va

                    turnos++;

                }

            }


            //todo Vuelvo a mostrar la matriz despues de rellenarla de nuevo modificando la IA Y Personaje

            for (int i = 0; i < mapa.length; i++) {

                for (int j = 0; j < mapa[i].length; j++) {

                    System.out.print(mapa[i][j] + "\t");

                }

                System.out.println();

            }

            //System.out.println("Bolas comidas: "+bolitas);



            System.out.println("Vidas: " + vidas);

            //todo poder

            if (poder > 0) {

                poder--;

            }

            //todo ver si me han comido

            if ((mapa[pacmanI][pacmanJ] == mapa[fantasmaI][fantasmaJ])) {

                if (poder == 0) {

                    //todo me come el fantasma

                    vidas--;

                    if (vidas >= 0) {

                        //todo si tengo vidas me manda al punto inicial

                        mapa[14][14] = "<O";

                        pacmanI = 14;
                        pacmanJ = 14;

                    } else {

                        //todo si no tengo vidas acabo

                        end = 1;

                        break;

                    }

                } else {

                    //todo me como yo al fantasma

                    mapa[4][14] = "Ñ";
                    fantasmaI = 4;
                    fantasmaJ = 14;


                }

            }

        }

        //System.out.println("Se acabó!");

        if (end == 0) {

            System.out.println("Has ganado!");

        } else if (end == 1) {

            System.out.println("Has perdido :(");

        }

    }

}