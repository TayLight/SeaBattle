package com.seabattle.SeaBattle;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Random;

public class GameUntil {
    private int[][] field;

    public int[][] fullField() {
        Random random = new Random();
        int countShips1 = 4;
        int countShips2 = 3;
        int countShips3 = 2;
        int countShips4 = 1;
        int countShips = 10;
        int rage = 0;
        field = new int[10][10];
        for (int[] ints : field) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (countShips != 0) {
                    rage = 1 + (int) (Math.random() * 4);
                    switch (rage) {
                        case 1:
                            if (countShips1 != 0) {
                                if (isRequiredField(i, j)) {
                                    setOne(i, j);
                                    countShips--;
                                    countShips1--;
                                }
                            }
                        case 2:
                            if (countShips2 != 0) {
                                if (isRequiredField(i, j) && isRequiredField(i + 1, j)) {
                                    setTwo(i, j, i + 1, j);
                                    countShips--;
                                    countShips2--;
                                } else if (isRequiredField(i, j) && isRequiredField(i - 1, j)) {
                                    setTwo(i, j, i - 1, j);
                                    countShips--;
                                    countShips2--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j - 1)) {
                                    setTwo(i, j, i, j - 1);
                                    countShips--;
                                    countShips2--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j + 1)) {
                                    setTwo(i, j, i, j - 1);
                                    countShips--;
                                    countShips2--;
                                }
                            }
                        case 3:
                            if (countShips3 != 0) {
                                if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j)) {
                                    setThree(i, j, false, false);
                                    countShips3--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i - 1, j) && isRequiredField(i - 2, j)) {
                                    setThree(i, j, false, true);
                                    countShips3--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j - 1) && isRequiredField(i, j - 2)) {
                                    setThree(i, j, true, true);
                                    countShips3--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2)) {
                                    setThree(i, j, true, false);
                                    countShips3--;
                                    countShips--;
                                }
                            }
                        case 4:
                            if (countShips4 != 0) {
                                if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j) && isRequiredField(i + 3, j)) {
                                    setFour(i, j, false, false);
                                    countShips4--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i - 1, j) && isRequiredField(i - 2, j) && isRequiredField(i - 3, j)) {
                                    setFour(i, j, false, true);
                                    countShips4--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j - 1) && isRequiredField(i, j - 2) && isRequiredField(i, j - 3)) {
                                    setFour(i, j, true, true);
                                    countShips4--;
                                    countShips--;
                                } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2) && isRequiredField(i, j + 3)) {
                                    setFour(i, j, true, false);
                                    countShips3--;
                                    countShips--;
                                }
                            }

                    }
                }
            }
        }
        return field;
    }

    public void viewField() {
        for (int[] ints : field) {
            for (int anInt : ints) {
                System.out.print(" | " + anInt + " | ");
            }
            System.out.println();
        }
    }

    private boolean isRequiredField(int i, int j) {
        if (i > 9 || i < 0 || j > 9 || j < 0) {
            return false;
        }
        try {
            if (i == 0 && j == 0) {
                if (field[i + 1][j] == 0 && field[i][j + 1] == 0 && field[i + 1][j + 1] == 0) {
                    return true;
                }
            } else if (i == 0 && j == 9) {
                if (field[i + 1][j] == 0 && field[i][j - 1] == 0 && field[i + 1][j - 1] == 0) {
                    return true;
                }
            } else if (i == 9 && j == 9) {
                if (field[i + 1][j] == 0 && field[i][j - 1] == 0 && field[i + 1][j - 1] == 0) {
                    return true;
                }
            } else if (i == 9 && j == 0) {
                if (field[i - 1][j] == 0 && field[i - 1][j + 1] == 0 && field[i][j + 1] == 0) {
                    return true;
                }
            } else if (j == 0) {
                if (field[i - 1][j] == 0 && field[i - 1][j + 1] == 0 && field[i][j + 1] == 0 && field[i + 1][j + 1] == 0 && field[i][j + 1] == 0) {
                    return true;
                }
            } else if (i == 0) {
                if (field[i][j - 1] == 0 && field[i + 1][j - 1] == 0 && field[i + 1][j] == 0 && field[i + 1][j + 1] == 0 && field[i][j + 1] == 0) {
                    return true;
                }
            } else if (j == 9) {
                if (field[i - 1][j] == 0 && field[i - 1][j - 1] == 0 && field[i][j - 1] == 0 && field[i + 1][j - 1] == 0 && field[i + 1][j] == 0) {
                    return true;
                }
            } else if (i == 9) {
                if (field[i][j - 1] == 0 && field[i - 1][j - 1] == 0 && field[i - 1][j] == 0 && field[i - 1][j + 1] == 0 && field[i][j + 1] == 0) {
                    return true;
                }
            } else if (field[i - 1][j - 1] == 0 && field[i][j - 1] == 0 && field[i + 1][j - 1] == 0 && field[i + 1][j] == 0 && field[i + 1][j + 1] == 0
                    && field[i][j + 1] == 0 && field[i - 1][j + 1] == 0 && field[i - 1][j] == 0) {
                return true;
            } else return false;
        } catch (IndexOutOfBoundsException indexOut){
            return false;
        }
        return false;
    }

    private void setOne(int i, int j) {
        field[i][j] = 1;
    }

    private void setTwo(int i, int j, int i1, int j1) {
        field[i][j] = 1;
        field[i1][j1] = 1;
    }

    private void setThree(int i, int j, boolean isVertical, boolean isMinus) {
        if (isVertical) {
            if (!isMinus) {
                for (int t = 0; t < 3; t++) {
                    field[i][j] = 1;
                    j++;
                }
            } else
                for (int t = 0; t < 3; t++) {
                    field[i][j] = 1;
                    j--;
                }
        } else {
            if (!isMinus) {
                for (int t = 0; t < 3; t++) {
                    field[i][j] = 1;
                    i++;
                }
            } else
                for (int t = 0; t < 3; t++) {
                    field[i][j] = 1;
                    i--;
                }
        }
    }

    private void setFour(int i, int j, boolean isVertical, boolean isMinus) {
        if (isVertical) {
            if (!isMinus) {
                for (int t = 0; t < 4; t++) {
                    field[i][j] = 1;
                    j++;
                }
            } else
                for (int t = 0; t < 4; t++) {
                    field[i][j] = 1;
                    j--;
                }
        } else {
            if (!isMinus)
                for (int t = 0; t < 4; t++) {
                    field[i][j] = 1;
                    i++;
                }
            else
                for (int t = 0; t < 4; t++) {
                    field[i][j] = 1;
                    i--;
                }
        }

    }

    public int[][] berega(){
        return fullField();
    }

    public int[][] halfField(){
        return fullField();
    }
}
