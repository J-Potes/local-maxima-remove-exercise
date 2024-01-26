package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        //put your code here
    	int[] indexLocalM = new int[array.length];
    	int contLM = 0;
    	
    	for(int i = 0; i < array.length; i++) {
    		if(i == 0) {
    			if(array[i] > array[i+1]) {
    				indexLocalM[contLM] = i;
    				contLM++;
    			}
    		}
    		else if(i == (array.length - 1)) {
    			if(array[i] > array[i-1]) {
    				indexLocalM[contLM] = i;
    				contLM++;
    			}
    		}
    		else {
    			if((array[i] > array[i+1]) && (array[i] > array[i-1])) {
    				indexLocalM[contLM] = i;
    				contLM++;
    			}
    		}
    	}
    	
    	int[] newIndex = Arrays.copyOf(indexLocalM, contLM); 
    	int[] newArray = new int[array.length - contLM];
    	
    	int contAux = 0;
    	for(int i = 0; i < array.length; i++) {
    		if(Arrays.binarySearch(newIndex, i) < 0) {
    			newArray[contAux] = array[i];
    			contAux++;
    		}
    	}
    	
    	return newArray;
    }
}
