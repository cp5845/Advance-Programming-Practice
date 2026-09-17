public class OnlineExamination {
    private static class ExaminationTask implements Runnable {
        private final String activity;
        private final int intervalMillis;
        private final int repetitions;

        ExaminationTask(String activity, int intervalMillis, int repetitions) {
            this.activity = activity;
            this.intervalMillis = intervalMillis;
            this.repetitions = repetitions;
        }

        @Override
        public void run() {
            for (int count = 1; count <= repetitions; count++) {
                System.out.println(Thread.currentThread().getName()
                        + " - " + activity + " (update " + count + ")");
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
        Thread timerThread = new Thread(
                new ExaminationTask("Displaying remaining time", 1000, 5));
        Thread autoSaveThread = new Thread(
                new ExaminationTask("Auto-saving student answers", 1500, 4));
        Thread networkThread = new Thread(
                new ExaminationTask("Checking network connection", 2000, 3));

        timerThread.setName("Time Monitor");
        autoSaveThread.setName("Auto-Save Service");
        networkThread.setName("Network Checker");

        timerThread.start();
        autoSaveThread.start();
        networkThread.start();

        timerThread.join();
        autoSaveThread.join();
        networkThread.join();
        System.out.println("Online examination tasks completed.");
    }
}
