package com.atguigu.demo;

import java.util.LinkedList;
import java.util.Queue;

public class TruckTransportation {
    public int minNumberOfTrips(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int trips = 0; // 记录行程数
        int currentWeight = 0; // 当前卡车载重
        int currentBoxes = 0; // 当前卡车装载的集装箱数量
        int currentPort = 0; // 当前卡车所在的码头编号

        Queue<Integer>[] queues = new LinkedList[portsCount]; // 每个码头对应的集装箱队列
        for (int i = 0; i < portsCount; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int[] box : boxes) {
            int port = box[0] - 1; // 码头编号从0开始
            int weight = box[1];

            // 将集装箱加入对应码头的队列
            queues[port].offer(weight);
        }

        while (true) {
            if (currentBoxes == 0 && currentWeight == 0) {
                // 卡车处于空闲状态，从仓库出发，选择下一个需要运送的集装箱
                int nextPort = findNextPort(queues);
                if (nextPort == -1) {
                    // 所有集装箱都已经送达，结束循环
                    break;
                }
                currentPort = nextPort;
            }

            // 根据载重和箱数限制，装载集装箱
            while (!queues[currentPort].isEmpty() && currentWeight + queues[currentPort].peek() <= maxWeight && currentBoxes < maxBoxes) {
                int weight = queues[currentPort].poll();
                currentWeight += weight;
                currentBoxes++;
            }

            // 发送卡车到当前码头
            trips++;

            // 如果当前码头队列为空或者当前卡车装满了，返回仓库
            if (queues[currentPort].isEmpty() || currentBoxes == maxBoxes) {
                currentWeight = 0;
                currentBoxes = 0;
            }
        }

        return trips;
    }

    // 查找下一个需要送货的码头
    private int findNextPort(Queue<Integer>[] queues) {
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                return i;
            }
        }
        return -1; // 所有码头队列都为空
    }

    public static void main(String[] args) {
        TruckTransportation solution = new TruckTransportation();

        int[][] boxes1 = {{1,1},{2,1},{1,1}};
        int portsCount1 = 2;
        int maxBoxes1 = 3;
        int maxWeight1 = 3;
        System.out.println(solution.minNumberOfTrips(boxes1, portsCount1, maxBoxes1, maxWeight1));  // Output: 4

        int[][] boxes2 = {{1,2},{3,3},{3,1},{3,1},{2,4}};
        int portsCount2 = 3;
        int maxBoxes2 = 3;
        int maxWeight2 = 6;
        System.out.println(solution.minNumberOfTrips(boxes2, portsCount2, maxBoxes2, maxWeight2));  // Output: 6

        int[][] boxes3 = {{1,4},{1,2},{2,1},{2,1},{3,2},{3,4}};
        int portsCount3 = 3;
        int maxBoxes3 = 6;
        int maxWeight3 = 7;
        System.out.println(solution.minNumberOfTrips(boxes3, portsCount3, maxBoxes3, maxWeight3));  // Output: 6
    }
}
