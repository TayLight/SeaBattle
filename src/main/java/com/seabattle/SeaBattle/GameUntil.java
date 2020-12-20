package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.Ship;
import org.springframework.data.relational.core.sql.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GameUntil {
    private int[][] field;
    List<Ship> shipList = new LinkedList<>();
    public static final Comparator<Ship> COMPARE_BY_DECKS = (lhs, rhs) -> rhs.getDecks() - lhs.getDecks();

    public int[][] fullField() {
        int countShips1 = 4;
        int countShips2 = 3;
        int countShips3 = 2;
        int countShips4 = 1;
        int countShips = 10;
        int rage;
        field = new int[10][10];
        for (int[] ints : field) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (countShips != 0) {
                    rage = 1 + (int) (Math.random() * 4);
                    if (rage == 1) {
                        if (countShips1 != 0) {
                            if (isRequiredField(i, j)) {
                                try {
                                    setOne(i, j);
                                    countShips--;
                                    countShips1--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            }
                        }
                    } else if (rage == 2) {
                        if (countShips2 != 0) {
                            if (isRequiredField(i, j) && isRequiredField(i + 1, j)) {
                                try {
                                    setTwo(i, j, i + 1, j);
                                    countShips--;
                                    countShips2--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            } else if (isRequiredField(i, j) && isRequiredField(i, j + 1)) {
                                try {
                                    setTwo(i, j, i, j - 1);
                                    countShips--;
                                    countShips2--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            }
                        }
                    } else if (rage == 3) {
                        if (countShips3 != 0) {
                            if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j)) {
                                try {
                                    setThree(i, j, false, false);
                                    countShips3--;
                                    countShips--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2)) {
                                try {
                                    setThree(i, j, true, false);
                                    countShips3--;
                                    countShips--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            }
                        }
                    } else if (rage == 4) {
                        if (countShips4 != 0) {
                            if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j) && isRequiredField(i + 3, j)) {
                                try {
                                    setFour(i, j, false, false);
                                    countShips4--;
                                    countShips--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2) && isRequiredField(i, j + 3)) {
                                try {
                                    setFour(i, j, true, false);
                                    countShips4--;
                                    countShips--;
                                } catch (IndexOutOfBoundsException ignored) {
                                }
                            }
                        }
                    }
                }
            }
        }
        viewField();
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
        try {
            if (field[i][j] == 0) {
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
                } else
                    return field[i - 1][j - 1] == 0 && field[i][j - 1] == 0 && field[i + 1][j - 1] == 0 && field[i + 1][j] == 0 && field[i + 1][j + 1] == 0
                            && field[i][j + 1] == 0 && field[i - 1][j + 1] == 0 && field[i - 1][j] == 0;
            } else return false;
        } catch (IndexOutOfBoundsException indexOut) {
            return false;
        }
        return false;
    }

    private void setOne(int i, int j) {
        field[i][j] = 1;
        shipList.add(new Ship(i, j, 0, 1, 1));
    }

    private void setTwo(int i, int j, int i1, int j1) {
        field[i][j] = 2;
        field[i1][j1] = 2;
        if (i < i1 && j == j1) shipList.add(new Ship(i, j, 0, 1, 2));
        else if (i == i1 && j < j1) shipList.add(new Ship(i, j, 1, 0, 2));
    }

    private void setThree(int i, int j, boolean isVertical, boolean isMinus) {
        if (isVertical) {
            shipList.add(new Ship(i, j, 1, 0, 3));
            for (int t = 0; t < 3; t++) {
                field[i][j] = 3;
                i++;
            }
        } else {
            shipList.add(new Ship(i, j, 0, 1, 3));
            for (int t = 0; t < 3; t++) {
                field[i][j] = 3;
                j++;
            }
        }
    }

    private void setFour(int i, int j, boolean isVertical, boolean isMinus) {
        if (isVertical) {
            shipList.add(new Ship(i, j, 1, 0, 4));
            for (int t = 0; t < 4; t++) {
                field[i][j] = 4;
                i++;
            }
        } else {
            shipList.add(new Ship(i, j, 0, 1, 4));
            for (int t = 0; t < 4; t++) {
                field[i][j] = 4;
                j++;
            }
        }

    }

//    public int[][] berega() {
//        return fullField();
//    }

    public List<Ship> berega() {
        fullBereg();
        shipList.sort(GameUntil.COMPARE_BY_DECKS);
        return shipList;
    }

    public List<Ship> halfField() {
        fullField();
        shipList.sort(GameUntil.COMPARE_BY_DECKS);
        return shipList;
    }

    public int[][] fullBereg() throws IndexOutOfBoundsException {
        int countShips1 = 4;
        int countShips2 = 3;
        int countShips3 = 2;
        int countShips4 = 1;
        int countShips = 10;
        int rage;
        field = new int[10][10];
        for (int[] ints : field) {
            Arrays.fill(ints, 0);
        }
        while (countShips != 0) {
            int i = (int) (Math.random() * 9);
            int j = (int) (Math.random() * 9);
            rage = 1 + (int) (Math.random() * 4);
            if (rage == 1) {
                if (countShips1 != 0) {
                    if (isRequiredField(i, j)) {
                        setOne(i, j);
                        countShips--;
                        countShips1--;
                    }
                }
            } else if (rage == 2) {
                if (countShips2 != 0) {
                    if (isRequiredField(i, j) && isRequiredField(i + 1, j)) {
                        setTwo(i, j, i + 1, j);
                        countShips--;
                        countShips2--;
                    } else if (isRequiredField(i, j) && isRequiredField(i, j + 1)) {
                        setTwo(i, j, i, j - 1);
                        countShips--;
                        countShips2--;
                    }
                }
            } else if (rage == 3) {
                if (countShips3 != 0) {
                    if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j)) {
                        setThree(i, j, false, false);
                        countShips3--;
                        countShips--;
                    } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2)) {
                        setThree(i, j, true, false);
                        countShips3--;
                        countShips--;
                    }
                }
            } else if (rage == 4) {
                if (countShips4 != 0) {
                    if (isRequiredField(i, j) && isRequiredField(i + 1, j) && isRequiredField(i + 2, j) && isRequiredField(i + 3, j)) {
                        setFour(i, j, false, false);
                        countShips4--;
                        countShips--;
                    } else if (isRequiredField(i, j) && isRequiredField(i, j + 1) && isRequiredField(i, j + 2) && isRequiredField(i, j + 3)) {
                        setFour(i, j, true, false);
                        countShips4--;
                        countShips--;
                    }
                }
            }
        }

        viewField();
        return field;
    }

    private boolean isRequired(int i, int j) {
        return (field[i][j] == 0);
    }


//    public int[][] halfField() {
//        return fullField();
//    }
}
