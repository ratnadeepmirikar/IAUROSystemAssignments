package com.code1;

/*Q1. Use Case: Shipping Company Optimization Background A shipping company needs to efficiently allocate various shipments into available containers. Each shipment consists of a specific number of units, 
and each container has a maximum capacity of units it can hold. The goal is to determine the minimum number of containers required to accommodate all shipments, even if units from the same shipment are split 
across multiple containers. Scenario
Company: SwiftLogistics
Shipments: The company has n shipments to be delivered. Each shipment 
consists of a different number of units. This is represented by the array 
shipments where shipments[i] indicates the number of units in the i-
th shipment.
Containers: The company also has m containers available for use, each 
with a specific capacity. This is represented by the array 
container_limits where container_limits[j] indicates the 
maximum number of units that the j-th container can hold.
Problem
The operations team at SwiftLogistics needs to figure out the minimum 
number of containers required to redistribute the units from all shipments 
into the available containers.
Example
Inputs:
* shipments = [10, 20, 30]
* container_limits = [15, 15, 20, 10]
Output:
* Minimum number of containers needed: 4
* If there is an insufficient container_limit the function should return -1.
Explanation
1. The first container (15 units) can take 10 units from the first shipment 
and 5 units from the second shipment.
2. The second container (15 units) can take the remaining 15 units from 
the second shipment.
3. The third container (20 units) can take the entire third shipment of 30 
units, but since it exceeds its capacity, the fourth container (10 units) 
can be used to accommodate the remaining 10 units.
Thus, the minimum number of containers needed is 4.
Note: You just need to write the required function for the problem, 
and you must take two arrays as input parameters to the function. 
Answer:*/
import java.util.Arrays;

public class ShippingOptimization {
public static int minContainers(int[] shipments, int[] containerLimits) {
Arrays.sort(shipments);
  Arrays.sort(containerLimits);
int n = shipments.length;
int m = containerLimits.length;

          for (int i = 0; i < n / 2; i++) {
            int temp = shipments[i];
            shipments[i] = shipments[n - i - 1];
            shipments[n - i - 1] = temp;
        }
        for (int i = 0; i < m / 2; i++) {
            int temp = containerLimits[i];
            containerLimits[i] = containerLimits[m - i - 1];
            containerLimits[m - i - 1] = temp;
        }
        
        int containerCount = 0;
        int containerIndex = 0;

        for (int shipment : shipments) {
            while (shipment > 0) {
                if (containerIndex >= m) {
                   
                    return -1;
                }

                if (containerLimits[containerIndex] >= shipment) {
                    containerLimits[containerIndex] -= shipment;
                    shipment = 0;
                } else {
                    shipment -= containerLimits[containerIndex];
                    containerLimits[containerIndex] = 0;
                }

                if (containerLimits[containerIndex] == 0) {
                    containerCount++;
                    containerIndex++;
                }
            }
        }

        return containerCount;
    }

    public static void main(String[] args) {
        int[] shipments = {10, 20, 30};
        int[] containerLimits = {15, 15, 20, 10};

        int result = minContainers(shipments, containerLimits);
        System.out.println("Minimum number of containers needed: " + result);
    }
  }

