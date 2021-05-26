package br.com.nttdata.devtest.domain.helper;

import br.com.nttdata.devtest.domain.models.types.SudokuSelections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SudokuSelectionsHelper {
    public static List<String> getStringList() {
        return Arrays.stream(SudokuSelections.values()).map(
                value -> value.name()
        ).collect(Collectors.toList());
    }

    public static SudokuSelections getRandomChoice() {
        int order = new Random().nextInt(SudokuSelections.values().length);
        return SudokuSelections.values()[order];
    }
}
