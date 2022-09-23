package com.andytech.sorting.algorithms.services;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith( SpringRunner.class )
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SortingServiceTest {

    @Autowired
    private SortingService sortingService;

    @Test
    public void selectionSortNullTest() {
        assert(sortingService.selectionSort(null, null, false) != null);
    }

    @Test
    public void selectionSortAscTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSorted().toString().equals("[1, 5, 6, 7, 11]"));
    }

    @Test
    public void selectionSortDescTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "desc", false).getSorted().toString().equals("[11, 7, 6, 5, 1]"));
    }

    @Test
    public void selectionSortStepsTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", true).getSteps().size() > 0);
    }

    @Test
    public void selectionSortStepsNullTest() {
        assert(sortingService.selectionSort(new ArrayList<>(Arrays.asList(5,7,6,11,1)), "asc", false).getSteps() == null);
    }

}
