public class SmartTrafficManagement {
    private static class TrafficJunction extends Thread {
        private final String junctionName;
        private final String trafficStatus;
        private final int intervalMillis;

        TrafficJunction(String junctionName, String trafficStatus, int intervalMillis) {
            this.junctionName = junctionName;
            this.trafficStatus = trafficStatus;
            this.intervalMillis = intervalMillis;
        }

        @Override
        public void run() {
            for (int count = 1; count <= 3; count++) {
                System.out.println(Thread.currentThread().getName()
                        + " - " + junctionName + ": " + trafficStatus
                        + " (report " + count + ")");
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread junctionOne = new TrafficJunction(
                "Central Avenue Junction", "Heavy traffic", 700);
        Thread junctionTwo = new TrafficJunction(
                "Market Street Junction", "Moderate traffic", 1000);
        Thread junctionThree = new TrafficJunction(
                "Airport Road Junction", "Light traffic", 1300);

        junctionOne.setName("Junction 1 Monitor");
        junctionTwo.setName("Junction 2 Monitor");
        junctionThree.setName("Junction 3 Monitor");

        junctionOne.start();
        junctionTwo.start();
        junctionThree.start();

        junctionOne.join();
        junctionTwo.join();
        junctionThree.join();
        System.out.println("Traffic monitoring completed.");
    }
}
