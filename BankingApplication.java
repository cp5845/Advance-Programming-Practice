public class BankingApplication {
    private static class BankingTask implements Runnable {
        private final String activity;
        private final int intervalMillis;

        BankingTask(String activity, int intervalMillis) {
            this.activity = activity;
            this.intervalMillis = intervalMillis;
        }

        @Override
        public void run() {
            for (int count = 1; count <= 3; count++) {
                System.out.println(Thread.currentThread().getName()
                        + " - " + activity + " (execution " + count + ")");
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
        Thread transactionThread = new Thread(
                new BankingTask("Processing transaction", 700));
        Thread balanceThread = new Thread(
                new BankingTask("Updating account balance", 1000));
        Thread smsThread = new Thread(
                new BankingTask("Sending SMS notification", 1300));

        transactionThread.setName("Transaction Processor");
        balanceThread.setName("Balance Updater");
        smsThread.setName("SMS Notifier");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();

        transactionThread.join();
        balanceThread.join();
        smsThread.join();
        System.out.println("Banking activities completed.");
    }
}
