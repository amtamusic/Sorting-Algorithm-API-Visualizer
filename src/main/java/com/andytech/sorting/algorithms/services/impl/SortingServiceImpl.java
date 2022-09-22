package com.andytech.sorting.algorithms.services.impl;

import com.andytech.sorting.algorithms.pojos.response.SortingResponse;
import com.andytech.sorting.algorithms.services.SortingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {

    //Bubble Sort
    @Override
    public SortingResponse<Integer> bubbleSort(ArrayList<Integer> input, String order, boolean returnSteps) {
        //validate input
        if(input == null || input.size() == 0){
            return new SortingResponse<>(null,null,null,"Input is null or empty",null,null,null,null);
        }
        //Initialize response object
        SortingResponse<Integer> response = new SortingResponse<>();
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        response.setAlgorithm("Bubble Sort");
        response.setItemsToSort(copyList(input));
        steps.add(copyList(input));
        response.setNumSteps(0L);
        //Record start time
        long start = System.currentTimeMillis();
        //Sort
        for (int index1 = 0; index1 < input.size() - 1; index1++) {
            //If the list is already sorted, break out of the loop
            for (int index2 = index1 + 1; index2 < input.size(); index2++) {
                //If the list is in ascending order, swap if the first element is greater than the second
                if (order.equals("asc")) {
                    if (input.get(index1) > input.get(index2)) {
                        Collections.swap(input, index1, index2);
                        steps.add(copyList(input));
                        response.setNumSteps(response.getNumSteps() + 1);
                    }
                } else {
                    if (input.get(index1) < input.get(index2)) {
                        Collections.swap(input, index1, index2);
                        steps.add(copyList(input));
                        response.setNumSteps(response.getNumSteps() + 1);
                    }
                }
            }
        }
        //Record end time
        long end = System.currentTimeMillis();
        //If the user wants to see the steps, add them to the response
        if (returnSteps) {
            response.setSteps(steps);
        }
        response.setMessage("Sorting Completed");
        response.setTimeTakenMillis(end - start);
        //Add the sorted list to the response
        response.setSorted(input);
        response.setInputSize((long) input.size());
        return response;
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> list) {
        return (new ArrayList<>(List.copyOf(list)));
    }
}
